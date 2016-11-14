package musicapi.hernegren.controller;

import musicapi.hernegren.function.RestResponseMaker;
import musicapi.hernegren.function.SearchResponseMakerImpl;
import musicapi.hernegren.model.SearchResponse;
import musicapi.hernegren.model.SingleArtistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magnus on 2016-11-13.
 */
@Controller
public class MusicController {
    @Autowired
    RestResponseMaker rr;
    @Autowired
    SearchResponseMakerImpl sr;

    @RequestMapping(value = "/artist/{mbid}")
    public String getArtistPage(@PathVariable String mbid, ModelMap modelMap) {

        SingleArtistResponse singleArtistResponse = rr.collectArtistInfo(mbid);
        if (singleArtistResponse == null) {
            return "error";
        }
        modelMap.addAttribute(singleArtistResponse);
        return "artist";

    }


    @RequestMapping(value = "/search/")
    public String getSearchPage(@RequestParam("q") String searchterm, ModelMap modelMap) {

        List<SearchResponse> searchResult = sr.getSearchResponse(searchterm) ;
        modelMap.addAttribute("resultList",searchResult);
        return "search";

    }

    @RequestMapping(value = "/")
    public String getHomepage(ModelMap modelMap) {
        List<SearchResponse> searchResult = new ArrayList<>();
        modelMap.addAttribute("resultList",searchResult);
        return "home";

    }



}
