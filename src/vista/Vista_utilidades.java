package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        
    public JButton crearBotonesLaterales(String text, String imagen, int width, int height, int fontSize, int iconWidth) {
        JButton btn = new JButton();

        // Configurar el layout del botÛn
        btn.setLayout(new BorderLayout());

        // Cargar la imagen y redimensionarla al tamaÒo deseado
        ImageIcon originalIcon = new ImageIcon(imagen);
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
        btn.add(imageLabel, BorderLayout.WEST);
        btn.add(textLabel, BorderLayout.CENTER);

        // Establecer el tamaÒo preferido del botÛn
        btn.setPreferredSize(new Dimension(width, height));

        return btn;
    }
    
	public JButton crearBotones(String text,String imagen,int width,int heigth,int fontSize, int iconWidth) {
		JButton btn = new JButton(text);
		btn.setForeground(new Color(255, 255, 255));
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		
		ImageIcon icon = new ImageIcon(imagen); 
		Image img = icon.getImage();			
		Image scaledImg = img.getScaledInstance(width-20, heigth-20, Image.SCALE_SMOOTH); //tamaÒos de los botoes para definir el tamaÒo de la imagen
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        
        //se agrega la imagen al boton despues de hacerla a la medida 
        btn.setIcon(scaledIcon);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
        btn.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
        btn.setMargin(new Insets(10, 20, 10, 20)); // Ajusta el margen interno para dar espacio a la imagen
        btn.setFont(new Font(btn.getName(), Font.BOLD, 16)); // Cambia el tamaÒo de fuente a 16 puntos
        //SE le da el efecto de tamaÒo 
        btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setSize(width, heigth);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setSize(width+15, heigth+15);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
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