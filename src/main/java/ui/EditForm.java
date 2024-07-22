package ui;

import controller.VehicleController;
import lombok.Getter;
import lombok.Setter;
import model.Vehicle;
import model.VehicleBrand;
import model.VehicleType;
import ui.utility.UIMediator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static ui.utility.EnumComboBox.setupDoorCount;
import static ui.utility.EnumComboBox.setupEnumComboBox;

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
    private JButton actualizarButton;
    private JPanel contentPane;

    UIMediator mediator;
    VehicleController controller;
    @Setter
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
                mediator.setVehicleFields();
            }
        });

       setupEnumComboBox(typeComboBox, VehicleType.class);
       setupEnumComboBox(brandComboBox, VehicleBrand.class);
       setupDoorCount(doorsComboBox);

        // BOTÓN GUARDAR
        actualizarButton.addActionListener(e -> {
            mediator.vehicleUpdate(vehicle);
            mediator.showStockForm();
            mediator.reloadVehicleTable();
            dispose();
        });

        // BOTÓN CANCELAR
        cancelarButton.addActionListener(e -> mediator.setVehicleFields());
    }
}

