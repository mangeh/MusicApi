package musicapi.hernegren.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import musicapi.hernegren.Utilities.ApiUtilities;
import musicapi.hernegren.model.coverart.CoverArtResponse;

/**
 * Created by Magnus on 2016-11-11.
 */
public class CoverArtArchiveFetcher {

    private ObjectMapper objectMapper;
    private ApiUtilities apiUtilities;

    public CoverArtArchiveFetcher(ObjectMapper objectMapper, ApiUtilities apiUtilities) {
        this.objectMapper = objectMapper;
        this.apiUtilities = apiUtilities;
    }

    public CoverArtResponse getCoverArt(String searchTerm) {
        String url = "http://coverartarchive.org/release-group/" + searchTerm;
        return (CoverArtResponse) apiUtilities.pojoMapper(apiUtilities.ApiFetchUtility(url), CoverArtResponse.class);
    }
}
