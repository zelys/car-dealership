package ui;

import controller.VehicleController;
import lombok.Getter;
import lombok.Setter;
import model.VehicleBrand;
import model.VehicleType;
import ui.utility.EnumComboBox;
import ui.utility.UIMediator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static ui.utility.EnumComboBox.setupDoorCount;
import static ui.utility.EnumComboBox.setupEnumComboBox;
import static ui.utility.FieldsSetup.cleanFields;

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

    private UIMediator mediator;
    private VehicleController controller;

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
        guardarButton.addActionListener(e -> setFields());

        // CLEAN BUTTON
        limpiarButton.addActionListener(e -> cleanFields(RegistrationForm.this));
    }

    private void setFields() {
        String licensePlate = licensePlateField.getText().toUpperCase();
        String color = colorField.getText().toUpperCase();
        String engine = engineField.getText().toUpperCase();
        String model = modelField.getText().toUpperCase();
        String doors = String.valueOf(doorsComboBox.getSelectedItem());
        String type = String.valueOf(typeComboBox.getSelectedItem());
        String make = String.valueOf(brandComboBox.getSelectedItem());

        var fields = List.of(licensePlate, color, engine, model, doors, type, make);

        if (validateEmptyFields(fields)) {
            if (!controller.hasPlatesDuplicated(licensePlate, controller.getAllVehicles())) {
                controller.createVehicle(make, type, doors, model, engine, color, licensePlate);
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
                cleanFields(RegistrationForm.this);
            } else {
                JOptionPane.showMessageDialog(null, "La placa patente ya existe en el sistema");
            }
        }
    }

    static boolean validateEmptyFields(List<String> fields) {
        for (String field : fields) {
            if (field.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                return false;
            }
        }
        return true;
    }
}

