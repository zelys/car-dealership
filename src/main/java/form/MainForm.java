package form;

import controller.VehicleController;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame {
    private JPanel contentPane;
    private JButton registrarButton;
    private JButton inventarioButton;
    private JButton salirButton;

    private RegistrationForm registrationForm;
    private StockForm stockForm;

    public MainForm() {
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                VehicleController.closeConnection();
                System.exit(0);
            }
        });

        registrarButton.addActionListener(e -> {
            registrationForm = new RegistrationForm();
            registrationForm.setLocationRelativeTo(contentPane);
            registrationForm.setVisible(true);
            dispose();
        });

        inventarioButton.addActionListener(e -> {
            stockForm = new StockForm();
            stockForm.setLocationRelativeTo(contentPane);
            stockForm.setVisible(true);
            dispose();
        });

        salirButton.addActionListener(e -> {
            VehicleController.closeConnection();
            System.exit(0);
        });
    }
}
