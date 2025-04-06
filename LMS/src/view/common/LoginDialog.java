package view.common;

import controller.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.AdminModel;
import model.DepartmentModel;
import model.LecturerModel;
import model.StudentModel;
import model.TechnicalOfficerModel;
import view.admin.AdminDashboard;
import view.lecturer.LecturerDashboard;
import view.student.StudentDashboard;
import view.technicalOfficer.TechnicalOfficerDashboard;

public class LoginDialog extends javax.swing.JDialog {

    private final String type;

    public LoginDialog(java.awt.Frame parent, boolean modal, String type) {
        super(parent, modal);
        initComponents();

        this.type = type;
        setUpBg();
    }

    private void setUpBg() {
        jLabel1.setText(type + " Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Login Now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(16, 16, 16)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
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
                JOptionPane.showMessageDialog(this, "Invalid Type", "Error", JOptionPane.ERROR_MESSAGE);
                return;

        }

        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());

        if (username.isBlank()) {
            JOptionPane.showMessageDialog(this, "Missing Username", "Missing", JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
            return;
        }

        if (password.isBlank()) {
            JOptionPane.showMessageDialog(this, "Missing Password", "Missing", JOptionPane.WARNING_MESSAGE);
            jPasswordField1.requestFocus();
            return;
        }

        query += " WHERE `username`=" + username + " AND `password`=" + password;

        ResultSet searchResult = DBConnection.search(query);
        if (searchResult != null) {
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

                            AdminDashboard adminDashboard = new AdminDashboard(admin);
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

                            LecturerDashboard lecturerDashboard = new LecturerDashboard(lecturer);
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

                            StudentDashboard studentDashboard = new StudentDashboard(student);
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

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
