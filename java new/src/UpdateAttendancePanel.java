import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateAttendancePanel extends JPanel {

    private JTextField studentIdField, courseCodeField, dateField;
    private JComboBox<String> statusDropdown;
    private JButton searchButton, updateButton;

    public UpdateAttendancePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fields
        studentIdField = new JTextField();
        courseCodeField = new JTextField();
        dateField = new JTextField();
        statusDropdown = new JComboBox<>(new String[]{"Present", "Absent"});

        searchButton = new JButton("Search");
        updateButton = new JButton("Update");

        updateButton.setEnabled(false); // Only enabled after search

        // Student ID
        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Student ID:"), gbc);
        gbc.gridx = 1; add(studentIdField, gbc);

        // Course Code
        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Course Code:"), gbc);
        gbc.gridx = 1; add(courseCodeField, gbc);

        // Date
        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Date (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1; add(dateField, gbc);

        // Status
        gbc.gridx = 0; gbc.gridy = 3; add(new JLabel("Attendance Status:"), gbc);
        gbc.gridx = 1; add(statusDropdown, gbc);

        // Buttons
        gbc.gridx = 0; gbc.gridy = 4; add(searchButton, gbc);
        gbc.gridx = 1; add(updateButton, gbc);

        // Action listeners
        searchButton.addActionListener(e -> searchAttendance());
        updateButton.addActionListener(e -> updateAttendance());
    }

    private void searchAttendance() {
        String studentId = studentIdField.getText().trim();
        String courseCode = courseCodeField.getText().trim();
        String date = dateField.getText().trim();

        if (studentId.isEmpty() || courseCode.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all search fields.");
            return;
        }

        try (Connection conn = new DatabaseConnection().getConnection()) {
            String sql = "SELECT s.status FROM attendance a JOIN attendance_status s ON a.attendance_status_id = s.id " +
                    "WHERE a.student_user_id = ? AND a.course_code = ? AND a.date = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(studentId));
            stmt.setString(2, courseCode);
            stmt.setDate(3, Date.valueOf(date));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String currentStatus = rs.getString("status");
                statusDropdown.setSelectedItem(currentStatus);
                updateButton.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Record found. You can now update the status.");
            } else {
                updateButton.setEnabled(false);
                JOptionPane.showMessageDialog(this, "No record found with provided details.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void updateAttendance() {
        String studentId = studentIdField.getText().trim();
        String courseCode = courseCodeField.getText().trim();
        String date = dateField.getText().trim();
        String newStatus = (String) statusDropdown.getSelectedItem();

        try (Connection conn = new DatabaseConnection().getConnection()) {
            // Get status ID
            int statusId = getStatusId(conn, newStatus);

            String updateSql = "UPDATE attendance SET attendance_status_id = ? " +
                    "WHERE student_user_id = ? AND course_code = ? AND date = ?";
            PreparedStatement stmt = conn.prepareStatement(updateSql);
            stmt.setInt(1, statusId);
            stmt.setInt(2, Integer.parseInt(studentId));
            stmt.setString(3, courseCode);
            stmt.setDate(4, Date.valueOf(date));

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Attendance updated successfully.");
                updateButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Update failed. Record might not exist.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private int getStatusId(Connection conn, String status) throws SQLException {
        String sql = "SELECT id FROM attendance_status WHERE status = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    throw new SQLException("Invalid status: " + status);
                }
            }
        }
    }
}
