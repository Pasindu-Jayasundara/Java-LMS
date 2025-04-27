import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMedicalPanel extends JPanel {

    public AddMedicalPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Student ID
        JLabel studentIdLabel = new JLabel("Student ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(studentIdLabel, gbc);

        JTextField studentIdField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(studentIdField, gbc);

        // Course Code
        JLabel courseCodeLabel = new JLabel("Course Code:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(courseCodeLabel, gbc);

        JTextField courseCodeField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(courseCodeField, gbc);

        // Date
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(dateLabel, gbc);

        JTextField dateField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(dateField, gbc);

        // Description
        JLabel descriptionLabel = new JLabel("Description:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(descriptionLabel, gbc);

        JTextField descriptionField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(descriptionField, gbc);

        // Medical Status (Approve/Reject)
        JLabel statusLabel = new JLabel("Medical Status:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(statusLabel, gbc);

        String[] medicalStatuses = {"Approve", "Reject"};
        JComboBox<String> medicalStatusDropdown = new JComboBox<>(medicalStatuses);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(medicalStatusDropdown, gbc);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLUE);              // Set background color
        submitButton.setForeground(Color.WHITE);             // Set text color
        submitButton.setFocusPainted(false);                 // Remove focus border
        submitButton.setPreferredSize(new Dimension(120, 40)); // Optional: Set size

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        // Action Listener
        submitButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String courseCode = courseCodeField.getText().trim();
            String dateString = dateField.getText().trim();
            String description = descriptionField.getText().trim();
            String medicalStatus = (String) medicalStatusDropdown.getSelectedItem();

            if (studentId.isEmpty() || courseCode.isEmpty() || dateString.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);
                Date date = sdf.parse(dateString);

                // Save the medical record
                saveMedicalRecord(Integer.parseInt(studentId), description, new java.sql.Timestamp(date.getTime()), medicalStatus);

                // Update attendance if approved
                if (medicalStatus.equals("Approve")) {
                    updateAttendanceStatus(Integer.parseInt(studentId), courseCode, "Present");
                }

                // Clear fields
                studentIdField.setText("");
                courseCodeField.setText("");
                dateField.setText("");
                descriptionField.setText("");
                medicalStatusDropdown.setSelectedIndex(0);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use YYYY-MM-DD.");
            }
        });
    }

    private void saveMedicalRecord(int studentId, String description, java.sql.Timestamp date, String medicalStatus) {
        DatabaseConnection db = new DatabaseConnection();
        try (Connection conn = db.getConnection()) {
            int statusId = getStatusId(conn, medicalStatus);

            String sql = "INSERT INTO medical_record (description, date, student_user_id, status_status_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, description);
                stmt.setTimestamp(2, date);
                stmt.setInt(3, studentId);
                stmt.setInt(4, statusId);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Medical record saved successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving medical record: " + ex.getMessage());
        }
    }

    private void updateAttendanceStatus(int studentId, String courseCode, String status) {
        DatabaseConnection db = new DatabaseConnection();
        try (Connection conn = db.getConnection()) {
            int statusId = getStatusId(conn, status);
            int timetableId = 1;

            String sql = "UPDATE attendance SET attendance_status_id = ? WHERE student_user_id = ? AND course_code = ? AND timetable_timetable_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, statusId);
                stmt.setInt(2, studentId);
                stmt.setString(3, courseCode);
                stmt.setInt(4, timetableId);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Attendance status updated to " + status + "!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating attendance status: " + ex.getMessage());
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
                    throw new SQLException("Status not found in attendance_status table.");
                }
            }
        }
    }
}
