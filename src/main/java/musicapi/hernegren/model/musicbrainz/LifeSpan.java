
package musicapi.hernegren.model.musicbrainz;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "end",
        "ended",
        "begin"
})
public class LifeSpan {

    @JsonProperty("end")
    private String end;
    @JsonProperty("ended")
    private Boolean ended;
    @JsonProperty("begin")
    private String begin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The end
     */
    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    /**
     * @param end The end
     */
    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
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
     * @return The begin
     */
    @JsonProperty("begin")
    public String getBegin() {
        return begin;
    }

    /**
     * @param begin The begin
     */
    @JsonProperty("begin")
    public void setBegin(String begin) {
        this.begin = begin;
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
