
package musicapi.hernegren.model.coverart;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class Image {

    private List<String> types = new ArrayList<String>();
    private Boolean front;
    private Boolean back;
    private Integer edit;
    private String image;
    private String comment;
    private Boolean approved;
    private Thumbnails thumbnails;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The types
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * @param types The types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * @return The front
     */
    public Boolean getFront() {
        return front;
    }

    /**
     * @param front The front
     */
    public void setFront(Boolean front) {
        this.front = front;
    }

    /**
     * @return The back
     */
    public Boolean getBack() {
        return back;
    }

    /**
     * @param back The back
     */
    public void setBack(Boolean back) {
        this.back = back;
    }

    /**
     * @return The edit
     */
    public Integer getEdit() {
        return edit;
    }

    /**
     * @param edit The edit
     */
    public void setEdit(Integer edit) {
        this.edit = edit;
    }

    /**
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return The approved
     */
    public Boolean getApproved() {
        return approved;
    }

    /**
     * @param approved The approved
     */
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    /**
     * @return The thumbnails
     */
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    /**
     * @param thumbnails The thumbnails
     */
    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
