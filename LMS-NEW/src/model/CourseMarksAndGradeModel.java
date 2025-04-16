package model;

import java.io.Serializable;

public class CourseMarksAndGradeModel extends CourseModel implements Serializable {

    private String marks;
    private String grade;

    public CourseMarksAndGradeModel() {
    }

    public CourseMarksAndGradeModel(String grade, String marks) {
        this.grade = grade;
        this.marks = marks;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
