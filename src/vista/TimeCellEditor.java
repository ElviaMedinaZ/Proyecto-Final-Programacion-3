package vista;

import java.awt.Component;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class TimeCellEditor extends DefaultCellEditor {
    private JSpinner timeSpinner;
    private SpinnerDateModel spinnerModel;

    public TimeCellEditor() {
        super(new JFormattedTextField());

        Calendar calendar = Calendar.getInstance();
        Date initialTime = calendar.getTime();

        // Configuramos el modelo para manejar minutos
        spinnerModel = new SpinnerDateModel(initialTime, null, null, Calendar.MINUTE);
        timeSpinner = new JSpinner(spinnerModel);

        // Establecemos el formato de visualización
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);

        // Hacemos el editor del JSpinner no editable
        JFormattedTextField tf = ((JSpinner.DefaultEditor) timeSpinner.getEditor()).getTextField();
        tf.setEditable(false);

        timeSpinner.addChangeListener(e -> {
            fireEditingStopped();  // Avisa al editor que la edición ha finalizado
        });

        editorComponent = timeSpinner;
        setClickCountToStart(1);  // Hacer clic una vez para iniciar la edición
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