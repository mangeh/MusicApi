
package musicapi.hernegren.model.musicbrainz;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "sort-name",
        "name",
        "disambiguation",
        "iso-3166-1-codes",
        "id"
})
public class Area {

    @JsonProperty("sort-name")
    private String sortName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("disambiguation")
    private String disambiguation;
    @JsonProperty("iso-3166-1-codes")
    private List<String> iso31661Codes = new ArrayList<String>();
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The sortName
     */
    @JsonProperty("sort-name")
    public String getSortName() {
        return sortName;
    }

    /**
     * @param sortName The sort-name
     */
    @JsonProperty("sort-name")
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The disambiguation
     */
    @JsonProperty("disambiguation")
    public String getDisambiguation() {
        return disambiguation;
    }

    /**
     * @param disambiguation The disambiguation
     */
    @JsonProperty("disambiguation")
    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    /**
     * @return The iso31661Codes
     */
    @JsonProperty("iso-3166-1-codes")
    public List<String> getIso31661Codes() {
        return iso31661Codes;
    }

    /**
     * @param iso31661Codes The iso-3166-1-codes
     */
    @JsonProperty("iso-3166-1-codes")
    public void setIso31661Codes(List<String> iso31661Codes) {
        this.iso31661Codes = iso31661Codes;
    }

    /**
     * @return The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
