package view.admin.panel;

import controller.UserDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UserManagement extends JPanel {
    private JTable userTable;
    private JButton addUserButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton viewButton;
    private JComboBox<String> roleComboBox;
    private DefaultTableModel tableModel;
    private UserDAO userDAO;
    private List<User> currentUsers;
    private String currentRole = "admin";

    public UserManagement(Connection connection) {
        this.userDAO = new UserDAO(connection);
        initializeUI();
        loadUsers(currentRole);
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Create role selection panel
        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rolePanel.add(new JLabel("User Role:"));
        roleComboBox = new JComboBox<>(new String[]{"Admin", "Student", "Lecturer", "Technical Officer"});
        roleComboBox.addActionListener(e -> {
            currentRole = ((String)roleComboBox.getSelectedItem()).toLowerCase().replace(" ", "_");
            loadUsers(currentRole);
        });
        rolePanel.add(roleComboBox);
        add(rolePanel, BorderLayout.NORTH);

        // Create table model
        String[] columnNames = {"Select", "ID", "Username", "Email", "Contact Number", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // Only the checkbox column is editable
            }
        };

        userTable = new JTable(tableModel);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addUserButton = new JButton("Add User");
        updateButton = new JButton("Update");
        viewButton = new JButton("View");
        deleteButton = new JButton("Delete");

        buttonPanel.add(addUserButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add button listeners
        addUserButton.addActionListener(e -> showAddUserDialog());
        updateButton.addActionListener(e -> showUpdateUserDialog());
        viewButton.addActionListener(e -> showViewUserDialog());
        deleteButton.addActionListener(e -> deleteSelectedUsers());
    }

    private void loadUsers(String role) {
        try {
            currentUsers = userDAO.getUsersByRole(role);
            tableModel.setRowCount(0); // Clear existing data

            for (User user : currentUsers) {
                tableModel.addRow(new Object[]{
                        false,
                        user.getUserId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getContactNumber(),
                        user.getStatusId() == 1 ? "Active" : "Inactive"
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading users: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAddUserDialog() {
        JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Add New User", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(500, 400);

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField emailField = new JTextField();
        JTextField contactField = new JTextField();
        JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Active", "Inactive"});

        // Add role-specific fields
        JPanel extraFieldsPanel = new JPanel();
        if (currentRole.equals("student")) {
            // Student specific fields
            // You can add student-specific fields here if needed
        } else if (currentRole.equals("technical_officer")) {
            // Technical officer specific fields
            // You would add department selection here
        }

        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Contact Number:"));
        formPanel.add(contactField);
        formPanel.add(new JLabel("Status:"));
        formPanel.add(statusCombo);
        formPanel.add(new JLabel("Role:"));
        formPanel.add(new JLabel(currentRole));

        if (extraFieldsPanel.getComponentCount() > 0) {
            formPanel.add(extraFieldsPanel);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> {
            try {
                User user = createUserInstance(currentRole);
                user.setUsername(usernameField.getText());
                user.setPassword(new String(passwordField.getPassword())); // In production, hash this
                user.setEmail(emailField.getText());
                user.setContactNumber(contactField.getText());
                user.setStatusId(statusCombo.getSelectedIndex() + 1); // Assuming status IDs start from 1

                if (userDAO.addUser(user, currentRole)) {
                    JOptionPane.showMessageDialog(dialog, "User added successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadUsers(currentRole);
                    dialog.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error adding user: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        dialog.add(formPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showUpdateUserDialog() {
        int selectedRow = getSelectedUserRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to update",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int userId = (int) tableModel.getValueAt(selectedRow, 1);
        try {
            User user = userDAO.getUserById(userId, currentRole);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "User not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Update User", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(500, 400);

            JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));

            JTextField usernameField = new JTextField(user.getUsername());
            JPasswordField passwordField = new JPasswordField();
            passwordField.setText(user.getPassword()); // In production, don't show actual password
            JTextField emailField = new JTextField(user.getEmail());
            JTextField contactField = new JTextField(user.getContactNumber());
            JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Active", "Inactive"});
            statusCombo.setSelectedIndex(user.getStatusId() - 1); // Assuming status IDs start from 1

            // Add role-specific fields if needed
            JPanel extraFieldsPanel = new JPanel();
            if (currentRole.equals("technical_officer") && user instanceof TechnicalOfficerModel) {
                TechnicalOfficerModel techUser = (TechnicalOfficerModel) user;
                // Add department selection
            }

            formPanel.add(new JLabel("Username:"));
            formPanel.add(usernameField);
            formPanel.add(new JLabel("Password:"));
            formPanel.add(passwordField);
            formPanel.add(new JLabel("Email:"));
            formPanel.add(emailField);
            formPanel.add(new JLabel("Contact Number:"));
            formPanel.add(contactField);
            formPanel.add(new JLabel("Status:"));
            formPanel.add(statusCombo);
            formPanel.add(new JLabel("Role:"));
            formPanel.add(new JLabel(currentRole));

            if (extraFieldsPanel.getComponentCount() > 0) {
                formPanel.add(extraFieldsPanel);
            }

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton updateButton = new JButton("Update");
            JButton cancelButton = new JButton("Cancel");

            updateButton.addActionListener(e -> {
                try {
                    user.setUsername(usernameField.getText());
                    if (passwordField.getPassword().length > 0) { // Only update if password was changed
                        user.setPassword(new String(passwordField.getPassword()));
                    }
                    user.setEmail(emailField.getText());
                    user.setContactNumber(contactField.getText());
                    user.setStatusId(statusCombo.getSelectedIndex() + 1);

                    if (userDAO.updateUser(user, currentRole)) {
                        JOptionPane.showMessageDialog(dialog, "User updated successfully!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        loadUsers(currentRole);
                        dialog.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Error updating user: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            cancelButton.addActionListener(e -> dialog.dispose());

            buttonPanel.add(updateButton);
            buttonPanel.add(cancelButton);

            dialog.add(formPanel, BorderLayout.CENTER);
            dialog.add(buttonPanel, BorderLayout.SOUTH);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading user: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showViewUserDialog() {
        int selectedRow = getSelectedUserRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to view",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int userId = (int) tableModel.getValueAt(selectedRow, 1);
        try {
            User user = userDAO.getUserById(userId, currentRole);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "User not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "View User", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(500, 400);

            JPanel viewPanel = new JPanel(new GridLayout(7, 2, 10, 10));

            viewPanel.add(new JLabel("Username:"));
            viewPanel.add(new JLabel(user.getUsername()));
            viewPanel.add(new JLabel("Email:"));
            viewPanel.add(new JLabel(user.getEmail()));
            viewPanel.add(new JLabel("Contact Number:"));
            viewPanel.add(new JLabel(user.getContactNumber()));
            viewPanel.add(new JLabel("Status:"));
            viewPanel.add(new JLabel(user.getStatusId() == 1 ? "Active" : "Inactive"));
            viewPanel.add(new JLabel("Role:"));
            viewPanel.add(new JLabel(currentRole));

            // Add role-specific fields
            if (currentRole.equals("student") && user instanceof StudentModel) {
                StudentModel student = (StudentModel) user;
                viewPanel.add(new JLabel("Enrollment Date:"));
                viewPanel.add(new JLabel(student.getEnrollmentDate()));
            } else if (currentRole.equals("technical_officer") && user instanceof TechnicalOfficerModel) {
                TechnicalOfficerModel techUser = (TechnicalOfficerModel) user;
                viewPanel.add(new JLabel("Department:"));
                viewPanel.add(new JLabel(String.valueOf(techUser.getDepartment().getId())));
            }

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> dialog.dispose());

            dialog.add(viewPanel, BorderLayout.CENTER);
            dialog.add(closeButton, BorderLayout.SOUTH);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading user: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedUsers() {
        List<Integer> userIdsToDelete = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((Boolean) tableModel.getValueAt(i, 0)) {
                userIdsToDelete.add((Integer) tableModel.getValueAt(i, 1));
            }
        }

        if (userIdsToDelete.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one user to delete",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete " + userIdsToDelete.size() + " user(s)?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int deletedCount = 0;
                for (int userId : userIdsToDelete) {
                    if (userDAO.deleteUser(userId, currentRole)) {
                        deletedCount++;
                    }
                }
                JOptionPane.showMessageDialog(this, "Successfully deleted " + deletedCount + " user(s)",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                loadUsers(currentRole);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error deleting users: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private int getSelectedUserRow() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((Boolean) tableModel.getValueAt(i, 0)) {
                return i;
            }
        }
        return -1;
    }

    private User createUserInstance(String role) {
        switch (role.toLowerCase()) {
            case "admin": return new AdminModel();
            case "student": return new StudentModel();
            case "lecturer": return new LecturerModel();
            case "technical_officer": return new TechnicalOfficerModel();
            default: throw new IllegalArgumentException("Invalid user role: " + role);
        }
    }
}
