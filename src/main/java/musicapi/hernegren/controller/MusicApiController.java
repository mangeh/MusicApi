package musicapi.hernegren.controller;

import musicapi.hernegren.function.RestResponse;
import musicapi.hernegren.model.FormattedResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Magnus on 2016-11-11.
 */
@RestController
public class MusicApiController {


    @RequestMapping(value = "/rest/{mbid}", produces = "application/json")
    public FormattedResponse getResponse(@PathVariable String mbid) {
        FormattedResponse artistResponse = new FormattedResponse();
        RestResponse rr = new RestResponse();
        FormattedResponse formattedResponse = rr.collectArtistInfo(mbid);
        artistResponse.setArtistName("Nirvana");
        artistResponse.setBio("Great band");
        return formattedResponse;

    }
}
