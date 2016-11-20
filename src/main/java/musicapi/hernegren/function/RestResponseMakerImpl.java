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
import java.util.List;
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
        //Get the response from the musicbrainz service
        MbzResponse mbz = (MbzResponse) asyncUtilites.getObjFromUrl("http://musicbrainz.org/ws/2/artist/" + mbid + "?&fmt=json&inc=url-rels+release-groups", MbzResponse.class);

        try {
            response.setId(mbz.getId());
            response.setArtistName(mbz.getName());
            response.setAlbumList(getAlbumList(mbz));
            response.setBio(getWikiText(mbz));
        } catch (NullPointerException ne) {
            logger.warn("Something wrong with response objects " + ne);
            return null;
        }

        return response;
    }
    //Find the wikipedia url from relations
    private String getWikiText(MbzResponse mbz) {

        String biography = null;
        for (Relation relation : mbz.getRelations()) {
            if (relation.getType().equals("wikipedia")) {
                Future<String> futureResponse = dataFetcher.fetchDataForUrl(apiUtilities.getWikiUrl(relation.getUrl().getResource()),String.class);
                asyncUtilites.waitUntilDone(futureResponse);
                String jsonObject = asyncUtilites.futureToObject(futureResponse);
                biography = apiUtilities.findFirstJsonValue(jsonObject, "extract");
            }
        }
        return biography;
    }

    private List<Album> getAlbumList(MbzResponse mbz) {
        List<Album> albumList = new ArrayList<>();
        mbz.getReleaseGroups().parallelStream().forEach(album -> {
            Album newalbum = new Album();
            newalbum.setId(album.getId());
            newalbum.setTitle(album.getTitle());
            CoverArtResponse art = asyncUtilites.getObjFromUrl("http://coverartarchive.org/release-group/" + album.getId(), CoverArtResponse.class);
            if (art != null) {
                newalbum.setImageUrl(art.getImages().get(0).getImage());
            }
            albumList.add(newalbum);
        });
        return albumList;
    }

}
