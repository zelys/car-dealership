package ui;

import controller.VehicleController;
import lombok.Getter;
import model.VehicleBrand;
import model.VehicleType;
import ui.utility.UIMediator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static ui.utility.EnumComboBox.setupDoorCount;
import static ui.utility.EnumComboBox.setupEnumComboBox;

@Getter
public class RegistrationForm extends JFrame {
    private JPanel contentPane;
    private JTextField licensePlateField;
    private JTextField colorField;
    private JTextField engineField;
    private JTextField modelField;
    private JComboBox<Integer> doorsComboBox;
    private JComboBox<VehicleType> typeComboBox;
    private JComboBox<VehicleBrand> brandComboBox;
    private JButton limpiarButton;
    private JButton guardarButton;

    UIMediator mediator;
    VehicleController controller;

    public RegistrationForm(UIMediator mediator, VehicleController controller) {
        this.mediator = mediator;
        this.controller = controller;
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediator.showMainForm();
            }
        });

        setupEnumComboBox(typeComboBox, VehicleType.class);
        setupEnumComboBox(brandComboBox, VehicleBrand.class);
        setupDoorCount(doorsComboBox);

        // SAVE BUTTON
        guardarButton.addActionListener(e -> mediator.createNewVehicle());

        // CLEAN BUTTON
        limpiarButton.addActionListener(e ->  mediator.cleanFields());
    }
}

