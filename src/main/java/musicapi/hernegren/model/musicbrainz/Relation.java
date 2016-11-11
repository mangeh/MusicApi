
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
        "direction",
        "source-credit",
        "attribute-values",
        "url",
        "type",
        "target-credit",
        "type-id",
        "begin",
        "end",
        "target-type",
        "ended",
        "attributes"
})
public class Relation {

    @JsonProperty("direction")
    private String direction;
    @JsonProperty("source-credit")
    private String sourceCredit;
    @JsonProperty("attribute-values")
    private AttributeValues attributeValues;
    @JsonProperty("url")
    private Url url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("target-credit")
    private String targetCredit;
    @JsonProperty("type-id")
    private String typeId;
    @JsonProperty("begin")
    private Object begin;
    @JsonProperty("end")
    private Object end;
    @JsonProperty("target-type")
    private String targetType;
    @JsonProperty("ended")
    private Boolean ended;
    @JsonProperty("attributes")
    private List<Object> attributes = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The direction
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction The direction
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return The sourceCredit
     */
    @JsonProperty("source-credit")
    public String getSourceCredit() {
        return sourceCredit;
    }

    /**
     * @param sourceCredit The source-credit
     */
    @JsonProperty("source-credit")
    public void setSourceCredit(String sourceCredit) {
        this.sourceCredit = sourceCredit;
    }

    /**
     * @return The attributeValues
     */
    @JsonProperty("attribute-values")
    public AttributeValues getAttributeValues() {
        return attributeValues;
    }

    /**
     * @param attributeValues The attribute-values
     */
    @JsonProperty("attribute-values")
    public void setAttributeValues(AttributeValues attributeValues) {
        this.attributeValues = attributeValues;
    }

    /**
     * @return The url
     */
    @JsonProperty("url")
    public Url getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    @JsonProperty("url")
    public void setUrl(Url url) {
        this.url = url;
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
     * @return The targetCredit
     */
    @JsonProperty("target-credit")
    public String getTargetCredit() {
        return targetCredit;
    }

    /**
     * @param targetCredit The target-credit
     */
    @JsonProperty("target-credit")
    public void setTargetCredit(String targetCredit) {
        this.targetCredit = targetCredit;
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

    /**
     * @return The begin
     */
    @JsonProperty("begin")
    public Object getBegin() {
        return begin;
    }

    /**
     * @param begin The begin
     */
    @JsonProperty("begin")
    public void setBegin(Object begin) {
        this.begin = begin;
    }

    /**
     * @return The end
     */
    @JsonProperty("end")
    public Object getEnd() {
        return end;
    }

    /**
     * @param end The end
     */
    @JsonProperty("end")
    public void setEnd(Object end) {
        this.end = end;
    }

    /**
     * @return The targetType
     */
    @JsonProperty("target-type")
    public String getTargetType() {
        return targetType;
    }

    /**
     * @param targetType The target-type
     */
    @JsonProperty("target-type")
    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    /**
     * @return The ended
     */
    @JsonProperty("ended")
    public Boolean getEnded() {
        return ended;
    }

    /**
     * @param ended The ended
     */
    @JsonProperty("ended")
    public void setEnded(Boolean ended) {
        this.ended = ended;
    }

    /**
     * @return The attributes
     */
    @JsonProperty("attributes")
    public List<Object> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes The attributes
     */
    @JsonProperty("attributes")
    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
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
