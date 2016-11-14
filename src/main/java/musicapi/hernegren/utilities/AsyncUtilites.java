package musicapi.hernegren.utilities;

import musicapi.hernegren.data.DataFetcher;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Magnus on 2016-11-13.
 */
@Component
public class AsyncUtilites {

    Logger logger = Logger.getLogger(AsyncUtilites.class);

    @Autowired
    DataFetcher dataFetcher;

    public Future<Object> getFutureFromUrl(String url, Class model) {
        Future<Object> futureObj = dataFetcher.fetchDataForUrl(url, model);
        if (futureObj != null) {
            return futureObj;
        } else {
            logger.warn("No response retreived for " + url);
        }
        return null;
    }

    public Object getObjFromUrl(String url, Class model) {
        logger.info("Getting response for url " +url);
        Future<Object> futureObj = dataFetcher.fetchDataForUrl(url, model);
        Object returnObject = null;
        if (futureObj != null) {
            waitUntilDone(futureObj);
            returnObject = futureToObject(futureObj);
        } else {
            logger.info("No response retreived for " + url);
        }
        return returnObject;
    }


    public Object futureToObject(Future<Object> futureObj) {
        Object returnObject = null;
        try {
            returnObject = futureObj.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return returnObject;
    }

    public void waitUntilDone(Future<Object> futureObj) {

        while (!futureObj.isDone()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
