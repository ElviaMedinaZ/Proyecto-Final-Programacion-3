package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;

public class Vista_matematicas {
	
	public JFrame ventana;
	public JPanel Panel_Principal;
	private Vista_utilidades utilidades;

	public Vista_matematicas() {
		// TODO Auto-generated constructor stub
		utilidades = new Vista_utilidades();
		ventana = new JFrame();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); // Usa toda la pantalla
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_matematicas() {
		
		Panel_Principal = new JPanel();
		
		Panel_Principal.setBackground(Color.decode("#00758E"));
			
		ventana.getContentPane().add(Panel_Principal);
		Panel_Principal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		Panel_Principal.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 20, 10));
			
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
		JButton btnPersonal =utilidades.crearBotonesLaterales("Personal", "imagenes/img_principal/btn_persona.png", iconWidth, tamHei, fontSize, iconWidth);
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona();
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnEntretenimento = utilidades.crearBotonesLaterales("Entretenimiento", "imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento();
				ventana.dispose();				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		 
		JButton btnAprendizaje =utilidades.crearBotonesLaterales("Aprendizaje", "imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje();
				ventana.dispose();
			}
		});
		btnAprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnRegresar =utilidades.crearBotonesLaterales("Regresar", "imagenes/img_principal/flecha_regresar.png", iconWidth, tamHei, fontSize, iconWidth);
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje();
				ventana.dispose();
			}
		});
		btnRegresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnCerrar_sesion = utilidades.crearBotonesLaterales("Cerrar sesíon", "imagenes/img_principal/btn_salir.png", iconWidth, tamHei, fontSize, iconWidth);
		btnCerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_acceso sistema = new Controlador_acceso();
				sistema.vista_acceso();
				ventana.dispose();
			}
		});
		btnCerrar_sesion.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		//paneles para los botones
		panel.add(panel_personal);
		panel.add(panel_entretener);
		panel.add(panel_aprender);
		panel.add(panel_regresar);
		panel.add(panel_cerrar_sesion);
		
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
		
		panel_central();
	}
	
	public void panel_central() {
		
		JPanel vista =  new JPanel();
		vista.setLayout(new BorderLayout(0, 0));
		vista.setBackground(Color.decode("#00758E"));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		vista.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JLabel lbl_espanol = new JLabel("MATEMATICAS");
		lbl_espanol.setForeground(Color.decode("#00172C"));
		lbl_espanol.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_espanol.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lbl_espanol);
		
		JLabel lbl_mensaje = new JLabel("¿Preparado para ejercitar tu mente? ");
		lbl_mensaje.setForeground(Color.decode("#00172C"));
		lbl_mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mensaje.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lbl_mensaje);
		
		JPanel panel_central = new JPanel();
		vista.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(3, 3, 0, 0));
	
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 255, 255));
		JPanel panel_4 = new JPanel();
		JPanel panel_2 = new JPanel();		
		JPanel panel_5 = new JPanel();
		JPanel panel_6 = new JPanel();
		JPanel panel_7 = new JPanel();
		
		//esto se agrega para darle tamaños a los botones 
        int tamWid = 250;
        int tamHei = 160;
		int iconWidth = (int) (tamHei * 0.6); // Aumentar un 60% el ancho del icono
		int fontSize = 19;
		                         //usando el utilidades le pasamos los parametros texto y todo
		JButton btn_calculadora = utilidades.crearBotones("Calculadora", "imagenes/img_aprendizaje/mate/icono calculadora.png", tamWid, tamHei,fontSize,iconWidth);
		btn_calculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
	
			}
		});
		btn_calculadora.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_Multiplicaciones =   utilidades.crearBotones("Multiplicaciones", "imagenes/img_aprendizaje/mate/icono multiplicacion.png", tamWid, tamHei,fontSize,iconWidth);
		btn_Multiplicaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				utilidades.playSound("sonidos/btn_generico.wav");
				utilidades.openWebPage("https://wordwall.net/play/73232/123/411");
			}
		});
		btn_Multiplicaciones.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_Divisiones = utilidades.crearBotones("Divisiones", "imagenes/img_aprendizaje/mate/icono division.png", tamWid, tamHei,fontSize,iconWidth);
		btn_Divisiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				utilidades.playSound("sonidos/btn_generico.wav");
				utilidades.openWebPage("https://wordwall.net/play/73226/392/457");
	
			}
		});
		btn_Divisiones.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_Suma=   utilidades.crearBotones("Suma", "imagenes/img_aprendizaje/mate/icono suma.png", tamWid, tamHei,fontSize,iconWidth);
		btn_Suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				utilidades.playSound("sonidos/btn_generico.wav");
				utilidades.openWebPage("https://wordwall.net/play/73227/723/945");
			}
		});
		btn_Suma.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_Resta = utilidades.crearBotones("Resta", "imagenes/img_aprendizaje/mate/icono resta.png", tamWid, tamHei,fontSize,iconWidth);
		btn_Resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				utilidades.playSound("sonidos/btn_generico.wav");
				utilidades.openWebPage("https://wordwall.net/play/73228/083/672");
			}
		});
		btn_Resta.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_Cuestionario =  utilidades.crearBotones("Cuestionario", "imagenes/img_aprendizaje/mate/icono mix.png", tamWid, tamHei,fontSize,iconWidth);
		btn_Cuestionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				utilidades.playSound("sonidos/btn_generico.wav");
				utilidades.openWebPage("https://wordwall.net/play/63551/643/946");
			}
		});
		btn_Cuestionario.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		
		//ocupamos agregarlos a paneles para que puedan tener su vista y poder trabajar mejor en ellos 
		
		panel_3.add(btn_calculadora);	
		panel_4.add(btn_Multiplicaciones);
		panel_2.add(btn_Divisiones);
		panel_5.add(btn_Suma);
		panel_6.add(btn_Resta);
		panel_7.add(btn_Cuestionario);
		
		panel_central.setOpaque(false);
        panel_2.setOpaque(false);
        panel_3.setOpaque(false);
        panel_4.setOpaque(false);
        panel_5.setOpaque(false);
        panel_6.setOpaque(false);
        panel_7.setOpaque(false);
        

		
        panel_central.add(panel_3);
        panel_central.add(panel_4);
		panel_central.add(panel_2);
		panel_central.add(panel_5);
		panel_central.add(panel_6);
		panel_central.add(panel_7);
		
		vista.setBackground(Color.decode("#F1F1F1"));
		
		Panel_Principal.add(vista, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();

		
	}

}
