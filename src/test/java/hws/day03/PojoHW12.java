package hws.day03;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class PojoHW12 {
    private Integer id;
    private CategoryPojoHW12 category;
    private String name;
    private List<String> photoUrls;
    private List<TagPojoHW12> tags;
    private String status;

    public PojoHW12() {
    }

    public PojoHW12(Integer id, CategoryPojoHW12 category, String name, List<String> photoUrls, List<TagPojoHW12> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryPojoHW12 getCategory() {
        return category;
    }

    public void setCategory(CategoryPojoHW12 category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<TagPojoHW12> getTags() {
        return tags;
    }

    public void setTags(List<TagPojoHW12> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
