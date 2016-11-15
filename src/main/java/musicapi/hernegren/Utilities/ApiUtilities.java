package musicapi.hernegren.utilities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String findJsonValue(HashMap<String,String> jsonObject, String tagToFind) {

        for (Map.Entry<String,String> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.equals(tagToFind)) {
                returnString = value.toString();
            } else if (value instanceof HashMap) {
                findJsonValue((HashMap<String,String>) value, tagToFind);
            }
            else if (value instanceof ArrayList) {
                 findJsonValue((ArrayList) value, tagToFind);
            }
        }
        return returnString;
    }

//    iterates through lists in the map
    private String findJsonValue(ArrayList jsonObject, String tagToFind) {
        for (Object json : jsonObject) {
            if (json instanceof HashMap) {
               return findJsonValue((HashMap<String, String>) json, tagToFind);
            }
            if (json instanceof ArrayList) {
                return findJsonValue((ArrayList) json, tagToFind);
            }
        }
        return returnString;
    }

//    public String findJsonValueAllMatches(Map jsonObject, String tagToFind, ArrayList resultMap, Class model) {
//        Iterator<?> keys = jsonObject.keySet().iterator();
//
//        while (keys.hasNext()) {
//            String key = (String) keys.next();
//            Object value = jsonObject.get(key);
//            if (key.equals(tagToFind)) {
//                resultMap.add(value.toString());
//            }
//
//            if (value instanceof Map) {
//                return findJsonValue((Map) value, tagToFind, textFound);
//            }
//
//        }
//        return null;
//    }



}
