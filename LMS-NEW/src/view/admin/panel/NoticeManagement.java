package view.admin.panel;

import controller.NoticeDAO;
import model.Notice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NoticeManagement extends JPanel {
    private JTable noticeTable;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton viewButton;
    private DefaultTableModel tableModel;
    private NoticeDAO noticeDAO;
    private List<Notice> notices;

    public NoticeManagement(Connection connection) {
        this.noticeDAO = new NoticeDAO(connection);
        initializeUI();
        loadNotices();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Create table model
        String[] columnNames = {"Select", "ID", "Title", "Post Date", "Content"};
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

        noticeTable = new JTable(tableModel);
        noticeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(noticeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addButton = new JButton("Add Notice");
        updateButton = new JButton("Update");
        viewButton = new JButton("View");
        deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add button listeners
        addButton.addActionListener(e -> showAddNoticeDialog());
        updateButton.addActionListener(e -> showUpdateNoticeDialog());
        viewButton.addActionListener(e -> showViewNoticeDialog());
        deleteButton.addActionListener(e -> deleteSelectedNotices());
    }

    private void loadNotices() {
        try {
            notices = noticeDAO.getAllNotices();
            tableModel.setRowCount(0); // Clear existing data

            for (Notice notice : notices) {
                tableModel.addRow(new Object[]{
                        false,
                        notice.getNoticeId(),
                        notice.getTitle(),
                        notice.getPostDate(),
                        notice.getContent().length() > 50 ?
                                notice.getContent().substring(0, 50) + "..." : notice.getContent()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading notices: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAddNoticeDialog() {
        JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Add New Notice", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(500, 400);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField titleField = new JTextField();
        JTextArea contentArea = new JTextArea(5, 20);
        JScrollPane contentScroll = new JScrollPane(contentArea);
        JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Active", "Inactive"});
        // Assuming admin user ID is known (you might want to get this from session)
        int adminUserId = 1; // Replace with actual admin user ID

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Content:"));
        formPanel.add(contentScroll);
        formPanel.add(new JLabel("Status:"));
        formPanel.add(statusCombo);
        formPanel.add(new JLabel("Admin User ID:"));
        formPanel.add(new JLabel(String.valueOf(adminUserId)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> {
            try {
                Notice notice = new Notice();
                notice.setTitle(titleField.getText());
                notice.setContent(contentArea.getText());
                notice.setPostDate(LocalDateTime.now());
                notice.setStatusId(statusCombo.getSelectedIndex() + 1); // Assuming status IDs start from 1
                notice.setAdminUserId(adminUserId);

                if (noticeDAO.addNotice(notice)) {
                    JOptionPane.showMessageDialog(dialog, "Notice added successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadNotices();
                    dialog.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error adding notice: " + ex.getMessage(),
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

    private void showUpdateNoticeDialog() {
        int selectedRow = getSelectedNoticeRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a notice to update",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int noticeId = (int) tableModel.getValueAt(selectedRow, 1);
        try {
            Notice notice = noticeDAO.getNoticeById(noticeId);
            if (notice == null) {
                JOptionPane.showMessageDialog(this, "Notice not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Update Notice", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(500, 400);

            JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

            JTextField titleField = new JTextField(notice.getTitle());
            JTextArea contentArea = new JTextArea(notice.getContent(), 5, 20);
            JScrollPane contentScroll = new JScrollPane(contentArea);
            JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Active", "Inactive"});
            statusCombo.setSelectedIndex(notice.getStatusId() - 1); // Assuming status IDs start from 1

            formPanel.add(new JLabel("Title:"));
            formPanel.add(titleField);
            formPanel.add(new JLabel("Content:"));
            formPanel.add(contentScroll);
            formPanel.add(new JLabel("Status:"));
            formPanel.add(statusCombo);
            formPanel.add(new JLabel("Post Date:"));
            formPanel.add(new JLabel(notice.getPostDate().toString()));
            formPanel.add(new JLabel("Admin User ID:"));
            formPanel.add(new JLabel(String.valueOf(notice.getAdminUserId())));

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton updateButton = new JButton("Update");
            JButton cancelButton = new JButton("Cancel");

            updateButton.addActionListener(e -> {
                try {
                    notice.setTitle(titleField.getText());
                    notice.setContent(contentArea.getText());
                    notice.setStatusId(statusCombo.getSelectedIndex() + 1);

                    if (noticeDAO.updateNotice(notice)) {
                        JOptionPane.showMessageDialog(dialog, "Notice updated successfully!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        loadNotices();
                        dialog.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Error updating notice: " + ex.getMessage(),
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
            JOptionPane.showMessageDialog(this, "Error loading notice: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showViewNoticeDialog() {
        int selectedRow = getSelectedNoticeRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a notice to view",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int noticeId = (int) tableModel.getValueAt(selectedRow, 1);
        try {
            Notice notice = noticeDAO.getNoticeById(noticeId);
            if (notice == null) {
                JOptionPane.showMessageDialog(this, "Notice not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "View Notice", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(500, 400);

            JPanel viewPanel = new JPanel(new GridLayout(5, 2, 10, 10));

            viewPanel.add(new JLabel("Title:"));
            viewPanel.add(new JLabel(notice.getTitle()));
            viewPanel.add(new JLabel("Content:"));
            viewPanel.add(new JScrollPane(new JTextArea(notice.getContent())));
            viewPanel.add(new JLabel("Status:"));
            viewPanel.add(new JLabel(notice.getStatusId() == 1 ? "Active" : "Inactive"));
            viewPanel.add(new JLabel("Post Date:"));
            viewPanel.add(new JLabel(notice.getPostDate().toString()));
            viewPanel.add(new JLabel("Admin User ID:"));
            viewPanel.add(new JLabel(String.valueOf(notice.getAdminUserId())));

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> dialog.dispose());

            dialog.add(viewPanel, BorderLayout.CENTER);
            dialog.add(closeButton, BorderLayout.SOUTH);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading notice: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedNotices() {
        List<Integer> noticeIdsToDelete = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((Boolean) tableModel.getValueAt(i, 0)) {
                noticeIdsToDelete.add((Integer) tableModel.getValueAt(i, 1));
            }
        }

        if (noticeIdsToDelete.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one notice to delete",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete " + noticeIdsToDelete.size() + " notice(s)?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int deletedCount = 0;
                for (int noticeId : noticeIdsToDelete) {
                    if (noticeDAO.deleteNotice(noticeId)) {
                        deletedCount++;
                    }
                }
                JOptionPane.showMessageDialog(this, "Successfully deleted " + deletedCount + " notice(s)",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                loadNotices();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error deleting notices: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private int getSelectedNoticeRow() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((Boolean) tableModel.getValueAt(i, 0)) {
                return i;
            }
        }
        return -1;
    }
}
