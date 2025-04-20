package controller.lecturer;

import controller.common.DBConnection;
import controller.callback.lecturer.MaterialTableLoadCallback;
import view.lecturer.dialog.PDFPreviewDialog;
import view.lecturer.panels.CoursePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonEditor extends DefaultCellEditor {

    private JButton button;
    private CoursePanel coursePanel;
    private MaterialTableLoadCallback materialTableLoadCallback;

    private String basePath = System.getProperty("user.dir");

    public ButtonEditor(JCheckBox checkBox, JTable table, CoursePanel coursePanel, MaterialTableLoadCallback materialTableLoadCallback) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        this.coursePanel = coursePanel;
        this.materialTableLoadCallback = materialTableLoadCallback;

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int row = table.getEditingRow();
                int column = table.getEditingColumn();

                String materialId = table.getValueAt(row, 0).toString(); // material_id
                String name = table.getValueAt(row, 1).toString();       // name
                String url = basePath+table.getValueAt(row, 3).toString().replace("/","\\");         // might be in data or could be looked up

                if (column == 4) {
                    // Preview button clicked
                    loadPreview(url);
                } else if (column == 5) {
                    // Remove button clicked
                    removeMaterial(materialId, url, name);
                }

                fireEditingStopped();
            }
        });
    }

    public void loadPreview(String url) {
        // preview material:

        PDFPreviewDialog pdfPreviewDialog = new PDFPreviewDialog(coursePanel, url);
        pdfPreviewDialog.setVisible(true);

    }

    public void removeMaterial(String materialId, String url, String name) {
        // remove material:

        File fileToDelete = new File(url);

        if (fileToDelete.exists()) {

            boolean deleted = fileToDelete.delete();
            if (deleted) {

                String query = "DELETE FROM `material` WHERE `material_id`=?";
                DBConnection.iud(query, materialId);

                materialTableLoadCallback.onTableLoadCallback();

                JOptionPane.showMessageDialog(coursePanel, "File Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(coursePanel, "Failed to delete the file: " + name, "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(coursePanel, "File Not Found", "File Not Found", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        button.setText((value == null) ? "" : value.toString());
        return button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }
}
