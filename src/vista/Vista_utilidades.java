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
import java.io.File;
import java.net.URI;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Vista_utilidades {
	
    public Vista_utilidades() {
    }

    public void limitar_textfield(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final Pattern pattern = Pattern.compile("[a-zA-Z��������������\\s-]*");

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
        
    public JButton crearBotonesLaterales(String text, String imagen, int width, int height, int fontSize, int iconWidth) {
        JButton btn = new JButton();

        // Configurar el layout del bot�n
        btn.setLayout(new BorderLayout());

        // Cargar la imagen y redimensionarla al tama�o deseado
        ImageIcon originalIcon = new ImageIcon(imagen);
        Image originalImage = originalIcon.getImage();

        // Ajustar la imagen a ambas dimensiones del bot�n
        Image scaledImage = originalImage.getScaledInstance(iconWidth, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Crear un JLabel para la imagen y otro para el texto
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel textLabel = new JLabel(text);

        // Centrar el texto vertical y horizontalmente
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setVerticalAlignment(JLabel.CENTER);

        // Establecer el tama�o de la fuente del texto
        textLabel.setFont(textLabel.getFont().deriveFont(Font.BOLD, fontSize));

        // A�adir los componentes al bot�n
        btn.add(imageLabel, BorderLayout.WEST);
        btn.add(textLabel, BorderLayout.CENTER);

        // Establecer el tama�o preferido del bot�n
        btn.setPreferredSize(new Dimension(width, height));

        return btn;
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
		
		
		btn.setForeground(Color.decode("#FFFFFF"));
		btn.setBackground(Color.decode("#90C3D3"));


	    ImageIcon originalIcon = new ImageIcon(imagen);
	    Image originalImage = originalIcon.getImage();

	    // Calcular el factor de escala para ajustar la imagen al tama�o m�ximo sin estirarla
	    double scaleX = (double) iconWidth / originalIcon.getIconWidth();
	    double scaleY = (double) heigth / originalIcon.getIconHeight();
	    double scale = Math.min(scaleX, scaleY);

	    // Redimensionar la imagen al tama�o m�ximo
	    int scaledWidth = (int) (originalIcon.getIconWidth() * scale);
	    int scaledHeight = (int) (originalIcon.getIconHeight() * scale);
	    Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);

	    // Establecer el icono redimensionado en el bot�n
	    btn.setIcon(scaledIcon);
        //se agrega la imagen al boton despues de hacerla a la medida 
        btn.setIcon(scaledIcon);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
        btn.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
        btn.setMargin(new Insets(5, 20, 10, 20)); // Ajusta el margen interno para dar espacio a la imagen
        btn.setFont(new Font(btn.getFont().getName(), Font.BOLD, fontSize));
       

     // Guardar la escala original del bot�n
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	 // Al pasar el mouse sobre el bot�n, aumentar el tama�o de la imagen
                double newWidth = scaledWidth * 1.05;
                double newHeight = scaledHeight * 1.05;
                Image newImage = originalImage.getScaledInstance((int) newWidth, (int) newHeight, Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newImage);
                btn.setIcon(newIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	  // Al salir del bot�n, restaurar el tama�o original de la imagen
                btn.setIcon(scaledIcon);
            }
        });

       
		return btn;
	}
	
	 //este metodo es para el uso de sonidos 
    public void playSound(String soundName)
	 {
	   try 
	   {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	   }
	   catch(Exception ex)
	   {
	     System.out.println("Error with playing sound.");
	     ex.printStackTrace( );
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