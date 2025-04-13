package model;

import java.io.Serializable;

public class DepartmentHasUndergraduateLevelModel implements Serializable {

    private DepartmentModel department;
    private UndergraduateLevelModel undergraduateLevel;
    private SemesterModel semester;
    private String id;

    public DepartmentHasUndergraduateLevelModel() {
    }

    public DepartmentHasUndergraduateLevelModel(DepartmentModel department, UndergraduateLevelModel undergraduateLevel, SemesterModel semester, String id) {
        this.department = department;
        this.undergraduateLevel = undergraduateLevel;
        this.semester = semester;
        this.id = id;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public UndergraduateLevelModel getUndergraduateLevel() {
        return undergraduateLevel;
    }

    public void setUndergraduateLevel(UndergraduateLevelModel undergraduateLevel) {
        this.undergraduateLevel = undergraduateLevel;
    }

    public SemesterModel getSemester() {
        return semester;
    }

    public void setSemester(SemesterModel semester) {
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
