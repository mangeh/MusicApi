package musicapi.hernegren.function;

import musicapi.hernegren.model.SingleArtistResponse;

/**
 * Created by Magnus on 2016-11-12.
 */
public interface RestResponseMaker  {
    SingleArtistResponse collectArtistInfo(String mbid);

}
