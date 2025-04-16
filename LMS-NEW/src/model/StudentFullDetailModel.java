package model;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentFullDetailModel extends StudentModel implements Serializable {

    private String level;
    private String department;
    private String semester;
    private ArrayList<String> subjectList;

    public StudentFullDetailModel() {
    }

    public StudentFullDetailModel(String level, String department, String semester, ArrayList<String> subjectList) {
        this.level = level;
        this.department = department;
        this.semester = semester;
        this.subjectList = subjectList;
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<String> subjectList) {
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
