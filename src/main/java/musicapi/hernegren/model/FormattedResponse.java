package musicapi.hernegren.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Magnus on 2016-11-11.
 */
@Component
public class FormattedResponse {

    private String artistName;

    private String bio;
    private List<Album> albumList;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
