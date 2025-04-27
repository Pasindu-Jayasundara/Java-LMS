package model;

import java.io.Serializable;

public class IndividualMarksModel implements Serializable {

    private String studentRegisterNumber;
    private String name;
    private String marks;

    public IndividualMarksModel() {
    }

    public IndividualMarksModel(String studentRegisterNumber, String name, String marks) {
        this.studentRegisterNumber = studentRegisterNumber;
        this.name = name;
        this.marks = marks;
    }

    public String getStudentRegisterNumber() {
        return studentRegisterNumber;
    }

    public void setStudentRegisterNumber(String studentRegisterNumber) {
        this.studentRegisterNumber = studentRegisterNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
