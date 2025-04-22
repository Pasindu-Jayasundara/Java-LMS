package controller.lecturer.coursePanel;

import controller.common.DBConnection;
import controller.callback.lecturer.MaterialTableLoadCallback;
import view.lecturer.dialog.CourseDetailDialog;
import view.lecturer.dialog.MarksDialog;
import view.lecturer.dialog.PDFPreviewDialog;
import view.lecturer.panels.CoursePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonEditor extends DefaultCellEditor {

    private JButton button;
    private Object coursePanel;
    private MaterialTableLoadCallback materialTableLoadCallback;
    private String basePath = System.getProperty("user.dir");

    public boolean deleteFromMarks;

    public ButtonEditor(JCheckBox checkBox, CoursePanel coursePanel, MaterialTableLoadCallback materialTableLoadCallback) {
        super(checkBox);
        this.coursePanel = coursePanel;
        this.materialTableLoadCallback = materialTableLoadCallback;
    }

    public ButtonEditor(JCheckBox checkBox, CourseDetailDialog courseDetailDialog, MaterialTableLoadCallback materialTableLoadCallback) {
        super(checkBox);
        this.coursePanel = courseDetailDialog;
        this.materialTableLoadCallback = materialTableLoadCallback;
    }

    public ButtonEditor(JCheckBox checkBox, MarksDialog marksDialog) {
        super(checkBox);
        this.coursePanel = marksDialog;
    }

    public ButtonEditor(JCheckBox checkBox, MarksDialog marksDialog,boolean deleteFromMarks, MaterialTableLoadCallback materialTableLoadCallback) {
        super(checkBox);
        this.coursePanel = marksDialog;
        this.materialTableLoadCallback = materialTableLoadCallback;
        this.deleteFromMarks = deleteFromMarks;
    }

    public void loadPreview(String url) {
        PDFPreviewDialog pdfPreviewDialog = new PDFPreviewDialog((Component) coursePanel, url);
        pdfPreviewDialog.setVisible(true);
    }

    public void removeMaterial(String materialId, String url, String name) {
        File fileToDelete = new File(url);

        if (fileToDelete.exists()) {
            boolean deleted = fileToDelete.delete();
            if (deleted) {

                String query = "";
                if(deleteFromMarks){
                    query = "DELETE FROM `marks_document` WHERE `id`=?";
                }else{
                    query = "DELETE FROM `material` WHERE `material_id`=?";
                }
                DBConnection.iud(query, materialId);

                if(deleteFromMarks){
                    materialTableLoadCallback.onTableLoadCallback(materialId);
                }else{
                    materialTableLoadCallback.onTableLoadCallback();
                }
                JOptionPane.showMessageDialog((Component) coursePanel, "File Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog((Component) coursePanel, "Failed to delete the file: " + name, "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog((Component) coursePanel, "File Not Found", "File Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {

        button = new JButton();
        button.setOpaque(true);
        button.setText((value == null) ? "" : value.toString());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String materialId = table.getValueAt(row, 0).toString(); // material_id
                String name = table.getValueAt(row, 1).toString();       // name
                String url = basePath + table.getValueAt(row, 3).toString().replace("/", "\\"); // file path

                if (column == 4) {
                    loadPreview(url);
                } else if (column == 5) {
                    removeMaterial(materialId, url, name);
                }

                if(table.getRowCount() > 0){
                    fireEditingStopped();
                }
            }
        });

        return button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }
}
