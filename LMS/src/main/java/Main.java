import com.formdev.flatlaf.themes.FlatMacLightLaf;
import view.common.Login;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
            
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Login loginView = new Login();
                loginView.setLocationRelativeTo(null);
                loginView.setVisible(true);
                loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginView.setResizable(false);

            }
        });

    }
}
