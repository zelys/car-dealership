package ui;

import controller.VehicleController;
import lombok.Getter;
import lombok.Setter;
import model.Vehicle;
import model.VehicleBrand;
import model.VehicleType;
import ui.utility.EnumComboBox;
import ui.utility.UIMediator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static ui.utility.FieldsSetup.setVehicleFields;

@Getter
public class EditForm extends JFrame {

    private JTextField licensePlateField;
    private JTextField colorField;
    private JTextField engineField;
    private JTextField modelField;
    private JComboBox<Integer> doorsComboBox;
    private JComboBox<VehicleType> typeComboBox;
    private JComboBox<VehicleBrand> brandComboBox;
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel contentPane;

    UIMediator mediator;
    VehicleController controller;
    Vehicle vehicle;

    public EditForm(UIMediator mediator, VehicleController controller) {
        this.mediator = mediator;
        this.controller = controller;
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediator.showStockForm();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setVehicleFields(vehicle, EditForm.this);
            }
        });

        EnumComboBox.setupEnumComboBox(typeComboBox, VehicleType.class);
        EnumComboBox.setupEnumComboBox(brandComboBox, VehicleBrand.class);

        // BOTÓN GUARDAR
        guardarButton.addActionListener(e -> {
            String licensePlate = licensePlateField.getText().toUpperCase();
            String color = colorField.getText().toUpperCase();
            String engine = engineField.getText().toUpperCase();
            String model = modelField.getText().toUpperCase();
            String doors = String.valueOf(doorsComboBox.getSelectedItem());
            String type = String.valueOf(typeComboBox.getSelectedItem());
            String make = String.valueOf(brandComboBox.getSelectedItem());

            var fields = List.of(licensePlate, color, engine, model, doors, type, make);
            if (RegistrationForm.validateEmptyFields(fields)) {
                controller.updateVehicle(vehicle, make, type, doors, model, engine, color, licensePlate);
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
                dispose();
                mediator.showStockForm();
            }
        });
        cancelarButton.addActionListener(e -> setVehicleFields(vehicle, EditForm.this));
    }
}

