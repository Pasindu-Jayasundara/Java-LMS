package controller.lecturer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        setText((value == null) ? "" : value.toString());

//        if ("Preview".equalsIgnoreCase(getText())) {
//            setBackground(Color.GREEN);
//            setForeground(Color.WHITE);
//        } else if ("Remove".equalsIgnoreCase(getText())) {
//            setBackground(Color.RED);
//            setForeground(Color.WHITE);
//        } else {
//            setBackground(UIManager.getColor("Button.background"));
//            setForeground(Color.BLACK);
//        }

        return this;
    }
}
