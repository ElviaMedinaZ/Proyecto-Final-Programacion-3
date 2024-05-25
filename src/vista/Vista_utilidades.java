package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;


public class Vista_utilidades {
	
	
	public Vista_utilidades () {
		
	}
	
	 public void applyLettersOnlyFilter(JTextField textField) {
	        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
	            private final Pattern pattern = Pattern.compile("[a-zA-Z]*");

	            @Override
	            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
	                if (text == null) return;

	                String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	                if (pattern.matcher(newValue).matches()) {
	                    super.insertString(fb, offset, text, attr);
	                }
	            }

	            @Override
	            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	                if (text == null) return;

	                String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	                if (pattern.matcher(newValue).matches()) {
	                    super.replace(fb, offset, length, text, attrs);
	                }
	            }
	        });
	    }
	 
	    public static void limitTextFieldLength(JTextField textField, int maxLength) {
	        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
	            @Override
	            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
	                int futureLength = currentText.length() + text.length() - length;
	                if (futureLength <= maxLength) {
	                    super.replace(fb, offset, length, text, attrs);
	                }
	            }
	        });
	    }

	    public JButton crearBotonesLaterales(String text, String imagen, int width, int height, int fontSize, int iconWidth) {
	        JButton btn = new JButton();

	        // Configurar el layout del botón
	        btn.setLayout(new BorderLayout());

	        // Cargar la imagen y redimensionarla al tamaño deseado
	        ImageIcon originalIcon = new ImageIcon(imagen);
	        Image originalImage = originalIcon.getImage();
	        
	        // Ajustar la imagen a ambas dimensiones del botón
	        Image scaledImage = originalImage.getScaledInstance(iconWidth, height, Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);

	        // Crear un JLabel para la imagen y otro para el texto
	        JLabel imageLabel = new JLabel(scaledIcon);
	        JLabel textLabel = new JLabel(text);

	        // Centrar el texto vertical y horizontalmente
	        textLabel.setHorizontalAlignment(JLabel.CENTER);
	        textLabel.setVerticalAlignment(JLabel.CENTER);

	        // Establecer el tamaño de la fuente del texto
	        textLabel.setFont(textLabel.getFont().deriveFont(Font.BOLD, fontSize));

	        // Añadir los componentes al botón
	        btn.add(imageLabel, BorderLayout.WEST);
	        btn.add(textLabel, BorderLayout.CENTER);

	        // Establecer el tamaño preferido del botón
	        btn.setPreferredSize(new Dimension(width, height));

	        return btn;
	    }


}
