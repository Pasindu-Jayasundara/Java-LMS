package controller;


import model.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new user
    public boolean addUser(User user, String role) throws SQLException {
        String tableName = getTableName(role);
        String query = String.format(
                "INSERT INTO %s (username, password, email, contact_number, status_status_id%s) VALUES (?, ?, ?, ?, ?%s)",
                tableName,
                role.equals("technical_officer") ? ", department_department_id" : "",
                role.equals("student") ? ", enrollment_date" : ""
        );

        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword()); // In production, hash the password first
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getContactNumber());
            stmt.setInt(5, user.getStatusId());

            int paramIndex = 6;
            if (role.equals("technical_officer")) {
                TechnicalOfficerModel techUser = (TechnicalOfficerModel) user;
                stmt.setString(paramIndex++, techUser.getDepartment().getId());
            } else if (role.equals("student")) {
                stmt.setTimestamp(paramIndex, Timestamp.valueOf(LocalDateTime.now())); // Using current time for enrollment
            }

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        user.setUserId(rs.getInt(1));
                    }
                }
                return true;
            }
            return false;
        }
    }

    // Get all users of a specific role
    public List<User> getUsersByRole(String role) throws SQLException {
        String tableName = getTableName(role);
        String query = "SELECT * FROM " + tableName;
        List<User> users = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User user = createUserFromResultSet(rs, role);
                users.add(user);
            }
        }
        return users;
    }

    // Update a user
    public boolean updateUser(User user, String role) throws SQLException {
        String tableName = getTableName(role);
        String query = String.format(
                "UPDATE %s SET username=?, password=?, email=?, contact_number=?, status_status_id=?%s WHERE user_id=?",
                tableName,
                role.equals("technical_officer") ? ", department_department_id=?" : ""
        );

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getContactNumber());
            stmt.setInt(5, user.getStatusId());

            int paramIndex = 6;
            if (role.equals("technical_officer")) {
                TechnicalOfficerModel techUser = (TechnicalOfficerModel) user;
                stmt.setString(paramIndex++, techUser.getDepartment().getId());
            }
            stmt.setInt(paramIndex, user.getUserId());

            return stmt.executeUpdate() > 0;
        }
    }

    // Delete a user
    public boolean deleteUser(int userId, String role) throws SQLException {
        String tableName = getTableName(role);
        String query = "DELETE FROM " + tableName + " WHERE user_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Get user by ID
    public User getUserById(int userId, String role) throws SQLException {
        String tableName = getTableName(role);
        String query = "SELECT * FROM " + tableName + " WHERE user_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return createUserFromResultSet(rs, role);
                }
            }
        }
        return null;
    }

    // Helper methods
    private String getTableName(String role) {
        return switch (role.toLowerCase()) {
            case "admin" -> "admin";
            case "student" -> "student";
            case "lecturer" -> "lecturer";
            case "technical_officer" -> "technical_officer";
            default -> throw new IllegalArgumentException("Invalid user role: " + role);
        };
    }

    private User createUserFromResultSet(ResultSet rs, String role) throws SQLException {
        User user;
        switch (role.toLowerCase()) {
            case "admin":
                user = new AdminModel();
                break;
            case "student":
                StudentModel student = new StudentModel();
                student.setEnrollmentDate(rs.getString("enrollment_date"));
                student.setProfilePicture(rs.getString("profile_picture"));
                user = student;
                break;
            case "lecturer":
                user = new LecturerModel();
                break;
            case "technical_officer":
                TechnicalOfficerModel techUser = new TechnicalOfficerModel();
                DepartmentModel dept = new DepartmentModel();
                dept.setId(rs.getString("department_department_id"));
                techUser.setDepartment(dept);
                user = techUser;
                break;
            default:
                throw new IllegalArgumentException("Invalid user role: " + role);
        }

        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setContactNumber(rs.getString("contact_number"));
        user.setStatusId(rs.getInt("status_status_id"));

        return user;
    }
}