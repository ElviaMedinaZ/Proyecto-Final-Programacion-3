package vista;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.sql.Time;

@SuppressWarnings("serial")
public class TimeCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JSpinner timeSpinner;
    private SpinnerDateModel spinnerModel;

    public TimeCellEditor() {
        Calendar calendar = Calendar.getInstance();
        Date initialTime = calendar.getTime();

        // Configuramos el modelo para manejar minutos
        spinnerModel = new SpinnerDateModel(initialTime, null, null, Calendar.MINUTE);
        timeSpinner = new JSpinner(spinnerModel);

        // Establecemos el formato de visualización
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);

        timeSpinner.addChangeListener(e -> {
            fireEditingStopped();  // Avisa al editor que la edición ha finalizado
        });
    }

    @Override
    public Object getCellEditorValue() {
        return new Time(spinnerModel.getDate().getTime());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Time) {
            spinnerModel.setValue(new Date(((Time) value).getTime()));
        }
        return timeSpinner;
    }
}
