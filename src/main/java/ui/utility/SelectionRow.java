package ui.utility;

import javax.swing.*;

public class SelectionRow {

    public static Long rowSelection(JTable table) {
        // OBTENER ID DE LA FILA SELECCIONADA
        if (table.getRowCount() > 0) {
            if (table.getSelectedRow() != -1) {
                // OBTENER ID DE LA FILA SELECCIONADA
                return Long.parseLong(table.getValueAt(table.getSelectedRow(), 0).toString());
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
