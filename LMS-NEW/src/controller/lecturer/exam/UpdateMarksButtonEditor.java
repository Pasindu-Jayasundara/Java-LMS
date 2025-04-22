package controller.lecturer.exam;

import controller.callback.lecturer.MoreInfoCallback;
import controller.callback.lecturer.UpdateExamMarksCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.lecturer.panels.ExamPanel.selectedRow;

public class UpdateMarksButtonEditor extends DefaultCellEditor{

    private JButton button;

    public UpdateMarksButtonEditor(JCheckBox checkBox, JTable table, UpdateExamMarksCallback updateExamMarksCallback) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String examId = table.getValueAt(selectedRow, 0).toString();
                updateExamMarksCallback.onExamMarkUpdateBtnClick(examId,selectedRow);
            }
        });
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
