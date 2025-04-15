package model;

import java.io.Serializable;

public class SemesterModel implements Serializable {

    private String id;
    private String semester;

    public SemesterModel() {
    }

    public SemesterModel(String id, String semester) {
        this.id = id;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
