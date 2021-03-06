package musicapi.hernegren.data;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * Created by Magnus on 2016-11-12.
 */
@Service
public class DataFetcher {

    Logger logger = Logger.getLogger(DataFetcher.class);

    @Autowired
    private RestTemplate restTemplate;


    public DataFetcher() {
    }

    @Async
    public <T>Future<T> fetchDataForUrl(String url, Class modelClass) {
        ResponseEntity<T> response = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-agent", "MusicApi/1.1.0-SNAPSHOT ( magnus@hernegren.com )");


            try {
                response =
                        restTemplate.<T>getForEntity(url,modelClass,httpHeaders);
            } catch (HttpClientErrorException http) {
                logger.warn("Faulty response: " + http);
                return null;
            }
            return new AsyncResult<>(response.getBody());

    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
