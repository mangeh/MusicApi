
package musicapi.hernegren.model.coverart;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class CoverArtResponse {

    private List<Image> images = new ArrayList<Image>();
    private String release;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * @return The release
     */
    public String getRelease() {
        return release;
    }

    /**
     * @param release The release
     */
    public void setRelease(String release) {
        this.release = release;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
