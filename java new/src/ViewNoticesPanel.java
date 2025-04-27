import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewNoticesPanel extends JPanel {

    // Constructor to initialize the interface
    public ViewNoticesPanel() {
        setLayout(new BorderLayout());

        // Create column names for the table (removed the "Username" column)
        String[] columnNames = {"Title", "Description", "Date"};

        // Create a table model with no data initially
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Create the JTable using the model
        JTable noticeTable = new JTable(model);
        noticeTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(noticeTable);

        // Add the table to the center of the panel
        add(scrollPane, BorderLayout.CENTER);

        // Fetch notices from the database
        List<Notice> notices = fetchNoticesFromDatabase();

        // Populate the table with the notice data
        for (Notice notice : notices) {
            model.addRow(new Object[]{notice.getTitle(), notice.getDescription(), notice.getDate()});
        }
    }

    // Fetch notices from the database
    private List<Notice> fetchNoticesFromDatabase() {
        List<Notice> notices = new ArrayList<>();
        DatabaseConnection db = new DatabaseConnection();  // Use your existing DatabaseConnection class

        try (Connection conn = db.getConnection()) {
            // Modified SQL query to remove the username part
            String sql = "SELECT n.title, n.content, n.post_date " +
                    "FROM notice n " +
                    "WHERE n.status_status_id = 1"; // Assuming status 1 is active
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String title = rs.getString("title");
                    String description = rs.getString("content");
                    String date = rs.getString("post_date");

                    notices.add(new Notice(title, description, date));
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error fetching notices: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + ex.getMessage());
        }

        return notices;
    }

    // Notice class to represent each notice
    static class Notice {
        private String title;
        private String description;
        private String date;

        public Notice(String title, String description, String date) {
            this.title = title;
            this.description = description;
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getDate() {
            return date;
        }
    }
}
