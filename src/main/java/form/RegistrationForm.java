package form;

import controller.VehicleController;
import model.VehicleMake;
import model.VehicleType;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


public class RegistrationForm extends JFrame {
    private JPanel contentPane;
    private JTextField licensePlateField;
    private JTextField colorField;
    private JTextField engineField;
    private JTextField modelField;
    private JComboBox<Integer> doorsComboBox;
    private JComboBox<VehicleType> typeComboBox;
    private JComboBox<VehicleMake> makeComboBox;
    private JButton limpiarButton;
    private JButton guardarButton;

    private MainForm mainForm;
    private VehicleController control;

    public RegistrationForm() {
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainForm = new MainForm();
                // POSICIÓN de MainForm AL CERRAR VENTANA
                mainForm.setLocationRelativeTo(contentPane);
                mainForm.setVisible(true);
            }
        });

        addItems();

        // SAVE BUTTON
        guardarButton.addActionListener(e -> setFields());

        // CLEAN BUTTON
        limpiarButton.addActionListener(e -> cleanFields());
    }

    public void cleanFields() {
        makeComboBox.setSelectedIndex(0);
        typeComboBox.setSelectedIndex(0);
        doorsComboBox.setSelectedIndex(0);
        modelField.setText("");
        engineField.setText("");
        colorField.setText("");
        licensePlateField.setText("");
    }

    private void setFields() {
        String licensePlate = licensePlateField.getText().toUpperCase();
        String color = colorField.getText().toUpperCase();
        String engine = engineField.getText().toUpperCase();
        String model = modelField.getText().toUpperCase();
        String doors = String.valueOf(doorsComboBox.getSelectedItem());
        String type = String.valueOf(typeComboBox.getSelectedItem());
        String make = String.valueOf(makeComboBox.getSelectedItem());

        var fields = List.of(licensePlate, color, engine, model, doors, type, make);

        if (validateEmptyFields(fields)) {
            control = new VehicleController();
            if (!control.existLicensePlate(licensePlate)) {
                control.save(make, type, doors, model, engine, color, licensePlate);
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
                cleanFields();
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

    public void addItems() {
        addItems(makeComboBox, typeComboBox, doorsComboBox);
    }

    static void addItems(JComboBox<VehicleMake> makeComboBox,
                         JComboBox<VehicleType> typeComboBox,
                         JComboBox<Integer> doorsComboBox) {
        makeComboBox.addItem(null);
        typeComboBox.addItem(null);
        doorsComboBox.addItem(null);
        for (VehicleMake value : VehicleMake.values()) {
            makeComboBox.addItem(value);
        }
        for (VehicleType value : VehicleType.values()) {
            typeComboBox.addItem(value);
        }
        for (int i = 2; i < 6; i++) {
            doorsComboBox.addItem(i);
        }
    }
}

