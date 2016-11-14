package musicapi.hernegren.function;

import musicapi.hernegren.data.DataFetcher;
import musicapi.hernegren.model.Album;
import musicapi.hernegren.model.SingleArtistResponse;
import musicapi.hernegren.model.coverart.CoverArtResponse;
import musicapi.hernegren.model.musicbrainz.MbzResponse;
import musicapi.hernegren.model.musicbrainz.Relation;
import musicapi.hernegren.utilities.ApiUtilities;
import musicapi.hernegren.utilities.AsyncUtilites;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by Magnus on 2016-11-11.
 */
@Component
@Configurable
@Repository("artists")
//@EnableAsync
public class RestResponseMakerImpl implements RestResponseMaker {

    Logger logger = Logger.getLogger(RestResponseMakerImpl.class);

    @Autowired
    DataFetcher dataFetcher;
    @Autowired
    ApiUtilities apiUtilities;
    @Autowired
    AsyncUtilites asyncUtilites;


    public RestResponseMakerImpl() {
    }

    @Override
    @Cacheable(cacheNames = "artistResponses", unless = "#result == null || #result.id == null")
    public SingleArtistResponse collectArtistInfo(String mbid) {
        SingleArtistResponse response = new SingleArtistResponse();

        MbzResponse mbz = (MbzResponse) asyncUtilites.getObjFromUrl("http://80.216.142.71:5000/ws/2/artist/" + mbid + "?&fmt=json&inc=url-rels+release-groups", MbzResponse.class);

        try {
            response.setId(mbz.getId());
            response.setArtistName(mbz.getName());
            response.setAlbumList(getAlbumList(mbz));
            response.setBio(getWikiText(apiUtilities, response, mbz));
        } catch (NullPointerException ne) {
            logger.warn("Something wrong with response objects " + ne);
            return null;
        }

        return response;
    }

    private String getWikiText(ApiUtilities apiUtilities, SingleArtistResponse response, MbzResponse mbz) {

        String biography = null;
        for (Relation relation : mbz.getRelations()) {
            if (relation.getType().equals("wikipedia")) {
                Future<Object> futureResponse = dataFetcher.fetchDataForUrl(apiUtilities.getWikiUrl(relation.getUrl().getResource()), HashMap.class);
                asyncUtilites.waitUntilDone(futureResponse);
                HashMap<String, String> jsonObject = (HashMap<String, String>) asyncUtilites.futureToObject(futureResponse);
                biography = apiUtilities.findJsonValue(jsonObject, "extract");
            }
        }
        return biography;
    }

    private List<Album> getAlbumList(MbzResponse mbz) {
        List<Album> albumList = new ArrayList<>();
        Map<String, Future<Object>> albumCoverMap = new HashMap<>();
        Map<String, CoverArtResponse> albumUrlCoverMap = new HashMap<>();
        mbz.getReleaseGroups().forEach(alubm -> {
            Album album = new Album();
            album.setId(alubm.getId());
            album.setTitle(alubm.getTitle());
            albumCoverMap.put(alubm.getId(), asyncUtilites.getFutureFromUrl("http://coverartarchive.org/release-group/" + alubm.getId(), CoverArtResponse.class));
            albumList.add(album);
        });
        for (Map.Entry<String, Future<Object>> albumCoverEntry : albumCoverMap.entrySet()) {
            Future<Object> fObj = albumCoverEntry.getValue();
            asyncUtilites.waitUntilDone(fObj);
            albumUrlCoverMap.put(albumCoverEntry.getKey(), (CoverArtResponse) asyncUtilites.futureToObject(fObj));
        }
        for (Album album : albumList) {
            CoverArtResponse car = albumUrlCoverMap.get(album.getId());
            if (car != null) {
                //Assuming here that if there is a albumCoverObject, it has at least 1 image, prone to errors if the api should not live up to that expectation.
                album.setImageUrl(car.getImages().get(0).getImage());
                String thumbnail = car.getImages().get(0).getThumbnails().getLarge();
                album.setThumbnailUrl(thumbnail);

            }
        }

        return albumList;
    }

}
