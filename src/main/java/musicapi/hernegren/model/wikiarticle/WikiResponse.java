
package musicapi.hernegren.model.wikiarticle;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class WikiResponse {

    private String batchcomplete;
    private Query query;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The batchcomplete
     */
    public String getBatchcomplete() {
        return batchcomplete;
    }

    /**
     * @param batchcomplete The batchcomplete
     */
    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    /**
     * @return The query
     */
    public Query getQuery() {
        return query;
    }

    /**
     * @param query The query
     */
    public void setQuery(Query query) {
        this.query = query;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
