import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAttendancePanel extends JPanel {

    public AddAttendancePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Student ID Field
        JLabel studentIdLabel = new JLabel("Student ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(studentIdLabel, gbc);

        JTextField studentIdField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(studentIdField, gbc);

        // Course Code Field
        JLabel courseCodeLabel = new JLabel("Course Code:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(courseCodeLabel, gbc);

        JTextField courseCodeField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(courseCodeField, gbc);

        // Status Dropdown
        JLabel statusLabel = new JLabel("Status:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(statusLabel, gbc);

        String[] statuses = {"Present", "Absent"};
        JComboBox<String> statusDropdown = new JComboBox<>(statuses);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(statusDropdown, gbc);

        // Date Field
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(dateLabel, gbc);

        JTextField dateField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(dateField, gbc);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.setPreferredSize(new Dimension(120, 40));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String courseCode = courseCodeField.getText().trim();
            String status = (String) statusDropdown.getSelectedItem();
            String dateString = dateField.getText().trim();

            if (studentId.isEmpty() || courseCode.isEmpty() || dateString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                Date date = dateFormat.parse(dateString);

                // Save to DB
                saveAttendance(Integer.parseInt(studentId), courseCode, status, new java.sql.Date(date.getTime()));

                JOptionPane.showMessageDialog(this, "Attendance recorded.");

                studentIdField.setText("");
                courseCodeField.setText("");
                statusDropdown.setSelectedIndex(0);
                dateField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }

    private void saveAttendance(int studentId, String courseCode, String status, java.sql.Date date) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.getConnection();

        // Get status ID from `attendance_status`
        int statusId = getStatusId(conn, status);

        // Placeholder timetable ID
        int timetableId = 1;

        String sql = "INSERT INTO attendance (student_user_id, course_code, attendance_status_id, date, timetable_timetable_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setString(2, courseCode);
            stmt.setInt(3, statusId);
            stmt.setDate(4, date);
            stmt.setInt(5, timetableId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            conn.close();
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
