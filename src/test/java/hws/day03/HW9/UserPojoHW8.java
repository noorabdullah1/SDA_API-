package hws.day03.HW9;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hws.day03.HW12.PetCategoryPojoHW12;
import hws.day03.HW12.PetTagPojoHW12;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserPojoHW8 {
    private Integer id;
    private PetCategoryPojoHW12 category;
    private String name;
    private List<String> photoUrls;
    private List<PetTagPojoHW12> tags;
    private String status;

    public UserPojoHW8() {
    }

    public UserPojoHW8(Integer id, PetCategoryPojoHW12 category, String name, List<String> photoUrls, List<PetTagPojoHW12> tags, String status) {
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

    public PetCategoryPojoHW12 getCategory() {
        return category;
    }

    public void setCategory(PetCategoryPojoHW12 category) {
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

    public List<PetTagPojoHW12> getTags() {
        return tags;
    }

    public void setTags(List<PetTagPojoHW12> tags) {
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
