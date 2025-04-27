package view.admin;

import model.AdminModel;

import javax.swing.*;

public class AdminDashboard extends JFrame{
    private JPanel panel1;
    private final AdminModel loginAdminModel;

    public AdminDashboard(AdminModel loginAdminModel) {
        this.loginAdminModel = loginAdminModel;
    }

    private void createUIComponents() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
}
