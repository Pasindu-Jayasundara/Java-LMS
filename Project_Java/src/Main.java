import javax.swing.*;

import mdlaf.MaterialLookAndFeel;


public class Main {
    public static void main(String[] args) {
        try {
            //advanced look
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Main method to launch the Student GUI

            Student student=new Student(); // Launches the Student GUI in the event dispatch thread


    }
}
