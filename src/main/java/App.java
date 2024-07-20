import controller.VehicleController;
import form.MainForm;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainForm form = new MainForm();
            form.setLocationRelativeTo(null);
            form.setVisible(true);
        });
    }
}
