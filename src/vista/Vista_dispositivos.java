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

import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;

public class Vista_dispositivos {
	
	public JFrame ventana;
	public JPanel Panel_Principal;
	private Vista_utilidades utilidades;

	public Vista_dispositivos() {
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
	
	public void vista_dispositivos(String usuario) {
		
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
		
		// Crear botones con tama�o preferido
		JButton btnPersonal =utilidades.crearBotonesLaterales("Personal", "/imagenes/img_principal/btn_persona.png", iconWidth, tamHei, fontSize, iconWidth);
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona(usuario);
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnEntretenimento = utilidades.crearBotonesLaterales("Entretenimiento", "/imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento(usuario);
				ventana.dispose();				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		 
		JButton btnAprendizaje =utilidades.crearBotonesLaterales("Aprendizaje", "/imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje(usuario);
				ventana.dispose();
			}
		});
		btnAprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnRegresar =utilidades.crearBotonesLaterales("Regresar", "/imagenes/img_principal/flecha_regresar.png", iconWidth, tamHei, fontSize, iconWidth);
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona(usuario);
				ventana.dispose();
			}
		});
		btnRegresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnCerrar_sesion = utilidades.crearBotonesLaterales("Cerrar seson", "/imagenes/img_principal/btn_salir.png", iconWidth, tamHei, fontSize, iconWidth);
		btnCerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_acceso sistema = new Controlador_acceso();
				sistema.vista_acceso();
				ventana.dispose();
			}
		});
		btnCerrar_sesion.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
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
		gbc.insets = new Insets(0, 20, 0, 20); // A�adir separacion a los lados
		
		// A�adir los botones a los paneles centrados
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
		
		
		JLabel lbl_dispositivos = new JLabel("DISPOSITIVOS");
		lbl_dispositivos.setForeground(Color.decode("#00172C"));
		lbl_dispositivos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dispositivos.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lbl_dispositivos);
		
		JLabel lbl_mensaje = new JLabel("Da clic sobre el dispositivo que deseas encender.");
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
		
		//esto se agrega para darle tama�os a los botones 
        int tamWid = 250;
        int tamHei = 160;
		int iconWidth = (int) (tamHei * 0.6); // Aumentar un 60% el ancho del icono
		int fontSize = 19;
		                         //usando el utilidades le pasamos los parametros texto y todo
		JButton btn_asistente = utilidades.crearBotones("Asistente", "/imagenes/img_necesidades/dispositivos/asistente.png", tamWid, tamHei,fontSize,iconWidth);
		btn_asistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
	
			}
		});
		btn_asistente.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del bot�n
		
		JButton btn_foco =   utilidades.crearBotones("Foco", "/imagenes/img_necesidades/dispositivos/foco.png", tamWid, tamHei,fontSize,iconWidth);
		btn_foco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");

			}
		});
		btn_foco.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del bot�n
		
		JButton btn_enchufe = utilidades.crearBotones("Enchufe", "/imagenes/img_necesidades/dispositivos/conector.png", tamWid, tamHei,fontSize,iconWidth);
		btn_enchufe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
	
			}
		});
		btn_enchufe.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del bot�n
		
		JButton btn_tv=   utilidades.crearBotones("Televisi�n", "/imagenes/img_necesidades/dispositivos/tv.png", tamWid, tamHei,fontSize,iconWidth);
		btn_tv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
		
			}
		});
		btn_tv.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del bot�n
		
		JButton btn_aspiradora = utilidades.crearBotones("Aspiradora", "/imagenes/img_necesidades/dispositivos/aspiradora.png", tamWid, tamHei,fontSize,iconWidth);
		btn_aspiradora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");

			}
		});
		btn_aspiradora.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del bot�n
		
		JButton btn_termostato =  utilidades.crearBotones("Termostato", "/imagenes/img_necesidades/dispositivos/termostato.png", tamWid, tamHei,fontSize,iconWidth);
		btn_termostato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
	
			}
		});
		btn_termostato.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del bot�n
		
		
		//ocupamos agregarlos a paneles para que puedan tener su vista y poder trabajar mejor en ellos 
		
		panel_3.add(btn_asistente);	
		panel_4.add(btn_foco);
		panel_2.add(btn_enchufe);
		panel_5.add(btn_tv);
		panel_6.add(btn_aspiradora);
		panel_7.add(btn_termostato);
		
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