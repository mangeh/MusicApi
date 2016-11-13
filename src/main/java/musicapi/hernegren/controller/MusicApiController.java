package musicapi.hernegren.controller;

import musicapi.hernegren.function.RestResponseMaker;
import musicapi.hernegren.model.FormattedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Magnus on 2016-11-11.
 */
@RestController
public class MusicApiController {

    @Autowired
    RestResponseMaker rr;

    @RequestMapping(value = "/rest/{mbid}", produces = "application/json")
    public FormattedResponse getResponse(@PathVariable String mbid) {
        FormattedResponse formattedResponse = rr.collectArtistInfo(mbid);
        return formattedResponse;

    }
}
