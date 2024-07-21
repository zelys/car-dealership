package ui.utility;

import controller.VehicleController;
import model.Vehicle;
import ui.EditForm;
import ui.MainForm;
import ui.RegistrationForm;
import ui.StockForm;

public class AppUIMediator implements UIMediator {
    private MainForm mainForm;
    private RegistrationForm registrationForm;
    private StockForm stockForm;
    private EditForm editForm;
    private Vehicle vehicle;
    VehicleController vehicleController;

    public AppUIMediator(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    @Override
    public void showMainForm() {
        if (mainForm == null) {
            mainForm = new MainForm(this);
        }
        mainForm.setVisible(true);
        mainForm.setLocationRelativeTo(null);

        if (registrationForm != null) {
            mainForm.setLocationRelativeTo(registrationForm);
            registrationForm.dispose();
        }
        if (stockForm != null) {
            mainForm.setLocationRelativeTo(stockForm);
            stockForm.dispose();
        }
    }

    @Override
    public void showRegistrationForm() {
        if (registrationForm == null) {
            registrationForm = new RegistrationForm(this, vehicleController);
        }
        registrationForm.setLocationRelativeTo(mainForm);
        registrationForm.setVisible(true);
        mainForm.dispose();
    }

    @Override
    public void showStockForm() {
        if (stockForm == null) {
            stockForm = new StockForm(this, vehicleController);
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
            editForm = new EditForm(this, vehicleController);
        }
        editForm.setLocationRelativeTo(stockForm);
        editForm.setVisible(true);
        stockForm.dispose();
    }

    @Override
    public void closeApplication() {
        System.exit(0);
    }
}
