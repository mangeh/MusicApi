
package musicapi.hernegren.model.wikiarticle;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class Normalized {

    private String from;
    private String to;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from The from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return The to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to The to
     */
    public void setTo(String to) {
        this.to = to;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
