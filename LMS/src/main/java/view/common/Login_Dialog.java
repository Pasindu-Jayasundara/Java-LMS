/*
 * Created by JFormDesigner on Sat Apr 05 00:42:26 IST 2025
 */

package view.common;

import controller.DBConnection;
import model.*;
import view.admin.Admin_Dashboard;
import view.lecturer.Lecturer_Dashboard;
import view.student.Student_Dashboard;
import view.technicalOfficer.TechnicalOfficer_Dashboard;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

public class Login_Dialog extends JDialog {

    private final String type;
    private final Window window;

    public Login_Dialog(Window owner, String type) {
        super(owner);
        initComponents();

        this.type = type;
        this.window = owner;

        setUpBg();
    }

    private void setUpBg() {
        label1.setText(type);
    }

    private void loginBtn(ActionEvent e) {

        String query = "SELECT * FROM ";

        switch (type) {
            case "admin":
                query += "`admin`";
                break;
            case "lecturer":
                query += "`lecturer`";
                break;
            case "student":
                query += "`student`";
                break;
            case "technicalOfficer":
                query += "`technical_officer` INNER JOIN `department` ON `department`.`department_id` = `technical_officer`.`department_department_id`";
                break;
            default:
                JOptionPane.showMessageDialog(logindialog, "Invalid Type", "Error", JOptionPane.ERROR_MESSAGE);
                return;

        }

        String username = textField1.getText();
        String password = String.valueOf(passwordField1.getPassword());

        if(username.isBlank()){
            JOptionPane.showMessageDialog(logindialog, "Missing Username", "Missing", JOptionPane.WARNING_MESSAGE);
            textField1.requestFocus();
            return;
        }

        if(password.isBlank()){
            JOptionPane.showMessageDialog(logindialog, "Missing Password", "Missing", JOptionPane.WARNING_MESSAGE);
            passwordField1.requestFocus();
            return;
        }

        query += " WHERE `username`="+username+" AND `password`="+password;

        ResultSet searchResult = DBConnection.search(query);
        if(searchResult!=null){
            try {

                while (searchResult.next()) {

                    switch (type) {
                        case "admin":

                            AdminModel admin = new AdminModel();
                            admin.setId(searchResult.getInt("user_id"));
                            admin.setUsername(searchResult.getString("username"));
                            admin.setPassword(searchResult.getString("password"));
                            admin.setEmail(searchResult.getString("email"));
                            admin.setContactNumber(searchResult.getString("contact_number"));

                            Admin_Dashboard adminDashboard = new Admin_Dashboard(admin);
                            adminDashboard.setVisible(true);

                            this.dispose();

                            break;
                        case "lecturer":

                            LecturerModel lecturer = new LecturerModel();
                            lecturer.setId(searchResult.getInt("user_id"));
                            lecturer.setUsername(searchResult.getString("username"));
                            lecturer.setPassword(searchResult.getString("password"));
                            lecturer.setEmail(searchResult.getString("email"));
                            lecturer.setContactNumber(searchResult.getString("contact_number"));

                            Lecturer_Dashboard lecturerDashboard = new Lecturer_Dashboard(lecturer);
                            lecturerDashboard.setVisible(true);

                            this.dispose();

                            break;
                        case "student":

                            StudentModel student = new StudentModel();
                            student.setId(searchResult.getInt("user_id"));
                            student.setUsername(searchResult.getString("username"));
                            student.setPassword(searchResult.getString("password"));
                            student.setEmail(searchResult.getString("email"));
                            student.setContactNumber(searchResult.getString("contact_number"));
                            student.setProfilePicture(searchResult.getString("profile_picture"));
                            student.setEnrollmentDate(searchResult.getString("enrollment_date"));

                            Student_Dashboard studentDashboard = new Student_Dashboard(student);
                            studentDashboard.setVisible(true);

                            this.dispose();

                            break;
                        case "technicalOfficer":

                            TechnicalOfficerModel technicalOfficer = new TechnicalOfficerModel();
                            technicalOfficer.setId(searchResult.getInt("user_id"));
                            technicalOfficer.setUsername(searchResult.getString("username"));
                            technicalOfficer.setPassword(searchResult.getString("password"));
                            technicalOfficer.setEmail(searchResult.getString("email"));
                            technicalOfficer.setContactNumber(searchResult.getString("contact_number"));

                            DepartmentModel departmentModel = new DepartmentModel();
                            departmentModel.setId(searchResult.getInt("department.department_id"));
                            departmentModel.setName(searchResult.getString("department_name"));

                            technicalOfficer.setDepartment(departmentModel);

                            TechnicalOfficer_Dashboard technicalOfficerDashboard = new TechnicalOfficer_Dashboard(technicalOfficer);
                            technicalOfficerDashboard.setVisible(true);

                            this.dispose();

                            break;
                        default:
                            JOptionPane.showMessageDialog(logindialog, "Invalid Type", "Error", JOptionPane.ERROR_MESSAGE);
                            return;

                    }

                }
            } catch (SQLException ex) {
                e.getActionCommand();
            }

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Pasindu
        logindialog = new JDialog();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        button1 = new JButton();
        passwordField1 = new JPasswordField();

        //======== logindialog ========
        {
            logindialog.setModal(true);
            var logindialogContentPane = logindialog.getContentPane();

            //======== panel1 ========
            {
                panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                javax.swing.border.EmptyBorder(0,0,0,0), "",javax
                .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                .awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt
                .Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".
                equals(e.getPropertyName()))throw new RuntimeException();}});

                //---- label1 ----
                label1.setText("LOGIN");
                label1.setFont(new Font("Segoe UI", Font.BOLD, 16));

                //---- label2 ----
                label2.setText("Username:");

                //---- label3 ----
                label3.setText("Password:");

                //---- button1 ----
                button1.setText("Login Now");
                button1.addActionListener(e -> loginBtn(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(80, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(188, 188, 188))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                    .addComponent(label2)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(label3)
                                                    .addGap(9, 9, 9)))
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))))
                                    .addGap(73, 73, 73))))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(label1)
                            .addGap(34, 34, 34)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(42, 42, 42))
                );
            }

            GroupLayout logindialogContentPaneLayout = new GroupLayout(logindialogContentPane);
            logindialogContentPane.setLayout(logindialogContentPaneLayout);
            logindialogContentPaneLayout.setHorizontalGroup(
                logindialogContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            logindialogContentPaneLayout.setVerticalGroup(
                logindialogContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            logindialog.pack();
            logindialog.setLocationRelativeTo(window);
            logindialog.setAlwaysOnTop(true);
            logindialog.setVisible(true);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Pasindu
    private JDialog logindialog;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JButton button1;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
