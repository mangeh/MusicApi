package musicapi.hernegren.function;

import musicapi.hernegren.data.DataFetcher;
import musicapi.hernegren.model.Album;
import musicapi.hernegren.model.FormattedResponse;
import musicapi.hernegren.model.coverart.CoverArtResponse;
import musicapi.hernegren.model.musicbrainz.MbzResponse;
import musicapi.hernegren.model.musicbrainz.Relation;
import musicapi.hernegren.utilities.ApiUtilities;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Magnus on 2016-11-11.
 */
@Component
@Configurable
@Repository("artists")
public class RestResponseMakerImpl implements RestResponseMaker {

    Logger logger = Logger.getLogger(RestResponseMakerImpl.class);

    @Autowired
    DataFetcher dataFetcher;
    @Autowired
    ApiUtilities apiUtilities;


    public RestResponseMakerImpl() {
    }


    @Override
    @Cacheable("artistResponses")
    public FormattedResponse collectArtistInfo(String mbid) {
        FormattedResponse response = new FormattedResponse();

        MbzResponse mbz = (MbzResponse) getObjectFromFuture("http://musicbrainz.org/ws/2/artist/" + mbid + "?&fmt=json&inc=url-rels+release-groups", MbzResponse.class, dataFetcher);
        try {
            response.setId(mbz.getId());
            response.setArtistName(mbz.getName());
            response.setAlbumList(getAlbumList(mbz));
            response.setBio(getWikiText(apiUtilities, response, mbz));
        } catch (NullPointerException ne) {
            logger.warn("Something wrong with response objects " + ne);
        }

        return response;
    }

    private Object getObjectFromFuture(String url, Class model, DataFetcher dataFetcher) {
        Future<Object> futureObj = dataFetcher.fetchDataForUrl(url, model);
        Object returnObject = null;
        if (futureObj != null) {
            waitUntilDone(futureObj);
            returnObject = futureToObject(futureObj);
        } else {
            logger.warn("No response retreived for " + url);
        }
        return returnObject;
    }

    private Object futureToObject(Future<Object> futurembz) {
        Object returnObject = null;
        try {
            returnObject = futurembz.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return returnObject;
    }

    private void waitUntilDone(Future<Object> futureObj) {

        while (!futureObj.isDone()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private String getWikiText(ApiUtilities apiUtilities, FormattedResponse response, MbzResponse mbz) {
        String biography = null;
        for (Relation relation : mbz.getRelations()) {
            if (relation.getType().equals("wikipedia")) {
//                Object futureResponse2 = dataFetcher.fetchDataForUrl(apiUtilities.getWikiUrl(relation.getUrl().getResource()), JSONObject.class);
                Future<Object> futureResponse = dataFetcher.fetchDataForUrl(apiUtilities.getWikiUrl(relation.getUrl().getResource()), JSONObject.class);
                waitUntilDone(futureResponse);
                JSONObject jsonObject = (JSONObject) futureToObject(futureResponse);
//                JSONObject jsonObject = (JSONObject) futureResponse;
                biography = findJsonValue(jsonObject);
            }
        }
        return biography;
    }

    private String findJsonValue(Map jsonObject) {
        Iterator<?> keys = jsonObject.keySet().iterator();

        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object value = jsonObject.get(key);
            if (key.equals("extract")) {
                return value.toString();
            }

            if (value instanceof Map) {
                return findJsonValue((Map) value);
            }

        }
        return null;
    }


    private List<Album> getAlbumList(MbzResponse mbz) {
        List<Album> albumList = new ArrayList<>();
        mbz.getReleaseGroups().forEach(relation -> {
            Album album = new Album();
            album.setId(relation.getId());
            album.setTitle(relation.getTitle());
            CoverArtResponse artResponse = (CoverArtResponse) getObjectFromFuture("http://coverartarchive.org/release-group/" + relation.getId(), CoverArtResponse.class, dataFetcher);
            if (artResponse != null && artResponse.getImages().size() > 0) {
                album.setImageUrl(artResponse.getImages().get(0).getImage());
            }
            albumList.add(album);
        });
        return albumList;
    }

}
