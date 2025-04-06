import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import view.common.Login;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
            
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Login();
            }
        });

    }
}
