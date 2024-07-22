package ui.utility;

import controller.VehicleController;
import model.Vehicle;
import model.VehicleBrand;
import model.VehicleType;
import ui.EditForm;
import ui.MainForm;
import ui.RegistrationForm;
import ui.StockForm;

import javax.swing.*;

import java.time.LocalDate;

import static ui.utility.TableLoader.loadVehicleTable;

public class AppUIMediator implements UIMediator {
    private MainForm mainForm;
    private RegistrationForm regForm;
    private StockForm stockForm;
    private EditForm editForm;
    private Vehicle selectedVehicle;
    private final VehicleController controller;

    public AppUIMediator(VehicleController vehicleController) {
        this.controller = vehicleController;
    }

    @Override
    public void showMainForm() {
        if (mainForm == null) {
            mainForm = new MainForm(this);
        }
        mainForm.setVisible(true);
        mainForm.setLocationRelativeTo(null);

        if (regForm != null) {
            mainForm.setLocationRelativeTo(regForm);
            regForm.dispose();
        }
        if (stockForm != null) {
            mainForm.setLocationRelativeTo(stockForm);
            stockForm.dispose();
        }
    }

    @Override
    public void showRegistrationForm() {
        if (regForm == null) {
            regForm = new RegistrationForm(this, controller);
        }
        regForm.setLocationRelativeTo(mainForm);
        regForm.setVisible(true);
        mainForm.dispose();
    }

    @Override
    public void showStockForm() {
        if (stockForm == null) {
            stockForm = new StockForm(this, controller);
        }
        stockForm.setLocationRelativeTo(mainForm);
        stockForm.setVisible(true);
        mainForm.dispose();

        if (editForm != null) {
            stockForm.setLocationRelativeTo(editForm);
            editForm.dispose();
        }
    }

    @Override
    public void showEditForm() {
        if (editForm == null) {
            editForm = new EditForm(this, controller);
        }
        editForm.setVehicle(selectedVehicle);
        editForm.setLocationRelativeTo(stockForm);
        editForm.setVisible(true);
        stockForm.dispose();
    }

    @Override
    public void closeApplication() {
        System.exit(0);
    }

    @Override
    public void setSelectedVehicle(Vehicle vehicle) {
        this.selectedVehicle = vehicle;
    }

    @Override
    public void reloadVehicleTable() {
        loadVehicleTable(stockForm.getDataTable(), controller.getAllVehicles());
    }

    @Override
    public void setVehicleFields() {
        editForm.getLicensePlateField().setText(selectedVehicle.getLicensePlate());
        editForm.getColorField().setText(selectedVehicle.getColor());
        editForm.getEngineField().setText(selectedVehicle.getEngine());
        editForm.getModelField().setText(selectedVehicle.getModel());
        editForm.getBrandComboBox().setSelectedItem(selectedVehicle.getBrand());
        editForm.getTypeComboBox().setSelectedItem(selectedVehicle.getType());
        editForm.getDoorsComboBox().setSelectedItem(selectedVehicle.getDoorCount());
    }

    @Override
    public void cleanFields() {
        regForm.getLicensePlateField().setText("");
        regForm.getColorField().setText("");
        regForm.getEngineField().setText("");
        regForm.getModelField().setText("");
        regForm.getBrandComboBox().setSelectedItem(null);
        regForm.getTypeComboBox().setSelectedItem(null);
        regForm.getDoorsComboBox().setSelectedItem(null);
    }

    @Override
    public void createNewVehicle() throws NullPointerException {
        try {
            Vehicle vehicle = new Vehicle();
            buildVehicle(vehicle,
                    regForm.getBrandComboBox(),
                    regForm.getTypeComboBox(),
                    regForm.getDoorsComboBox(),
                    regForm.getModelField(),
                    regForm.getEngineField(),
                    regForm.getColorField(),
                    regForm.getLicensePlateField());
            boolean plateExists = controller.hasPlatesDuplicated(getStringFields(regForm.getLicensePlateField()));
            if (!plateExists) {
                controller.createVehicle(vehicle);
                messages("Se ha registrado un nuevo vehiculo", regForm.getContentPane());
            } else {
                messages("La placa patente ingresada, ya existe en el sistema", regForm.getContentPane());
            }
        } catch (NullPointerException e) {
            System.out.println("No puede haber campos vacíos");
        }
    }

    @Override
    public void vehicleUpdate(Vehicle vehicle) {
        if (vehicle != null) {
            buildVehicle(vehicle,
                    editForm.getBrandComboBox(),
                    editForm.getTypeComboBox(),
                    editForm.getDoorsComboBox(),
                    editForm.getModelField(),
                    editForm.getEngineField(),
                    editForm.getColorField(),
                    editForm.getLicensePlateField());
            vehicle.setModified(LocalDate.now());
            controller.updateVehicle(vehicle);
            messages("Vehiculo modificado exitosamente", editForm.getContentPane());
        } else {
            messages("Error al actualizar el vehiculo", editForm.getContentPane());
        }
    }

    private void buildVehicle(Vehicle vehicle,
                              JComboBox<VehicleBrand> brandComboBox,
                              JComboBox<VehicleType> typeComboBox,
                              JComboBox<Integer> doorsComboBox,
                              JTextField modelField,
                              JTextField engineField,
                              JTextField colorField,
                              JTextField licensePlateField) {
        vehicle.setBrand(getStringComboBox(brandComboBox));
        vehicle.setType(getStringComboBox(typeComboBox));
        vehicle.setDoorCount(getStringComboBox(doorsComboBox));
        vehicle.setModel(getStringFields(modelField));
        vehicle.setEngine(getStringFields(engineField));
        vehicle.setColor(getStringFields(colorField));
        vehicle.setLicensePlate(getStringFields(licensePlateField));
    }

    @Override
    public void messages(String message, JPanel location) {
        JOptionPane.showMessageDialog(location, message, "", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getStringFields(JTextField field) {
        if (field.getText() != null || !field.getText().isEmpty()) {
            return field.getText().toUpperCase();
        } else {
            messages("No puede haber campos vacíos", regForm.getContentPane());
        }
        return "";
    }

    public <T> String getStringComboBox(JComboBox<T> comboBox) {
        if (comboBox.getSelectedItem() != null) {
            return String.valueOf(comboBox.getSelectedItem());
        } else {
            messages("No puede haber campos vacíos", regForm.getContentPane());
        }
        return null;
    }
}
