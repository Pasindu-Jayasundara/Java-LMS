package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentFullDetailModel extends StudentModel implements Serializable {

    private String level;
    private String department;
    private String semester;
    private HashMap<String,String> subjectList;

    public StudentFullDetailModel() {
    }

    public StudentFullDetailModel(String level, String department, String semester, HashMap<String,String> subjectList) {
        this.level = level;
        this.department = department;
        this.semester = semester;
        this.subjectList = subjectList;
    }

    public HashMap<String,String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(HashMap<String,String> subjectList) {
        this.subjectList = subjectList;
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
