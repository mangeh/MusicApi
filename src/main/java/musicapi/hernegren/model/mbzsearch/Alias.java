
package musicapi.hernegren.model.mbzsearch;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "sort-name",
    "name",
    "locale",
    "type",
    "primary",
    "begin-date",
    "end-date"
})
public class Alias {

    @JsonProperty("sort-name")
    private String sortName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("locale")
    private Object locale;
    @JsonProperty("type")
    private Object type;
    @JsonProperty("primary")
    private Object primary;
    @JsonProperty("begin-date")
    private Object beginDate;
    @JsonProperty("end-date")
    private Object endDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The sortName
     */
    @JsonProperty("sort-name")
    public String getSortName() {
        return sortName;
    }

    /**
     * 
     * @param sortName
     *     The sort-name
     */
    @JsonProperty("sort-name")
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The locale
     */
    @JsonProperty("locale")
    public Object getLocale() {
        return locale;
    }

    /**
     * 
     * @param locale
     *     The locale
     */
    @JsonProperty("locale")
    public void setLocale(Object locale) {
        this.locale = locale;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public Object getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(Object type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The primary
     */
    @JsonProperty("primary")
    public Object getPrimary() {
        return primary;
    }

    /**
     * 
     * @param primary
     *     The primary
     */
    @JsonProperty("primary")
    public void setPrimary(Object primary) {
        this.primary = primary;
    }

    /**
     * 
     * @return
     *     The beginDate
     */
    @JsonProperty("begin-date")
    public Object getBeginDate() {
        return beginDate;
    }

    /**
     * 
     * @param beginDate
     *     The begin-date
     */
    @JsonProperty("begin-date")
    public void setBeginDate(Object beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 
     * @return
     *     The endDate
     */
    @JsonProperty("end-date")
    public Object getEndDate() {
        return endDate;
    }

    /**
     * 
     * @param endDate
     *     The end-date
     */
    @JsonProperty("end-date")
    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
