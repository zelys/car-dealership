package ui;

import controller.VehicleController;
import lombok.Getter;
import model.Vehicle;
import ui.utility.SelectionRow;
import ui.utility.UIMediator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class StockForm extends JFrame {
    private JPanel contentPane;
    @Getter
    private JTable dataTable;
    private JButton editarButton;
    private JButton eliminarButton;

    UIMediator mediator;
    VehicleController controller;

    public StockForm(UIMediator mediator, VehicleController controller) {
        this.mediator = mediator;
        this.controller = controller;
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                mediator.reloadVehicleTable();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediator.showMainForm();
            }
        });

        // BOTÓN EDITAR
        editarButton.addActionListener(e -> {
            Long id = SelectionRow.rowSelection(dataTable);
            if (id != null) {
                Vehicle selectedVehicle = controller.getVehicle(id);
                mediator.setSelectedVehicle(selectedVehicle);
                mediator.showEditForm();
                mediator.setVehicleFields();
            }
        });

        // BOTÓN BORRAR
        eliminarButton.addActionListener(e -> {
            Long id = SelectionRow.rowSelection(dataTable);
            if (id != null) {
                controller.deleteVehicle(id);
                mediator.messages("Vehiculo eliminado exitosamente!", contentPane);
                mediator.reloadVehicleTable();
            }
        });
    }
}
