/*
 * Created by JFormDesigner on Sat Apr 05 01:29:33 IST 2025
 */

package view.technicalOfficer;

import model.TechnicalOfficerModel;

import javax.swing.*;
import javax.swing.GroupLayout;

public class TechnicalOfficer_Dashboard extends JFrame {

    private TechnicalOfficerModel LoginTechnicalOfficerModel;

    public TechnicalOfficer_Dashboard(TechnicalOfficerModel LoginTechnicalOfficerModel) {

        initComponents();
        this.LoginTechnicalOfficerModel = LoginTechnicalOfficerModel;
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
