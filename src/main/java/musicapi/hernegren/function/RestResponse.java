package musicapi.hernegren.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import musicapi.hernegren.Utilities.ApiUtilities;
import musicapi.hernegren.data.CoverArtArchiveFetcher;
import musicapi.hernegren.data.MusicBrainzFetcher;
import musicapi.hernegren.data.WikipediaFetcher;
import musicapi.hernegren.model.Album;
import musicapi.hernegren.model.FormattedResponse;
import musicapi.hernegren.model.coverart.CoverArtResponse;
import musicapi.hernegren.model.musicbrainz.MbzResponse;
import musicapi.hernegren.model.wikiarticle.WikiResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magnus on 2016-11-11.
 */
public class RestResponse {

    public FormattedResponse collectArtistInfo(String mbid) {
        ApiUtilities apiUtilities = new ApiUtilities();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        FormattedResponse response = new FormattedResponse();
        MusicBrainzFetcher mbf = new MusicBrainzFetcher(objectMapper, apiUtilities);
        WikipediaFetcher wf = new WikipediaFetcher(objectMapper, apiUtilities);
        CoverArtArchiveFetcher caf = new CoverArtArchiveFetcher(objectMapper, apiUtilities);
        MbzResponse mbz = mbf.getArtistInfo(mbid);

        List<Album> albumList = new ArrayList<>();
        mbz.getReleaseGroups().forEach(relation -> {
            Album album = new Album();
            album.setId(relation.getId());
            album.setTitle(relation.getTitle());
            CoverArtResponse artResponse = caf.getCoverArt(relation.getId());
            if (artResponse != null && artResponse.getImages().size() > 0) {
                album.setImageUrl(artResponse.getImages().get(0).getImage());
            }
            albumList.add(album);
        });
        response.setAlbumList(albumList);
        mbz.getRelations().forEach(relation -> {
            if (relation.getType().equals("wikipedia")) {
                WikiResponse wr = new WikiResponse();
                wr = wf.getWikipediaArticle(apiUtilities.getWikiUrl(relation.getUrl().getResource()));
                response.setBio(wr.getQuery().getPages().get21231().getExtract());
            }
        });
        return response;
    }

}
