package model;

import java.io.Serializable;

public class TechnicalOfficerModel extends User implements Serializable {

    private DepartmentModel department;

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }
}
