package view.lecturer.panels;

import controller.DBConnection;
import view.lecturer.LecturerDashboard;

import javax.swing.*;

public class ProfilePanel extends JPanel{
    private JPanel panel1;

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    private void createUIComponents() {
        initComponents();
        setUpBg();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setText("Email:");

        jLabel3.setText("Contact Number:");

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(jButton1)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // update:

        String email = jTextField1.getText();
        String contact = jTextField2.getText();

        if(email.equals(LecturerDashboard.loginLecturerModel.getEmail()) &&
                contact.equals(LecturerDashboard.loginLecturerModel.getContactNumber())){

            JOptionPane.showMessageDialog(this,"Noting to Update","No New Info",JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(email.isBlank()){
            JOptionPane.showMessageDialog(this,"Please Fill The Email","Missing Email",JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(contact.isBlank()){
            JOptionPane.showMessageDialog(this,"Please Fill The Contact Number","Missing Contact Number",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String query = "UPDATE `lecturer` SET `email`=?,`contact_number`=? WHERE `lecturer`.`user_id`=?";
        DBConnection.iud(query,email,contact,LecturerDashboard.loginLecturerModel.getId());

        LecturerDashboard.loginLecturerModel.setEmail(email);
        LecturerDashboard.loginLecturerModel.setContactNumber(contact);

        JOptionPane.showMessageDialog(this,"Update Success","Done",JOptionPane.INFORMATION_MESSAGE);

    }

    private void setUpBg() {

        jLabel1.setText(LecturerDashboard.loginLecturerModel.getUsername());
        jTextField1.setText(LecturerDashboard.loginLecturerModel.getEmail());
        jTextField2.setText(LecturerDashboard.loginLecturerModel.getContactNumber());
    }
}
