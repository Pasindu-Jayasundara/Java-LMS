package view.common;

import controller.common.DBConnection;
import controller.common.Validation;
import controller.callback.common.LoginSuccessCallback;
import model.*;
import view.admin.AdminDashboard;
import view.lecturer.LecturerDashboard;
import view.student.StudentDashboard;
import view.technicalOfficer.TechnicalOfficerDashboard;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JDialog {

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;

    private final String type;

    private final LoginSuccessCallback loginSuccessCallback;

    public Login(java.awt.Frame parent, String type, LoginSuccessCallback loginSuccessCallback) {
        super(parent, true);

        this.type = type;
        this.loginSuccessCallback = loginSuccessCallback;

        setUpBg();
    }

    private void setUpBg() {
        jLabel1.setText(type + " Login");
        jTextField1.requestFocus();
    }

    private void createUIComponents() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password:");

        jButton1.setText("Login Now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 56, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(18, 18, 18))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addGap(16, 16, 16)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextField1)
                                                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(59, 59, 59))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String query = "SELECT * FROM ";

        switch (type) {
            case "Admin":
                query += "`admin`";
                break;
            case "Lecturer":
                query += "`lecturer`";
                break;
            case "Student":
                query += "`student`";
                break;
            case "Technical Officer":
                query += "`technical_officer` INNER JOIN `department` ON `department`.`department_id` = `technical_officer`.`department_department_id`";
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid Type", "Error", JOptionPane.ERROR_MESSAGE);
                return;

        }

        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());

        if (username.isBlank()) {
            JOptionPane.showMessageDialog(this, "Missing Email", "Missing", JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
            return;
        }

        if (password.isBlank()) {
            JOptionPane.showMessageDialog(this, "Missing Password", "Missing", JOptionPane.WARNING_MESSAGE);
            jPasswordField1.requestFocus();
            return;
        }

        if (!Validation.isValidEmail(username.trim())) {
            JOptionPane.showMessageDialog(this, "Incorrect Email Format", "Incorrect Data", JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();

            JLabel errorLabel = new JLabel("Incorrect Email Address");
            errorLabel.setForeground(java.awt.Color.RED);
            jPanel3.setLayout(new FlowLayout());
            jPanel3.add(errorLabel);

            pack();

            return;
        }

        jPanel3.removeAll();
        jPanel3.setLayout(null);
        pack();

        if (!Validation.isValidPassword(password.trim())) {
            JOptionPane.showMessageDialog(this, "Incorrect Password Format", "Incorrect Data", JOptionPane.WARNING_MESSAGE);
            jPasswordField1.requestFocus();

            JLabel errorLabel = new JLabel("<html>Password Must Contain At Least:<br><br>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;    1)  One Uppercase Letter<br>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;    2)  One Lowercase Letter<br>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;    3)  One Digit<br>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;    4)  One Special Character<br>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;    5)  Minimum Length of 8 Characters</html>");
            errorLabel.setForeground(java.awt.Color.RED);
            jPanel2.setLayout(new FlowLayout());
            jPanel2.add(errorLabel);

            pack();
            return;
        }

        jPanel2.removeAll();
        jPanel2.setLayout(null);
        pack();

        query += " WHERE (`email`=? AND `password`=?) AND `status_status_id`='1' ";

        ResultSet searchResult = DBConnection.search(query, username, password);
        if (searchResult != null) {
            try {

                searchResult.last();
                int rowCount = searchResult.getRow();
                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(this, "Could Not Find The " + type, type + " Not Found", JOptionPane.INFORMATION_MESSAGE);
                }
                searchResult.beforeFirst();

                while (searchResult.next()) {

                    switch (type) {
                        case "Admin":

                            AdminModel admin = new AdminModel();
                            admin.setId(searchResult.getInt("user_id"));
                            admin.setUsername(searchResult.getString("username"));
                            admin.setPassword(searchResult.getString("password"));
                            admin.setEmail(searchResult.getString("email"));
                            admin.setContactNumber(searchResult.getString("contact_number"));

                            AdminDashboard adminDashboard = new AdminDashboard(admin);
                            adminDashboard.setVisible(true);

                            dispose();

                            break;
                        case "Lecturer":

                            LecturerModel lecturer = new LecturerModel();
                            lecturer.setId(searchResult.getInt("user_id"));
                            lecturer.setUsername(searchResult.getString("username"));
                            lecturer.setPassword(searchResult.getString("password"));
                            lecturer.setEmail(searchResult.getString("email"));
                            lecturer.setContactNumber(searchResult.getString("contact_number"));

                            LecturerDashboard lecturerDashboard = new LecturerDashboard(lecturer);
                            lecturerDashboard.setVisible(true);

                            dispose();

                            loginSuccessCallback.login(true);

                            break;
                        case "Student":

                            StudentModel student = new StudentModel();
                            student.setId(searchResult.getInt("user_id"));
                            student.setUsername(searchResult.getString("username"));
                            student.setPassword(searchResult.getString("password"));
                            student.setEmail(searchResult.getString("email"));
                            student.setContactNumber(searchResult.getString("contact_number"));
                            student.setProfilePicture(searchResult.getString("profile_picture"));
                            student.setEnrollmentDate(searchResult.getString("enrollment_date"));

                            StudentDashboard studentDashboard = new StudentDashboard(student);
                            studentDashboard.setVisible(true);

                            this.dispose();

                            break;
                        case "Technical Officer":

                            TechnicalOfficerModel technicalOfficer = new TechnicalOfficerModel();
                            technicalOfficer.setId(searchResult.getInt("user_id"));
                            technicalOfficer.setUsername(searchResult.getString("username"));
                            technicalOfficer.setPassword(searchResult.getString("password"));
                            technicalOfficer.setEmail(searchResult.getString("email"));
                            technicalOfficer.setContactNumber(searchResult.getString("contact_number"));

                            DepartmentModel departmentModel = new DepartmentModel();
                            departmentModel.setId(searchResult.getString("department.department_id"));
                            departmentModel.setName(searchResult.getString("department_name"));

                            technicalOfficer.setDepartment(departmentModel);

                            TechnicalOfficerDashboard technicalOfficerDashboard = new TechnicalOfficerDashboard(technicalOfficer);
                            technicalOfficerDashboard.setVisible(true);

                            this.dispose();

                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Invalid Type", "Error", JOptionPane.ERROR_MESSAGE);
                            return;

                    }

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Something Went Wrong !", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}