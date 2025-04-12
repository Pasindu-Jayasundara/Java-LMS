import com.formdev.flatlaf.FlatLightLaf;
import view.common.Welcome;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }

                Welcome welcome = new Welcome();
                welcome.setVisible(true);

            }
        });
    }
}
