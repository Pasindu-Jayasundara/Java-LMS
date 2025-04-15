package model;

import java.io.Serializable;

public class CourseModel implements Serializable {

    private String courseId;
    private String courseCode;
    private String courseName;
    private String credit;
    private String hours;
    private DepartmentHasUndergraduateLevelModel departmentHasUndergraduateLevelModel;

    public CourseModel() {
    }

    public CourseModel(String courseId, String courseCode, String courseName, String credit, String hours, DepartmentHasUndergraduateLevelModel departmentHasUndergraduateLevelModel) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
        this.hours = hours;
        this.departmentHasUndergraduateLevelModel = departmentHasUndergraduateLevelModel;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public DepartmentHasUndergraduateLevelModel getDepartmentHasUndergraduateLevelModel() {
        return departmentHasUndergraduateLevelModel;
    }

    public void setDepartmentHasUndergraduateLevelModel(DepartmentHasUndergraduateLevelModel departmentHasUndergraduateLevelModel) {
        this.departmentHasUndergraduateLevelModel = departmentHasUndergraduateLevelModel;
    }
}
