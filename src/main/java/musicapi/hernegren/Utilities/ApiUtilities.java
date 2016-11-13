package musicapi.hernegren.utilities;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Magnus on 2016-11-11.
 */
@Component
public class ApiUtilities {


    public String getWikiUrl(String url) {
        Pattern wikiPattern = Pattern.compile("/wiki/(.*)");
        Matcher matcher = wikiPattern.matcher(url);
        if (matcher.find()) {
            return "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&redirects=true&titles="+matcher.group(1);
        } else {
            return "Not found";
        }
    }
}
