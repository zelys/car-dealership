package ui.utility;

import model.Vehicle;

import javax.swing.*;

public interface UIMediator {
    void showMainForm();
    void showRegistrationForm();
    void showStockForm();
    void showEditForm();
    void closeApplication();
    void setSelectedVehicle(Vehicle vehicle);
    void reloadVehicleTable();
    void setVehicleFields();
    void cleanFields();
    void createNewVehicle();
    void vehicleUpdate(Vehicle vehicle);
    void messages(String message, JPanel location);
}