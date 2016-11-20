package musicapi.hernegren.utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jayway.jsonpath.Filter.filter;
import static javafx.scene.input.KeyCode.M;
import static org.apache.coyote.http11.Constants.a;

/**
 * Created by Magnus on 2016-11-11.
 */
@Component
public class ApiUtilities {

    private String returnString;

    //Regex to find the url
    public String getWikiUrl(String url) {
        Pattern wikiPattern = Pattern.compile("/wiki/(.*)");
        Matcher matcher = wikiPattern.matcher(url);
        if (matcher.find()) {
            return "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&redirects=true&titles=" + matcher.group(1);
        } else {
            return "Not found";
        }
    }


    //Finds a specific key in a json map and returns its value
    public <T> String findFirstJsonValue(String jsonObject, String tagToFind) {
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonObject);
        List<String> ret = null;
        ret = JsonPath.read(document,"$.."+tagToFind);
        return ret.get(0);
    }


}
