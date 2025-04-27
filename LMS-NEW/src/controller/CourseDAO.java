package controller;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private final Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new course
    public boolean addCourse(CourseModel course) throws SQLException {
        String query = "INSERT INTO course (course_id, course_code, course_name, credit, hours, department_has_undergraduate_level_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseCode());
            stmt.setString(3, course.getCourseName());
            stmt.setString(4, course.getCredit());
            stmt.setString(5, course.getHours());
            stmt.setString(6, course.getDepartmentHasUndergraduateLevelModel().getId());

            return stmt.executeUpdate() > 0;
        }
    }

    // Get all courses
    public List<CourseModel> getAllCourses() throws SQLException {
        List<CourseModel> courses = new ArrayList<>();
        String query = "SELECT c.*, d.name AS department_name, ul.level AS undergrad_level, s.semester " +
                "FROM course c " +
                "JOIN department_has_undergraduate_level dhul ON c.department_has_undergraduate_level_id = dhul.id " +
                "JOIN department d ON dhul.department_id = d.id " +
                "JOIN undergraduate_level ul ON dhul.undergraduate_level_id = ul.id " +
                "JOIN semester s ON dhul.semester_id = s.id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                CourseModel course = new CourseModel();
                course.setCourseId(rs.getString("course_id"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                course.setCredit(rs.getString("credit"));
                course.setHours(rs.getString("hours"));

                // Set department, undergrad level, and semester info
                DepartmentModel department = new DepartmentModel();
                department.setId(rs.getString("department_id"));
                department.setName(rs.getString("department_name"));

                UndergraduateLevelModel undergradLevel = new UndergraduateLevelModel();
                undergradLevel.setId(rs.getString("undergraduate_level_id"));
                undergradLevel.setLevel(rs.getString("undergrad_level"));

                SemesterModel semester = new SemesterModel();
                semester.setId(rs.getString("semester_id"));
                semester.setSemester(rs.getString("semester"));

                DepartmentHasUndergraduateLevelModel dhul = new DepartmentHasUndergraduateLevelModel();
                dhul.setId(rs.getString("department_has_undergraduate_level_id"));
                dhul.setDepartment(department);
                dhul.setUndergraduateLevel(undergradLevel);
                dhul.setSemester(semester);

                course.setDepartmentHasUndergraduateLevelModel(dhul);

                courses.add(course);
            }
        }
        return courses;
    }

    // Update a course
    public boolean updateCourse(CourseModel course) throws SQLException {
        String query = "UPDATE course SET course_code=?, course_name=?, credit=?, hours=?, department_has_undergraduate_level_id=? WHERE course_id=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseCode());
            stmt.setString(2, course.getCourseName());
            stmt.setString(3, course.getCredit());
            stmt.setString(4, course.getHours());
            stmt.setString(5, course.getDepartmentHasUndergraduateLevelModel().getId());
            stmt.setString(6, course.getCourseId());

            return stmt.executeUpdate() > 0;
        }
    }

    // Delete a course
    public boolean deleteCourse(String courseId) throws SQLException {
        String query = "DELETE FROM course WHERE course_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, courseId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Get course by ID
    public CourseModel getCourseById(String courseId) throws SQLException {
        String query = "SELECT c.*, d.name AS department_name, ul.level AS undergrad_level, s.semester " +
                "FROM course c " +
                "JOIN department_has_undergraduate_level dhul ON c.department_has_undergraduate_level_id = dhul.id " +
                "JOIN department d ON dhul.department_id = d.id " +
                "JOIN undergraduate_level ul ON dhul.undergraduate_level_id = ul.id " +
                "JOIN semester s ON dhul.semester_id = s.id " +
                "WHERE c.course_id=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CourseModel course = new CourseModel();
                    course.setCourseId(rs.getString("course_id"));
                    course.setCourseCode(rs.getString("course_code"));
                    course.setCourseName(rs.getString("course_name"));
                    course.setCredit(rs.getString("credit"));
                    course.setHours(rs.getString("hours"));

                    // Set department, undergrad level, and semester info
                    DepartmentModel department = new DepartmentModel();
                    department.setId(rs.getString("department_id"));
                    department.setName(rs.getString("department_name"));

                    UndergraduateLevelModel undergradLevel = new UndergraduateLevelModel();
                    undergradLevel.setId(rs.getString("undergraduate_level_id"));
                    undergradLevel.setLevel(rs.getString("undergrad_level"));

                    SemesterModel semester = new SemesterModel();
                    semester.setId(rs.getString("semester_id"));
                    semester.setSemester(rs.getString("semester"));

                    DepartmentHasUndergraduateLevelModel dhul = new DepartmentHasUndergraduateLevelModel();
                    dhul.setId(rs.getString("department_has_undergraduate_level_id"));
                    dhul.setDepartment(department);
                    dhul.setUndergraduateLevel(undergradLevel);
                    dhul.setSemester(semester);

                    course.setDepartmentHasUndergraduateLevelModel(dhul);

                    return course;
                }
            }
        }
        return null;
    }
}
