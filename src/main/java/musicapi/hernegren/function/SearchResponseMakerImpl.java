package musicapi.hernegren.function;

import musicapi.hernegren.model.SearchResponse;
import musicapi.hernegren.model.mbzsearch.Artist;
import musicapi.hernegren.model.mbzsearch.MbzSearch;
import musicapi.hernegren.model.musicbrainz.MbzResponse;
import musicapi.hernegren.utilities.AsyncUtilites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magnus on 2016-11-13.
 */
@Component
@Configurable
public class SearchResponseMakerImpl implements SearchResponseMaker {
    @Autowired
    private AsyncUtilites asyncUtilites;


    @Override
    public List<SearchResponse> getSearchResponse(String query) {
        List<SearchResponse> srList = new ArrayList<>();
        String url = "http://musicbrainz.org/ws/2/artist/?query=artist:" + query + "&fmt=json";
        MbzSearch mbzSearch = asyncUtilites.getObjFromUrl(url, MbzSearch.class);
        if (mbzSearch == null) {
            url = "http://musicbrainz.org/ws/2/artist/?query=artist:" + query + "&fmt=json";
            mbzSearch = asyncUtilites.getObjFromUrl(url, MbzSearch.class);
        }
        for (Artist artist : mbzSearch.getArtists()) {
            SearchResponse sr = new SearchResponse();
            sr.setId(artist.getId());
            sr.setName(artist.getName());
            srList.add(sr);
        }

        return srList;


    }
}
