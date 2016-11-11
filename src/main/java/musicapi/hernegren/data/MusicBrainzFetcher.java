package musicapi.hernegren.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import musicapi.hernegren.Utilities.ApiUtilities;
import musicapi.hernegren.model.musicbrainz.MbzResponse;

/**
 * Created by Magnus on 2016-11-11.
 */
public class MusicBrainzFetcher {


    private ObjectMapper objectMapper;
    private ApiUtilities apiUtilities;

    public MusicBrainzFetcher(ObjectMapper objectMapper, ApiUtilities apiUtilities) {
        this.objectMapper = objectMapper;
        this.apiUtilities = apiUtilities;
    }

    public MbzResponse getArtistInfo(String mbId) {

        String url = "http://musicbrainz.org/ws/2/artist/" + mbId + "?&fmt=json&inc=url-rels+release-groups";
        String response = apiUtilities.ApiFetchUtility(url);
        MbzResponse mbzResponse = null;
        mbzResponse = (MbzResponse) apiUtilities.getJsonToObject(url, MbzResponse.class).getBody();
//        try {
//            mbzResponse = objectMapper.readValue(response, MbzResponse.class);
//        } catch (IOException ioe) {
//            //TODO Log error
//            ioe.printStackTrace();
//        }
        return mbzResponse;
    }


}
