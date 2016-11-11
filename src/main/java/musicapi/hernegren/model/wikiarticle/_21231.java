
package musicapi.hernegren.model.wikiarticle;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class _21231 {

    private Integer pageid;
    private Integer ns;
    private String title;
    private String extract;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The pageid
     */
    public Integer getPageid() {
        return pageid;
    }

    /**
     * @param pageid The pageid
     */
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    /**
     * @return The ns
     */
    public Integer getNs() {
        return ns;
    }

    /**
     * @param ns The ns
     */
    public void setNs(Integer ns) {
        this.ns = ns;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The extract
     */
    public String getExtract() {
        return extract;
    }

    /**
     * @param extract The extract
     */
    public void setExtract(String extract) {
        this.extract = extract;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
