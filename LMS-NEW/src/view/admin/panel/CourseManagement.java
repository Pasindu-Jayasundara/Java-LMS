package view.admin.panel;

import controller.CourseDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CourseManagement extends JPanel {
    private JTable courseTable;
    private JButton addCourseButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton viewButton;
    private DefaultTableModel tableModel;
    private CourseDAO courseDAO;
    private List<CourseModel> courses;

    public CourseManagement(Connection connection) {
        this.courseDAO = new CourseDAO(connection);
        initializeUI();
        loadCourses();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Create table model
        String[] columnNames = {"Select", "Course ID", "Code", "Name", "Credit", "Hours", "Department", "Level", "Semester"};
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

        courseTable = new JTable(tableModel);
        courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(courseTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addCourseButton = new JButton("Add Course");
        updateButton = new JButton("Update");
        viewButton = new JButton("View");
        deleteButton = new JButton("Delete");

        buttonPanel.add(addCourseButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add button listeners
        addCourseButton.addActionListener(e -> showAddCourseDialog());
        updateButton.addActionListener(e -> showUpdateCourseDialog());
        viewButton.addActionListener(e -> showViewCourseDialog());
        deleteButton.addActionListener(e -> deleteSelectedCourses());
    }

    private void loadCourses() {
        try {
            courses = courseDAO.getAllCourses();
            tableModel.setRowCount(0); // Clear existing data

            for (CourseModel course : courses) {
                tableModel.addRow(new Object[]{
                        false,
                        course.getCourseId(),
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getCredit(),
                        course.getHours(),
                        course.getDepartmentHasUndergraduateLevelModel().getDepartment().getName(),
                        course.getDepartmentHasUndergraduateLevelModel().getUndergraduateLevel().getLevel(),
                        course.getDepartmentHasUndergraduateLevelModel().getSemester().getSemester()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading courses: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAddCourseDialog() {
        JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Add New Course", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(600, 500);

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));

        JTextField courseIdField = new JTextField();
        JTextField courseCodeField = new JTextField();
        JTextField courseNameField = new JTextField();
        JTextField creditField = new JTextField();
        JTextField hoursField = new JTextField();

        // These would ideally be populated from the database
        JComboBox<String> departmentCombo = new JComboBox<>(new String[]{"Computer Science", "Mathematics", "Physics"});
        JComboBox<String> levelCombo = new JComboBox<>(new String[]{"Undergraduate", "Graduate"});
        JComboBox<String> semesterCombo = new JComboBox<>(new String[]{"First", "Second", "Summer"});

        formPanel.add(new JLabel("Course ID:"));
        formPanel.add(courseIdField);
        formPanel.add(new JLabel("Course Code:"));
        formPanel.add(courseCodeField);
        formPanel.add(new JLabel("Course Name:"));
        formPanel.add(courseNameField);
        formPanel.add(new JLabel("Credit Hours:"));
        formPanel.add(creditField);
        formPanel.add(new JLabel("Contact Hours:"));
        formPanel.add(hoursField);
        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentCombo);
        formPanel.add(new JLabel("Level:"));
        formPanel.add(levelCombo);
        formPanel.add(new JLabel("Semester:"));
        formPanel.add(semesterCombo);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> {
            try {
                CourseModel course = new CourseModel();
                course.setCourseId(courseIdField.getText());
                course.setCourseCode(courseCodeField.getText());
                course.setCourseName(courseNameField.getText());
                course.setCredit(creditField.getText());
                course.setHours(hoursField.getText());

                // Create department has undergrad level model
                DepartmentModel department = new DepartmentModel();
                department.setName((String) departmentCombo.getSelectedItem());

                UndergraduateLevelModel level = new UndergraduateLevelModel();
                level.setLevel((String) levelCombo.getSelectedItem());

                SemesterModel semester = new SemesterModel();
                semester.setSemester((String) semesterCombo.getSelectedItem());

                DepartmentHasUndergraduateLevelModel dhul = new DepartmentHasUndergraduateLevelModel();
                dhul.setDepartment(department);
                dhul.setUndergraduateLevel(level);
                dhul.setSemester(semester);
                // You would need to set the actual ID from the database here

                course.setDepartmentHasUndergraduateLevelModel(dhul);

                if (courseDAO.addCourse(course)) {
                    JOptionPane.showMessageDialog(dialog, "Course added successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadCourses();
                    dialog.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error adding course: " + ex.getMessage(),
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

    private void showUpdateCourseDialog() {
        int selectedRow = getSelectedCourseRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a course to update",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String courseId = (String) tableModel.getValueAt(selectedRow, 1);
        try {
            CourseModel course = courseDAO.getCourseById(courseId);
            if (course == null) {
                JOptionPane.showMessageDialog(this, "Course not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "Update Course", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(600, 500);

            JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));

            JTextField courseIdField = new JTextField(course.getCourseId());
            courseIdField.setEditable(false);
            JTextField courseCodeField = new JTextField(course.getCourseCode());
            JTextField courseNameField = new JTextField(course.getCourseName());
            JTextField creditField = new JTextField(course.getCredit());
            JTextField hoursField = new JTextField(course.getHours());

            // These would ideally be populated from the database
            JComboBox<String> departmentCombo = new JComboBox<>(new String[]{"Computer Science", "Mathematics", "Physics"});
            departmentCombo.setSelectedItem(course.getDepartmentHasUndergraduateLevelModel().getDepartment().getName());

            JComboBox<String> levelCombo = new JComboBox<>(new String[]{"Undergraduate", "Graduate"});
            levelCombo.setSelectedItem(course.getDepartmentHasUndergraduateLevelModel().getUndergraduateLevel().getLevel());

            JComboBox<String> semesterCombo = new JComboBox<>(new String[]{"First", "Second", "Summer"});
            semesterCombo.setSelectedItem(course.getDepartmentHasUndergraduateLevelModel().getSemester().getSemester());

            formPanel.add(new JLabel("Course ID:"));
            formPanel.add(courseIdField);
            formPanel.add(new JLabel("Course Code:"));
            formPanel.add(courseCodeField);
            formPanel.add(new JLabel("Course Name:"));
            formPanel.add(courseNameField);
            formPanel.add(new JLabel("Credit Hours:"));
            formPanel.add(creditField);
            formPanel.add(new JLabel("Contact Hours:"));
            formPanel.add(hoursField);
            formPanel.add(new JLabel("Department:"));
            formPanel.add(departmentCombo);
            formPanel.add(new JLabel("Level:"));
            formPanel.add(levelCombo);
            formPanel.add(new JLabel("Semester:"));
            formPanel.add(semesterCombo);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton updateButton = new JButton("Update");
            JButton cancelButton = new JButton("Cancel");

            updateButton.addActionListener(e -> {
                try {
                    course.setCourseCode(courseCodeField.getText());
                    course.setCourseName(courseNameField.getText());
                    course.setCredit(creditField.getText());
                    course.setHours(hoursField.getText());

                    // Update department has undergrad level model
                    course.getDepartmentHasUndergraduateLevelModel().getDepartment().setName((String) departmentCombo.getSelectedItem());
                    course.getDepartmentHasUndergraduateLevelModel().getUndergraduateLevel().setLevel((String) levelCombo.getSelectedItem());
                    course.getDepartmentHasUndergraduateLevelModel().getSemester().setSemester((String) semesterCombo.getSelectedItem());

                    if (courseDAO.updateCourse(course)) {
                        JOptionPane.showMessageDialog(dialog, "Course updated successfully!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        loadCourses();
                        dialog.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Error updating course: " + ex.getMessage(),
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
            JOptionPane.showMessageDialog(this, "Error loading course: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showViewCourseDialog() {
        int selectedRow = getSelectedCourseRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a course to view",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String courseId = (String) tableModel.getValueAt(selectedRow, 1);
        try {
            CourseModel course = courseDAO.getCourseById(courseId);
            if (course == null) {
                JOptionPane.showMessageDialog(this, "Course not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JDialog dialog = new JDialog((Frame)SwingUtilities.getWindowAncestor(this), "View Course", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(500, 400);

            JPanel viewPanel = new JPanel(new GridLayout(9, 2, 10, 10));

            viewPanel.add(new JLabel("Course ID:"));
            viewPanel.add(new JLabel(course.getCourseId()));
            viewPanel.add(new JLabel("Course Code:"));
            viewPanel.add(new JLabel(course.getCourseCode()));
            viewPanel.add(new JLabel("Course Name:"));
            viewPanel.add(new JLabel(course.getCourseName()));
            viewPanel.add(new JLabel("Credit Hours:"));
            viewPanel.add(new JLabel(course.getCredit()));
            viewPanel.add(new JLabel("Contact Hours:"));
            viewPanel.add(new JLabel(course.getHours()));
            viewPanel.add(new JLabel("Department:"));
            viewPanel.add(new JLabel(course.getDepartmentHasUndergraduateLevelModel().getDepartment().getName()));
            viewPanel.add(new JLabel("Level:"));
            viewPanel.add(new JLabel(course.getDepartmentHasUndergraduateLevelModel().getUndergraduateLevel().getLevel()));
            viewPanel.add(new JLabel("Semester:"));
            viewPanel.add(new JLabel(course.getDepartmentHasUndergraduateLevelModel().getSemester().getSemester()));

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> dialog.dispose());

            dialog.add(viewPanel, BorderLayout.CENTER);
            dialog.add(closeButton, BorderLayout.SOUTH);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading course: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedCourses() {
        List<String> courseIdsToDelete = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((Boolean) tableModel.getValueAt(i, 0)) {
                courseIdsToDelete.add((String) tableModel.getValueAt(i, 1));
            }
        }

        if (courseIdsToDelete.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one course to delete",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete " + courseIdsToDelete.size() + " course(s)?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int deletedCount = 0;
                for (String courseId : courseIdsToDelete) {
                    if (courseDAO.deleteCourse(courseId)) {
                        deletedCount++;
                    }
                }
                JOptionPane.showMessageDialog(this, "Successfully deleted " + deletedCount + " course(s)",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                loadCourses();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error deleting courses: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private int getSelectedCourseRow() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((Boolean) tableModel.getValueAt(i, 0)) {
                return i;
            }
        }
        return -1;
    }
}
