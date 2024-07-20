package form;

import controller.VehicleController;
import model.Vehicle;
import model.VehicleMake;
import model.VehicleType;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class EditForm extends JFrame {
    private JTextField licensePlateField;
    private JTextField colorField;
    private JTextField engineField;
    private JTextField modelField;
    private JComboBox<Integer> doorsComboBox;
    private JComboBox<VehicleType> typeComboBox;
    private JComboBox<VehicleMake> makeComboBox;
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel contentPane;

    private VehicleController controller;
    private Vehicle vehicle;

    public EditForm(Long id) {
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadData(id);
            }
        });

        // HACER VISIBLE StockForm CUANDO SE CIERRA LA VENTANA
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stockFormWindows();
            }
        });

        addItemsToComboBox();

        // BOTÓN GUARDAR
        guardarButton.addActionListener(e -> {
            String licensePlate = licensePlateField.getText().toUpperCase();
            String color = colorField.getText().toUpperCase();
            String engine = engineField.getText().toUpperCase();
            String model = modelField.getText().toUpperCase();
            String doors = String.valueOf(doorsComboBox.getSelectedItem());
            String type = String.valueOf(typeComboBox.getSelectedItem());
            String make = String.valueOf(makeComboBox.getSelectedItem());

            var fields = List.of(licensePlate, color, engine, model, doors, type, make);
            if (RegistrationForm.validateEmptyFields(fields)) {
                controller.updateVehicle(vehicle, make, type, doors, model, engine, color, licensePlate);
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
                dispose();
                stockFormWindows();
            }
        });
        cancelarButton.addActionListener(e -> loadData(id));
    }

    // CARGAR DATOS AL FORMULARIO
    private void loadData(Long id) {
        this.controller = new VehicleController();
        this.vehicle = controller.findVehicleById(id);
        licensePlateField.setText(vehicle.getLicensePlate());
        colorField.setText(vehicle.getColor());
        engineField.setText(vehicle.getEngine());
        modelField.setText(vehicle.getModel());
        makeComboBox.setSelectedItem(vehicle.getMake());
        typeComboBox.setSelectedItem(vehicle.getType());
        doorsComboBox.setSelectedItem(vehicle.getDoorCount());
    }

    public void addItemsToComboBox() {
        RegistrationForm.addItems(makeComboBox, typeComboBox, doorsComboBox);
    }

    private void stockFormWindows() {
        StockForm stockForm = new StockForm();
        // POSICIÓN de StockForm AL CERRAR VENTANA
        stockForm.setLocationRelativeTo(contentPane);
        stockForm.setVisible(true);
    }
}

