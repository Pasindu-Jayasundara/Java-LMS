/*
 * Created by JFormDesigner on Sat Apr 05 01:28:56 IST 2025
 */

package view.lecturer;

import model.LecturerModel;

import javax.swing.*;
import javax.swing.GroupLayout;

public class Lecturer_Dashboard extends JFrame {

    private LecturerModel loginLecturerModel;

    public Lecturer_Dashboard(LecturerModel loginLecturerModel) {

        initComponents();
        this.loginLecturerModel = loginLecturerModel;
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
