package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Vista_utilidades {
	
	private Clip sonido_actual;
	
    public Vista_utilidades() {
    }

    public void limitar_textfield(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final Pattern pattern = Pattern.compile("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—¸‹\\s-]*");

            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text == null) return;

                String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (pattern.matcher(newValue).matches() && newValue.length() <= maxLength) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;

                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newValue = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                if (pattern.matcher(newValue).matches() && newValue.length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    
    public void limitTextFieldLength(JTextField textField, int maxLength) {
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
        
    public static void limitar_numeros(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final Pattern pattern = Pattern.compile("\\d*"); // ExpresiÛn regular que solo acepta dÌgitos

            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text == null) return;

                String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (pattern.matcher(newValue).matches() && newValue.length() <= maxLength) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;

                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newValue = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                if (pattern.matcher(newValue).matches() && newValue.length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    
    public JButton crearBotonesLaterales(String text, String imagen, int width, int height, int fontSize, int iconWidth) {
        JButton btn1 = new JButton();
        // Configurar el layout del botÛn
        btn1.setLayout(new BorderLayout());

        // Cargar la imagen y redimensionarla al tamaÒo deseado
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagen));
        Image originalImage = originalIcon.getImage();

        // Ajustar la imagen a ambas dimensiones del botÛn
        Image scaledImage = originalImage.getScaledInstance(iconWidth, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Crear un JLabel para la imagen y otro para el texto
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel textLabel = new JLabel(text);

        // Centrar el texto vertical y horizontalmente
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setVerticalAlignment(JLabel.CENTER);

        // Establecer el tamaÒo de la fuente del texto
        textLabel.setFont(textLabel.getFont().deriveFont(Font.BOLD, fontSize));

        // AÒadir los componentes al botÛn
        btn1.add(imageLabel, BorderLayout.WEST);
        btn1.add(textLabel, BorderLayout.CENTER);

        // Establecer el tamaÒo preferido del botÛn
        btn1.setPreferredSize(new Dimension(width, height));

        return btn1;
    }
    
	public JButton crearBotones(String text,String imagen,int width,int heigth,int fontSize, int iconWidth) {
		
	
		 
		@SuppressWarnings("serial")
		JButton btn = new JButton() {
			 
			 
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Graphics2D g2d = (Graphics2D) g.create();

	                // Apply anti-aliasing for better text quality
	                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	                // Draw text outline
	                FontMetrics fm = g2d.getFontMetrics();
	                int textWidth = fm.stringWidth(text);

	                int x = (getWidth() - textWidth) / 2;
	                int y = getHeight() - fm.getDescent() - 5;

	                // Draw outline text
	                g2d.setColor(Color.BLACK);
	                g2d.setFont(getFont());
	                g2d.drawString(text, x - 1, y - 1);
	                g2d.drawString(text, x - 1, y + 1);
	                g2d.drawString(text, x + 1, y - 1);
	                g2d.drawString(text, x + 1, y + 1);
	                // Draw foreground text
	                g2d.setColor(getForeground());
	                g2d.drawString(text, x, y);

	                g2d.dispose();
	            }
	        };
		
	        aplicarEstiloBase(btn, fontSize);



	    ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagen));
	    Image originalImage = originalIcon.getImage();

	    // Calcular el factor de escala para ajustar la imagen al tamaÒo m·ximo sin estirarla
	    double scaleX = (double) iconWidth / originalIcon.getIconWidth();
	    double scaleY = (double) heigth / originalIcon.getIconHeight();
	    double scale = Math.min(scaleX, scaleY);

	    // Redimensionar la imagen al tamaÒo m·ximo
	    int scaledWidth = (int) (originalIcon.getIconWidth() * scale);
	    int scaledHeight = (int) (originalIcon.getIconHeight() * scale);
	    Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);

	    // Establecer el icono redimensionado en el botÛn
	    btn.setIcon(scaledIcon);
        //se agrega la imagen al boton despues de hacerla a la medida 
        btn.setIcon(scaledIcon);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
        btn.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
        btn.setMargin(new Insets(5, 20, 10, 20)); // Ajusta el margen interno para dar espacio a la imagen
        btn.setFont(new Font(btn.getFont().getName(), Font.BOLD, fontSize));
       

     // Guardar la escala original del botÛn
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	 // Al pasar el mouse sobre el botÛn, aumentar el tamaÒo de la imagen
                double newWidth = scaledWidth * 1.05;
                double newHeight = scaledHeight * 1.05;
                Image newImage = originalImage.getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newImage);
                btn.setIcon(newIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	  // Al salir del botÛn, restaurar el tamaÒo original de la imagen
                btn.setIcon(scaledIcon);
            }
        });

       
		return btn;
	}
	

    
    
	private void aplicarEstiloBase(JButton btn, int fontSize) {
		
		
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.decode("#90C3D3"));
		btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btn.setFont(new Font("Arial", Font.BOLD, fontSize));
		
	}

	public void playSound(String soundFile) {
        try {
            if (sonido_actual != null && sonido_actual.isRunning()) {
                sonido_actual.stop();
                sonido_actual.close();
            }

            // Configuracion del nuevo sonido
            try (InputStream audioSrc = getClass().getResourceAsStream(soundFile);
                 InputStream bufferedIn = new BufferedInputStream(audioSrc);
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn)) {

                sonido_actual = AudioSystem.getClip();
                sonido_actual.open(audioInputStream);
                sonido_actual.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
	
    //este metodo es para poder abrir direcciones url
	public void openWebPage(String url) {
		try {
	        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	            desktop.browse(new URI(url));
	        }
	        throw new NullPointerException();
	    } catch (Exception e) {
	       
	    }

	}

}

@SuppressWarnings("serial")
class EditableTableModel extends DefaultTableModel {
    private boolean editable = false;  // Controla si las celdas son editables.

    public EditableTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;  // Devuelve el estado actual de la capacidad de ediciÛn.
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}