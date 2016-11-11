
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
        "country",
        "begin_area",
        "sort-name",
        "gender-id",
        "end_area",
        "type",
        "ipis",
        "area",
        "id",
        "relations",
        "life-span",
        "release-groups",
        "name",
        "gender",
        "disambiguation",
        "type-id"
})
public class MbzResponse {

    @JsonProperty("country")
    private String country;
    @JsonProperty("begin_area")
    private BeginArea beginArea;
    @JsonProperty("sort-name")
    private String sortName;
    @JsonProperty("gender-id")
    private Object genderId;
    @JsonProperty("end_area")
    private Object endArea;
    @JsonProperty("type")
    private String type;
    @JsonProperty("ipis")
    private List<Object> ipis = new ArrayList<Object>();
    @JsonProperty("area")
    private Area area;
    @JsonProperty("id")
    private String id;
    @JsonProperty("relations")
    private List<Relation> relations = new ArrayList<Relation>();
    @JsonProperty("life-span")
    private LifeSpan lifeSpan;
    @JsonProperty("release-groups")
    private List<ReleaseGroup> releaseGroups = new ArrayList<ReleaseGroup>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private Object gender;
    @JsonProperty("disambiguation")
    private String disambiguation;
    @JsonProperty("type-id")
    private String typeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The beginArea
     */
    @JsonProperty("begin_area")
    public BeginArea getBeginArea() {
        return beginArea;
    }

    /**
     * @param beginArea The begin_area
     */
    @JsonProperty("begin_area")
    public void setBeginArea(BeginArea beginArea) {
        this.beginArea = beginArea;
    }

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
     * @return The genderId
     */
    @JsonProperty("gender-id")
    public Object getGenderId() {
        return genderId;
    }

    /**
     * @param genderId The gender-id
     */
    @JsonProperty("gender-id")
    public void setGenderId(Object genderId) {
        this.genderId = genderId;
    }

    /**
     * @return The endArea
     */
    @JsonProperty("end_area")
    public Object getEndArea() {
        return endArea;
    }

    /**
     * @param endArea The end_area
     */
    @JsonProperty("end_area")
    public void setEndArea(Object endArea) {
        this.endArea = endArea;
    }

    /**
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The ipis
     */
    @JsonProperty("ipis")
    public List<Object> getIpis() {
        return ipis;
    }

    /**
     * @param ipis The ipis
     */
    @JsonProperty("ipis")
    public void setIpis(List<Object> ipis) {
        this.ipis = ipis;
    }

    /**
     * @return The area
     */
    @JsonProperty("area")
    public Area getArea() {
        return area;
    }

    /**
     * @param area The area
     */
    @JsonProperty("area")
    public void setArea(Area area) {
        this.area = area;
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
     * @return The relations
     */
    @JsonProperty("relations")
    public List<Relation> getRelations() {
        return relations;
    }

    /**
     * @param relations The relations
     */
    @JsonProperty("relations")
    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    /**
     * @return The lifeSpan
     */
    @JsonProperty("life-span")
    public LifeSpan getLifeSpan() {
        return lifeSpan;
    }

    /**
     * @param lifeSpan The life-span
     */
    @JsonProperty("life-span")
    public void setLifeSpan(LifeSpan lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    /**
     * @return The releaseGroups
     */
    @JsonProperty("release-groups")
    public List<ReleaseGroup> getReleaseGroups() {
        return releaseGroups;
    }

    /**
     * @param releaseGroups The release-groups
     */
    @JsonProperty("release-groups")
    public void setReleaseGroups(List<ReleaseGroup> releaseGroups) {
        this.releaseGroups = releaseGroups;
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
     * @return The gender
     */
    @JsonProperty("gender")
    public Object getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    @JsonProperty("gender")
    public void setGender(Object gender) {
        this.gender = gender;
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
     * @return The typeId
     */
    @JsonProperty("type-id")
    public String getTypeId() {
        return typeId;
    }

    /**
     * @param typeId The type-id
     */
    @JsonProperty("type-id")
    public void setTypeId(String typeId) {
        this.typeId = typeId;
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
