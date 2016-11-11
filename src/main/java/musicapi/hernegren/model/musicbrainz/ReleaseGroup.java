
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
        "primary-type",
        "id",
        "title",
        "secondary-types",
        "disambiguation",
        "primary-type-id",
        "first-release-date",
        "secondary-type-ids"
})
public class ReleaseGroup {

    @JsonProperty("primary-type")
    private String primaryType;
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("secondary-types")
    private List<String> secondaryTypes = new ArrayList<String>();
    @JsonProperty("disambiguation")
    private String disambiguation;
    @JsonProperty("primary-type-id")
    private String primaryTypeId;
    @JsonProperty("first-release-date")
    private String firstReleaseDate;
    @JsonProperty("secondary-type-ids")
    private List<String> secondaryTypeIds = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The primaryType
     */
    @JsonProperty("primary-type")
    public String getPrimaryType() {
        return primaryType;
    }

    /**
     * @param primaryType The primary-type
     */
    @JsonProperty("primary-type")
    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
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

    /**
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The secondaryTypes
     */
    @JsonProperty("secondary-types")
    public List<String> getSecondaryTypes() {
        return secondaryTypes;
    }

    /**
     * @param secondaryTypes The secondary-types
     */
    @JsonProperty("secondary-types")
    public void setSecondaryTypes(List<String> secondaryTypes) {
        this.secondaryTypes = secondaryTypes;
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
     * @return The primaryTypeId
     */
    @JsonProperty("primary-type-id")
    public String getPrimaryTypeId() {
        return primaryTypeId;
    }

    /**
     * @param primaryTypeId The primary-type-id
     */
    @JsonProperty("primary-type-id")
    public void setPrimaryTypeId(String primaryTypeId) {
        this.primaryTypeId = primaryTypeId;
    }

    /**
     * @return The firstReleaseDate
     */
    @JsonProperty("first-release-date")
    public String getFirstReleaseDate() {
        return firstReleaseDate;
    }

    /**
     * @param firstReleaseDate The first-release-date
     */
    @JsonProperty("first-release-date")
    public void setFirstReleaseDate(String firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    /**
     * @return The secondaryTypeIds
     */
    @JsonProperty("secondary-type-ids")
    public List<String> getSecondaryTypeIds() {
        return secondaryTypeIds;
    }

    /**
     * @param secondaryTypeIds The secondary-type-ids
     */
    @JsonProperty("secondary-type-ids")
    public void setSecondaryTypeIds(List<String> secondaryTypeIds) {
        this.secondaryTypeIds = secondaryTypeIds;
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
