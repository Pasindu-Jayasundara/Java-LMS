package model;

import java.io.Serializable;

public class UndergraduateLevelModel implements Serializable {

    private String id;
    private String level;

    public UndergraduateLevelModel() {
    }

    public UndergraduateLevelModel(String id, String level) {
        this.id = id;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
