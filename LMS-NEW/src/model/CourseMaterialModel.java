package model;

import java.io.Serializable;

public class CourseMaterialModel implements Serializable {

    private String id;
    private String name;
    private String type;
    private String url;

    public CourseMaterialModel() {
    }

    public CourseMaterialModel(String id, String name, String type, String url) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
