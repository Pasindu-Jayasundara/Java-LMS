package model;

import java.io.Serializable;

public class ExamModel implements Serializable {

    private String id;
    private String dateTime;
    private String venue;
    private String description;
    private String courseName;
    private String courseCode;

    public ExamModel() {
    }

    public ExamModel(String id, String dateTime, String venue, String description, String courseName, String courseCode) {
        this.id = id;
        this.dateTime = dateTime;
        this.venue = venue;
        this.description = description;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
