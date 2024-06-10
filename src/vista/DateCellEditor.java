package vista;

import java.awt.Component;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JDateChooser dateChooser;

    public DateCellEditor() {
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.getDateEditor().setEnabled(false); // Hacer que el campo de texto no sea editable
        dateChooser.getColorModel();
    }

    @Override
    public Object getCellEditorValue() {
        return dateChooser.getDate();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        dateChooser.setDate((Date) value);
        return dateChooser;
    }
}
