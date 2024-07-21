package ui.utility;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class EnumComboBox {

    public static <T extends Enum<T>> void setupEnumComboBox(JComboBox<T> comboBox, Class<T> enumClass) {
        comboBox.removeAllItems();
        // Añadir un elemento vacío como primer item
        comboBox.addItem(null);
        // Añadir todos los valores del enum
        for (T enumValue : enumClass.getEnumConstants()) {
            comboBox.addItem(enumValue);
        }
        setEmptyStringRenderer(comboBox);
    }

    public static void setupDoorCount(JComboBox<Integer> comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem(null);
        for (int i = 2; i < 6; i++) {
            comboBox.addItem(i);
        }
        setEmptyStringRenderer(comboBox);
    }

    // Configurar el renderizador con string vacío para el primer item
    private static <E> void setEmptyStringRenderer(JComboBox<E> comboBox) {
        comboBox.setRenderer(new BasicComboBoxRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value == null) {
                    setText("");
                }
                return this;
            }
        });
    }
}