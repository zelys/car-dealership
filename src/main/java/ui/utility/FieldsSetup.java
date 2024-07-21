package ui.utility;

import model.Vehicle;
import ui.EditForm;
import ui.RegistrationForm;

public class FieldsSetup {

    public static void setVehicleFields(Vehicle vehicle, EditForm form) {
        form.getLicensePlateField().setText(vehicle.getLicensePlate());
        form.getColorField().setText(vehicle.getColor());
        form.getEngineField().setText(vehicle.getEngine());
        form.getModelField().setText(vehicle.getModel());
        form.getBrandComboBox().setSelectedItem(vehicle.getBrand());
        form.getTypeComboBox().setSelectedItem(vehicle.getType());
        form.getDoorsComboBox().setSelectedItem(vehicle.getDoorCount());
    }

    public static void cleanFields(RegistrationForm form) {
        form.getLicensePlateField().setText("");
        form.getColorField().setText("");
        form.getEngineField().setText("");
        form.getModelField().setText("");
        form.getBrandComboBox().setSelectedItem(null);
        form.getTypeComboBox().setSelectedItem(null);
        form.getDoorsComboBox().setSelectedItem(null);
    }
}