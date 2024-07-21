package ui;

import ui.utility.UIMediator;

import javax.swing.*;

public class MainForm extends JFrame {
    private JPanel contentPane;
    private JButton registrarButton;
    private JButton inventarioButton;
    private JButton salirButton;
    private UIMediator mediator;

    private RegistrationForm registrationForm;
    private StockForm stockForm;

    public MainForm(UIMediator mediator) {
        this.mediator = mediator;
        setContentPane(contentPane);
        setResizable(false);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registrarButton.addActionListener(e -> mediator.showRegistrationForm());
        inventarioButton.addActionListener(e -> mediator.showStockForm());
        salirButton.addActionListener(e -> mediator.closeApplication());
    }
}
