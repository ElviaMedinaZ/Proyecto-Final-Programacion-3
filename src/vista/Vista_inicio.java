package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;

public class Vista_inicio {

	private JFrame ventana;
	private Vista_utilidades utilidades; 
	
	public Vista_inicio() {
		// TODO Auto-generated constructor stub
		utilidades = new Vista_utilidades();
		ventana = new JFrame();
		ventana.setBounds(10, 10, 1280, 720);
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagenes_acceso/logo App.png"));
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_inicio(String usuario) {
		JPanel Panel_Principal = new JPanel();
		
		Panel_Principal.setBackground(Color.decode("#00758E"));//cambiar de color el panel
			
		ventana.getContentPane().add(Panel_Principal);
		Panel_Principal.setLayout(new BorderLayout(0, 0));//añadimos borderlayout
		
		JPanel panel_lateral = new JPanel();
		panel_lateral.setOpaque(false);
		Panel_Principal.add(panel_lateral, BorderLayout.WEST);//añadimos el panel al oeste
		panel_lateral.setLayout(new GridLayout(0, 1, 20, 10));
		
	    // Crear paneles con GridBagLayout para centrar los botones
		JPanel panel_personal = new JPanel(new GridBagLayout());
		JPanel panel_entretener = new JPanel(new GridBagLayout());
		JPanel panel_aprender = new JPanel(new GridBagLayout());
		JPanel panel_regresar = new JPanel(new GridBagLayout());
		JPanel panel_cerrar_sesion = new JPanel(new GridBagLayout());
		
		panel_personal.setOpaque(false);
		panel_entretener.setOpaque(false);
		panel_aprender.setOpaque(false);
		panel_regresar.setOpaque(false);
		panel_cerrar_sesion.setOpaque(false);
		
		int tamWid = 300;
		int tamHei = 90;
		int iconWidth = (int) (tamHei * 0.7); // Aumentar un 70% el ancho del icono
		int fontSize = 19;
		
		// Crear botones con tamaño preferido
		JButton btnPersonal = utilidades.crearBotonesLaterales("Personal", "/imagenes/img_principal/btn_persona.png", iconWidth, tamHei, fontSize, iconWidth);
		btnPersonal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Controlador_persona persona = new Controlador_persona();
				utilidades.playSound("/sonidos/btn_generico.wav");
				persona.vista_persona(usuario);
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnEntretenimento = utilidades.crearBotonesLaterales("Entretenimiento", "/imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento(usuario);
				ventana.dispose();
				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnAprendizaje =  utilidades.crearBotonesLaterales("Aprendizaje", "/imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje(usuario);
				ventana.dispose();		
			}
		});
		btnAprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnRegresar =  utilidades.crearBotonesLaterales("Regresar", "/imagenes/img_principal/flecha_regresar_gris.png", iconWidth, tamHei, fontSize, iconWidth);
		btnRegresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnRegresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnCerrar_sesion =   utilidades.crearBotonesLaterales("Cerrar sesíon", "/imagenes/img_principal/btn_salir.png", iconWidth, tamHei, fontSize, iconWidth);
		btnCerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_acceso sistema = new Controlador_acceso();
				sistema.vista_acceso();
				ventana.dispose();
			}
		});
		btnCerrar_sesion.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botñn
		
		//paneles para los botones
		panel_lateral.add(panel_personal);
		panel_lateral.add(panel_entretener);
		panel_lateral.add(panel_aprender);
		panel_lateral.add(panel_regresar);
		panel_lateral.add(panel_cerrar_sesion);
		
		// Configurar GridBagConstraints para centrar los botones verticalmente
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 20, 0, 20); // Añadir separacion a los lados
		
		// Añadir los botones a los paneles centrados
		panel_personal.add(btnPersonal, gbc);
		panel_entretener.add(btnEntretenimento, gbc);
		panel_aprender.add(btnAprendizaje, gbc);
		panel_regresar.add(btnRegresar, gbc);
		panel_cerrar_sesion.add(btnCerrar_sesion,gbc);
		
		JPanel logo = new ImganenFondo("/imagenes/img_principal/Imagen fondo.png");
		Panel_Principal.add(logo, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
		
	}
	
	@SuppressWarnings("serial")
	public class ImganenFondo extends JPanel {//mostramos la imagen al fondo del jpanel

		
		private BufferedImage image;

			public ImganenFondo(String imagePath) { // constructor que carga la imagen
            try (InputStream is = getClass().getResourceAsStream(imagePath)) {
                image = ImageIO.read(is);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
			}

		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        if (image != null) {
		            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		        }
		    }

		    @Override
		    public Dimension getPreferredSize() {
		        if (image != null) {
		            return new Dimension(image.getWidth(), image.getHeight());
		        }
		        return super.getPreferredSize();
		    }
		}
}


