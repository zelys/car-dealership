package ui.utility;

import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TableLoaderUtil {

    public static void loadVehicleTable(JTable dataTable, List <Vehicle> vehicles) {
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

        // Configurar la fuente del encabezado
        Font headerFont = new Font("SansSerif", Font.BOLD, 12);
        dataTable.getTableHeader().setFont(headerFont);

        // TRAER REGISTROS DE LA BASE DE DATOS
        if (vehicles != null) {
            for (Vehicle v : vehicles) {
                Object[] row = {
                        v.getId(),
                        v.getBrand(),
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
}
