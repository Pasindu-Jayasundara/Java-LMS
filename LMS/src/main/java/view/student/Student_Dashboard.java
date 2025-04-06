/*
 * Created by JFormDesigner on Sat Apr 05 01:29:10 IST 2025
 */

package view.student;

import model.StudentModel;

import javax.swing.*;
import javax.swing.GroupLayout;

public class Student_Dashboard extends JFrame {

    private final StudentModel loginStudentModel;
    public Student_Dashboard(StudentModel loginStudentModel) {

        initComponents();
        this.loginStudentModel = loginStudentModel;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Pasindu

        //======== this ========
        var contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 400, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Pasindu
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
