package controller.lecturer.studentPanel;

import controller.callback.lecturer.MoreInfoCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoreInfoButtonEditor extends DefaultCellEditor{

    private JButton button;
    private MoreInfoCallback moreInfoCallback;

    public MoreInfoButtonEditor(JCheckBox checkBox, MoreInfoCallback moreInfoCallback) {
        super(checkBox);
        this.moreInfoCallback = moreInfoCallback;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {

        button = new JButton();
        button.setOpaque(true);
        button.setText((value == null) ? "" : value.toString());

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moreInfoCallback.onMoreInfoCallback(table.getValueAt(row, 0).toString());
            }
        });
        return button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }

}
