import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UORTechnicalOfficerUI {
    private JFrame frame;
    private JTabbedPane tabbedPane; 
    private JLabel welcomeLabel;
    private final int officerId = 12345;
    private String officerName;

    public UORTechnicalOfficerUI() {
        frame = new JFrame("UOR Technical Officer Dashboard");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a TabbedPane to navigate between different views
        tabbedPane = new JTabbedPane();

        // Fetch officer's name based on their ID
        String officerName = getOfficerName(officerId);

        // Welcome label that will display officer's name
        welcomeLabel = new JLabel("Welcome " + officerName);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));

        // ===== Sidebar and Button Actions =====
        JPanel sidebar = createSidebar();

        // Main Panel with TabbedPane
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(250, 250, 250));
        sidebar.setPreferredSize(new Dimension(200, 600));

        String[] btnNames = {
                "Profile", "Add Attendance", "Add Medical",
                "View Attendance", "Update Attendance", "View Notice", "Logout"
        };

        for (String name : btnNames) {
            JButton btn = new JButton(name);
            btn.setMaximumSize(new Dimension(160, 40));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(btn);

            // Button actions
            switch (name) {
                case "Profile" -> btn.addActionListener(e -> showProfilePanel(officerId));
                case "Add Attendance" -> btn.addActionListener(e -> showAddAttendancePanel());
                case "Add Medical" -> btn.addActionListener(e -> showAddMedicalPanel());
                case "View Attendance" -> btn.addActionListener(e -> showViewAttendancePanel());
                case "Update Attendance" -> btn.addActionListener(e -> showUpdateAttendancePanel());
                case "View Notice" -> btn.addActionListener(e -> showViewNoticesPanel());
                case "Logout" -> btn.addActionListener(e -> {
                    int result = JOptionPane.showConfirmDialog(frame,
                            "Are you sure you want to logout?", "Logout",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        frame.dispose();
                    }
                });
            }
        }

        return sidebar;
    }

    // Profile method
    private void showProfilePanel(int officerID) {
        tabbedPane.removeAll();  // Remove all tabs first
        tabbedPane.addTab("Profile", new ProfilePanel());  // Adding ProfilePanel to tab
    }

    // Add Attendance method
    private void showAddAttendancePanel() {
        tabbedPane.removeAll();
        tabbedPane.addTab("Add Attendance", new AddAttendancePanel());
    }

    // Add Medical method
    private void showAddMedicalPanel() {
        tabbedPane.removeAll();
        tabbedPane.addTab("Add Medical", new AddMedicalPanel());
    }

    // Update Attendance method
    private void showUpdateAttendancePanel() {
        tabbedPane.removeAll();
        tabbedPane.addTab("Update Attendance", new UpdateAttendancePanel());
    }

    // View Notices method
    private void showViewNoticesPanel() {
        tabbedPane.removeAll();
        tabbedPane.addTab("View Notices", new ViewNoticesPanel());
    }

    // View Attendance method
    private void showViewAttendancePanel() {
        tabbedPane.removeAll();
        tabbedPane.addTab("View Attendance", new ViewAttendancePanel());
    }

    // Method to fetch the officer's name based on officerId (as an integer)
    private String getOfficerName(int officerId) {
        String name = "Technical Officer"; // Default if not found
        String query = "SELECT username FROM technical_officer WHERE user_id = ?";

        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, officerId); // Directly passing officerId as an integer

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("username"); // Fetch the username as the officer's name
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle appropriately in production
        }

        return name;
    }


}
