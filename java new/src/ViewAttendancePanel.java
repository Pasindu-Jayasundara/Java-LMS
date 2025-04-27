import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewAttendancePanel extends JPanel {

    private JTable attendanceTable;
    private DefaultTableModel model;
    private JTextField studentIdField, courseCodeField, dateField;

    public ViewAttendancePanel() {
        setLayout(new BorderLayout());

        // Top filter panel
        JPanel filterPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        studentIdField = new JTextField();
        courseCodeField = new JTextField();
        dateField = new JTextField();
        JButton searchButton = new JButton("Search");

        filterPanel.setBorder(BorderFactory.createTitledBorder("Viewing Attendance"));

        filterPanel.add(new JLabel("Student ID:"));
        filterPanel.add(studentIdField);
        filterPanel.add(new JLabel("Course Code:"));
        filterPanel.add(courseCodeField);
        filterPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        filterPanel.add(dateField);
        filterPanel.add(new JLabel()); // empty
        filterPanel.add(searchButton);

        add(filterPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Student ID", "Course Code", "Date", "Attendance Status"};
        model = new DefaultTableModel(columnNames, 0);
        attendanceTable = new JTable(model);
        attendanceTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(attendanceTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load all data initially
        loadAttendanceData("", "", "");

        // Search button
        searchButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String courseCode = courseCodeField.getText().trim();
            String date = dateField.getText().trim();
            loadAttendanceData(studentId, courseCode, date);
        });
    }

    private void loadAttendanceData(String studentId, String courseCode, String date) {
        model.setRowCount(0); // Clear table
        List<AttendanceRecord> records = fetchAttendanceDataFromDatabase(studentId, courseCode, date);
        for (AttendanceRecord record : records) {
            model.addRow(new Object[]{
                    record.getStudentId(),
                    record.getCourseCode(),
                    record.getDate(),
                    record.getAttendanceStatus()
            });
        }
    }

    private List<AttendanceRecord> fetchAttendanceDataFromDatabase(String studentId, String courseCode, String date) {
        List<AttendanceRecord> records = new ArrayList<>();
        DatabaseConnection db = new DatabaseConnection();

        StringBuilder sql = new StringBuilder(
                "SELECT a.student_user_id, a.course_code, a.date, s.status " +
                        "FROM attendance a " +
                        "JOIN attendance_status s ON a.attendance_status_id = s.id " +
                        "WHERE 1=1"
        );

        if (!studentId.isEmpty()) sql.append(" AND a.student_user_id = ?");
        if (!courseCode.isEmpty()) sql.append(" AND a.course_code = ?");
        if (!date.isEmpty()) sql.append(" AND a.date = ?");

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int paramIndex = 1;
            if (!studentId.isEmpty()) stmt.setInt(paramIndex++, Integer.parseInt(studentId));
            if (!courseCode.isEmpty()) stmt.setString(paramIndex++, courseCode);
            if (!date.isEmpty()) stmt.setDate(paramIndex++, Date.valueOf(date));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int sid = rs.getInt("student_user_id");
                    String ccode = rs.getString("course_code");
                    Date d = rs.getDate("date");
                    String status = rs.getString("status");
                    records.add(new AttendanceRecord(sid, ccode, d, status));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return records;
    }

    // AttendanceRecord class
    static class AttendanceRecord {
        private final int studentId;
        private final String courseCode;
        private final Date date;
        private final String attendanceStatus;

        public AttendanceRecord(int studentId, String courseCode, Date date, String attendanceStatus) {
            this.studentId = studentId;
            this.courseCode = courseCode;
            this.date = date;
            this.attendanceStatus = attendanceStatus;
        }

        public int getStudentId() { return studentId; }
        public String getCourseCode() { return courseCode; }
        public Date getDate() { return date; }
        public String getAttendanceStatus() { return attendanceStatus; }
    }
}
