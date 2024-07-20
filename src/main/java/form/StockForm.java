package form;

import controller.VehicleController;
import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class StockForm extends JFrame {
    private JPanel contentPane;
    private JTable dataTable;
    private JButton editarButton;
    private JButton eliminarButton;

    private MainForm mainForm;
    private EditForm editForm;
    private VehicleController controller;

    public StockForm() {
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadTable();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainForm = new MainForm();
                // POSICIÓN de MainForm AL CERRAR VENTANA
                mainForm.setLocationRelativeTo(contentPane);
                mainForm.setVisible(true);
            }
        });

        // BOTÓN EDITAR
        editarButton.addActionListener(e -> {
            if (actionsButtons() != null) {
                // CARGAR DATOS EN EL FORMULARIO Y HACER VISIBLE
                editForm = new EditForm(actionsButtons());
                editForm.setLocationRelativeTo(contentPane);
                editForm.setVisible(true);
                // CERRAR VENTANA DataForm
                dispose();
            }
        });

        // BOTÓN BORRAR
        eliminarButton.addActionListener(e -> {
            if (actionsButtons() != null) {
                controller = new VehicleController();
                controller.deleteVehicleById(actionsButtons());
                JOptionPane.showMessageDialog(contentPane, "Vehiculo eliminado exitosamente!");
            }
            loadTable();
        });

    }

     private void loadTable() {
         DefaultTableModel tableModel = new DefaultTableModel() {
             @Override
             public boolean isCellEditable(int row, int column) {
                 return false;
             }
         };
         // NOMBRES PARA LA CABECERA DE LA TABLA
         String[] tableHeader = {"ID", "MARCA", "MODELO", "MOTOR", "TIPO", "COLOR", "PATENTE", "PUERTAS", "FECHA ALTA", "ACTUALIZACIÓN"};
         // ESTABLECER LOS NOMBRES DE LA CABECERA
         tableModel.setColumnIdentifiers(tableHeader);
         Font headerFont = new Font("SansSerif", Font.BOLD, 14);
         dataTable.getTableHeader().setFont(headerFont);
         // TRAER REGISTROS DE LA BASE DE DATOS
         this.controller = new VehicleController();
         List<Vehicle> listing = controller.findAllVehicle();
         if (listing != null) {
             for (Vehicle v : listing) {
                 Object[] row = {
                         v.getId(),
                         v.getMake(),
                         v.getModel(),
                         v.getEngine(),
                         v.getType(),
                         v.getColor(),
                         v.getLicensePlate(),
                         v.getDoorCount(),
                         v.getCreated(),
                         v.getModified()
                 };
                 tableModel.addRow(row);
             }
         }
         dataTable.setModel(tableModel);
     }

     private Long actionsButtons() {
         // OBTENER ID DE LA FILA SELECCIONADA
         if(dataTable.getRowCount() > 0) {
             if(dataTable.getSelectedRow() != -1) {
                 // OBTENER ID DE LA FILA SELECCIONADA
                 return Long.parseLong(dataTable.getModel()
                         .getValueAt(dataTable.getSelectedRow(), 0).toString());
             } else {
                 JOptionPane.showMessageDialog(null, "Debe seleccionar un registro",
                         "Error", JOptionPane.ERROR_MESSAGE);
                 return null;
             }
         }
         JOptionPane.showMessageDialog(null, "No hay registros en la tabla",
                 "Alert", JOptionPane.ERROR_MESSAGE);
         return null;
     }
}
