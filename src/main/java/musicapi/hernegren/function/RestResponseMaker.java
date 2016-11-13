package musicapi.hernegren.function;

import musicapi.hernegren.model.FormattedResponse;

/**
 * Created by Magnus on 2016-11-12.
 */
public interface RestResponseMaker  {
    FormattedResponse collectArtistInfo(String mbid);

}
