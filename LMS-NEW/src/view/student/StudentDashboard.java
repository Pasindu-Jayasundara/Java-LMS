package view.student;

import model.StudentModel;

import javax.swing.*;

public class StudentDashboard extends JFrame {

    private final StudentModel loginStudentModel;
    private JPanel panel1;

    public StudentDashboard(StudentModel loginStudentModel) {
        this.loginStudentModel = loginStudentModel;
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
