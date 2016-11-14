
package musicapi.hernegren.model.mbzsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "id",
    "type",
    "score",
    "name",
    "sort-name",
    "country",
    "area",
    "disambiguation",
    "life-span",
    "tags",
    "gender",
    "begin-area",
    "aliases",
    "ipis"
})
public class Artist {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("score")
    private String score;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sort-name")
    private String sortName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("area")
    private Area area;
    @JsonProperty("disambiguation")
    private String disambiguation;
    @JsonProperty("life-span")
    private LifeSpan lifeSpan;
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("begin-area")
    private BeginArea beginArea;
    @JsonProperty("aliases")
    private List<Alias> aliases = new ArrayList<Alias>();
    @JsonProperty("ipis")
    private List<String> ipis = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The score
     */
    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
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
     *     The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The area
     */
    @JsonProperty("area")
    public Area getArea() {
        return area;
    }

    /**
     * 
     * @param area
     *     The area
     */
    @JsonProperty("area")
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * 
     * @return
     *     The disambiguation
     */
    @JsonProperty("disambiguation")
    public String getDisambiguation() {
        return disambiguation;
    }

    /**
     * 
     * @param disambiguation
     *     The disambiguation
     */
    @JsonProperty("disambiguation")
    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

    /**
     * 
     * @return
     *     The lifeSpan
     */
    @JsonProperty("life-span")
    public LifeSpan getLifeSpan() {
        return lifeSpan;
    }

    /**
     * 
     * @param lifeSpan
     *     The life-span
     */
    @JsonProperty("life-span")
    public void setLifeSpan(LifeSpan lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    /**
     * 
     * @return
     *     The tags
     */
    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The gender
     */
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The beginArea
     */
    @JsonProperty("begin-area")
    public BeginArea getBeginArea() {
        return beginArea;
    }

    /**
     * 
     * @param beginArea
     *     The begin-area
     */
    @JsonProperty("begin-area")
    public void setBeginArea(BeginArea beginArea) {
        this.beginArea = beginArea;
    }

    /**
     * 
     * @return
     *     The aliases
     */
    @JsonProperty("aliases")
    public List<Alias> getAliases() {
        return aliases;
    }

    /**
     * 
     * @param aliases
     *     The aliases
     */
    @JsonProperty("aliases")
    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }

    /**
     * 
     * @return
     *     The ipis
     */
    @JsonProperty("ipis")
    public List<String> getIpis() {
        return ipis;
    }

    /**
     * 
     * @param ipis
     *     The ipis
     */
    @JsonProperty("ipis")
    public void setIpis(List<String> ipis) {
        this.ipis = ipis;
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
