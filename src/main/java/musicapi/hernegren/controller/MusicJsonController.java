package musicapi.hernegren.controller;

import musicapi.hernegren.function.RestResponseMaker;
import musicapi.hernegren.model.SingleArtistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to get JSON response
 * Created by Magnus on 2016-11-11.
 */
@RestController
public class MusicJsonController {

    @Autowired
    RestResponseMaker rr;

    @RequestMapping(value = "/rest/{mbid}", produces = "application/json")
    public SingleArtistResponse getResponse(@PathVariable String mbid) {
        SingleArtistResponse singleArtistResponse = rr.collectArtistInfo(mbid);
        return singleArtistResponse;

    }
}
