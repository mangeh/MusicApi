
package musicapi.hernegren.model.coverart;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class Thumbnails {

    private String large;
    private String small;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The large
     */
    public String getLarge() {
        return large;
    }

    /**
     * @param large The large
     */
    public void setLarge(String large) {
        this.large = large;
    }

    /**
     * @return The small
     */
    public String getSmall() {
        return small;
    }

    /**
     * @param small The small
     */
    public void setSmall(String small) {
        this.small = small;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
