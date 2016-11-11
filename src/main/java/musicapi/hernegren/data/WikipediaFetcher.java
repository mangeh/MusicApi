package musicapi.hernegren.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import musicapi.hernegren.Utilities.ApiUtilities;
import musicapi.hernegren.model.wikiarticle.WikiResponse;

/**
 * Created by Magnus on 2016-11-11.
 */
public class WikipediaFetcher {


    private ObjectMapper objectMapper;
    private ApiUtilities apiUtilities;

    public WikipediaFetcher(ObjectMapper objectMapper, ApiUtilities apiUtilities) {
        this.objectMapper = objectMapper;
        this.apiUtilities = apiUtilities;
    }


    public WikiResponse getWikipediaArticle(String searchTerm) {
        String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&redirects=true&titles=" + searchTerm;
        WikiResponse wikiResponse = new WikiResponse();
        wikiResponse = (WikiResponse) apiUtilities.pojoMapper(apiUtilities.ApiFetchUtility(url), WikiResponse.class);
        return wikiResponse;

    }
}
