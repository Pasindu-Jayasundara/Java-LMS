package model;

import java.io.Serializable;

public class StudentFullDetailModel extends StudentModel implements Serializable {

    private String level;
    private String department;
    private String semester;

    public StudentFullDetailModel() {
    }

    public StudentFullDetailModel(String level, String department, String semester) {
        this.level = level;
        this.department = department;
        this.semester = semester;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
