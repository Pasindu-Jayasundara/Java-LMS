import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;

public class ProfilePanel extends JPanel {
    private JTextField officerIDField, officerNameField, officerEmailField, officerContactField;
    private JTextField statusField, departmentField;
    private JButton editButton;
    private JLabel photoLabel;

    private int userId;

    public ProfilePanel() {
       // this.userId = userId;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ===== Form Panel =====
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));

        officerIDField = createField(formPanel, "Officer ID:", false);
        officerNameField = createField(formPanel, "Name:", false);
        officerEmailField = createField(formPanel, "Email:", false);
        officerContactField = createField(formPanel, "Contact:", false);
        statusField = createField(formPanel, "Status:", false);
        departmentField = createField(formPanel, "Department:", false);

        // ===== Photo Placeholder =====
        photoLabel = new JLabel("Photo");
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        photoLabel.setBorder(border);
        formPanel.add(photoLabel);

        add(formPanel, BorderLayout.CENTER);

        // ===== Edit Button =====
        editButton = new JButton("Edit Profile");
        editButton.addActionListener(e -> {
            if (officerNameField.isEditable()) {
                saveProfileData();
                loadProfileData();
                setFieldsEditable(false);
                editButton.setText("Edit Profile");
            } else {
                setFieldsEditable(true);
                editButton.setText("Save Profile");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(editButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadProfileData(); // Load from DB
    }

    private JTextField createField(JPanel panel, String label, boolean editable) {
        panel.add(new JLabel(label));
        JTextField field = new JTextField();
        field.setEditable(editable);
        panel.add(field);
        return field;
    }

    private void setFieldsEditable(boolean editable) {
        officerNameField.setEditable(editable);
        officerEmailField.setEditable(editable);
        officerContactField.setEditable(editable);
        // Status & Department should not be editable
    }

    private void loadProfileData() {
        try (Connection conn = new DatabaseConnection().getConnection()) {
            String query = """
            SELECT t.user_id, t.username, t.email, t.contact_number,
                   s.status AS status_name, d.name AS department_name
            FROM technical_officer t
            JOIN status s ON t.status_status_id = s.status_id
            JOIN department d ON t.department_department_id = d.department_id
            WHERE t.user_id = ?
        """;

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                officerIDField.setText(String.valueOf(rs.getInt("user_id")));
                officerNameField.setText(rs.getString("username"));
                officerEmailField.setText(rs.getString("email"));
                officerContactField.setText(rs.getString("contact_number"));
                statusField.setText(rs.getString("status_name"));
                departmentField.setText(rs.getString("department_name")); // Now correctly mapped from d.name
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    }

    private void saveProfileData() {
        try (Connection conn = new DatabaseConnection().getConnection()) {
            String query = "UPDATE technical_officer SET username = ?, email = ?, contact_number = ? WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, officerNameField.getText());
            stmt.setString(2, officerEmailField.getText());
            stmt.setString(3, officerContactField.getText());
            stmt.setInt(4, userId);

            int updated = stmt.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully.");
            }

            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving profile: " + ex.getMessage());
        }
    }
}
