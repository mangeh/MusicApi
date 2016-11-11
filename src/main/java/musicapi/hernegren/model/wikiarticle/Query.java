
package musicapi.hernegren.model.wikiarticle;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class Query {

    private List<Normalized> normalized = new ArrayList<Normalized>();
    private Pages pages;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The normalized
     */
    public List<Normalized> getNormalized() {
        return normalized;
    }

    /**
     * @param normalized The normalized
     */
    public void setNormalized(List<Normalized> normalized) {
        this.normalized = normalized;
    }

    /**
     * @return The pages
     */
    public Pages getPages() {
        return pages;
    }

    /**
     * @param pages The pages
     */
    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
