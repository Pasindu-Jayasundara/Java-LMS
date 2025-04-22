package controller.lecturer.exam;

import controller.callback.lecturer.MoreInfoCallback;
import controller.callback.lecturer.UpdateExamMarksCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMarksButtonEditor extends DefaultCellEditor{

    private JButton button;
    private UpdateExamMarksCallback updateExamMarksCallback;

    public UpdateMarksButtonEditor(JCheckBox checkBox, JTable table, UpdateExamMarksCallback updateExamMarksCallback) {
        super(checkBox);
        this.updateExamMarksCallback = updateExamMarksCallback;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {

        button = new JButton();
        button.setOpaque(true);
        button.setText((value == null) ? "" : value.toString());

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String examId = table.getValueAt(row, 0).toString();
                updateExamMarksCallback.onExamMarkUpdateBtnClick(examId);
            }
        });
        return button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }

}
