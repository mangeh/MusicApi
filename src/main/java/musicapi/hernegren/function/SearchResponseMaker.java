package musicapi.hernegren.function;

import musicapi.hernegren.model.SearchResponse;

import java.util.List;

/**
 * Created by Magnus on 2016-11-13.
 */

public interface SearchResponseMaker {

    public List<SearchResponse> getSearchResponse(String query);
}
