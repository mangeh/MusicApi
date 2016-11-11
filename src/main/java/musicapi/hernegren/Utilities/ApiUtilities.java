package musicapi.hernegren.Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Magnus on 2016-11-11.
 */
public class ApiUtilities {

    public ResponseEntity<Object> getJsonToObject(String url, Class model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response =
                restTemplate.getForEntity(url, model);
        return response;
    }

    public String ApiFetchUtility(String url) {
        StringBuffer response = null;
        URL obj = null;
        try {
            obj = new URL(url);
        } catch (MalformedURLException mue) {

        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "MusicBrainzFetcher/1.1.0-SNAPSHOT(mangehl@gmail.com)");
        } catch (IOException pe) {
            pe.printStackTrace();
        }
        BufferedReader in = null;

        try {
            in = getFileStream(con);
        } catch (IOException io) {
            io.printStackTrace();
        }
        if (in == null) return null;
        String inputLine;
        response = new StringBuffer();
        try {
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception ex) {
            //TODO log
            ex.printStackTrace();
            return null;
        }
        if (response == null) {
            return null;
        }
        return response.toString();
    }

    private BufferedReader getFileStream(HttpURLConnection con) throws IOException {
        BufferedReader in;
        InputStreamReader input = new InputStreamReader(con.getInputStream());
        in = new BufferedReader(
                input);
        return in;
    }

    public Object pojoMapper(String jsonResponse, Class pojoClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object mappedObject = null;
        if (jsonResponse != null) {
            try {
                mappedObject = objectMapper.readValue(jsonResponse, pojoClass);
            } catch (IOException ioe) {
                //TODO Log error
                ioe.printStackTrace();
            }

        }
        return mappedObject;
    }

    public String getWikiUrl(String url) {
        Pattern wikiPattern = Pattern.compile("/wiki/(.*)");
        Matcher matcher = wikiPattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "Not found";
        }
    }
}
