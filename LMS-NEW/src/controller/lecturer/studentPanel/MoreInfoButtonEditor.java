package controller.lecturer.studentPanel;

import controller.callback.lecturer.MoreInfoCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoreInfoButtonEditor extends DefaultCellEditor{

    private JButton button;

    public MoreInfoButtonEditor(JCheckBox checkBox, MoreInfoCallback moreInfoCallback) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               moreInfoCallback.onMoreInfoCallback();
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
