package ui;

import controller.VehicleController;
import ui.utility.SelectionRowUtil;
import ui.utility.TableLoaderUtil;
import ui.utility.UIMediator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StockForm extends JFrame {
    private JPanel contentPane;
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
                TableLoaderUtil.loadVehicleTable(dataTable, controller.getAllVehicles());
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
            Long id = SelectionRowUtil.rowSelection(dataTable);
            if (id != null) {
                mediator.showEditForm();
            }
        });

        // BOTÓN BORRAR
        eliminarButton.addActionListener(e -> {
            Long id = SelectionRowUtil.rowSelection(dataTable);
            if (id != null) {
                controller.deleteVehicle(id);
                JOptionPane.showMessageDialog(contentPane, "Vehiculo eliminado exitosamente!");
                TableLoaderUtil.loadVehicleTable(dataTable, controller.getAllVehicles());
            }
        });
    }
}
