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
import controlador.Controlador_inicio;
import controlador.Controlador_persona;

public class Vista_persona {
	
	private  JFrame ventana;
	private JPanel Panel_Principal;
	private Controlador_persona sistema;
	private Vista_utilidades utilidades;

	public Vista_persona() {
		// TODO Auto-generated constructor stub
		utilidades = new Vista_utilidades();
		sistema = new Controlador_persona();
        ventana = new JFrame();
        ventana.setBounds(10, 10, 1280, 720);
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_persona() {
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
		JButton btnPersonal = utilidades.crearBotonesLaterales("Personal", "imagenes/img_principal/btn_persona.png", iconWidth, tamHei, fontSize, iconWidth);
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnEntretenimento =  utilidades.crearBotonesLaterales("Entretenimiento", "imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);;
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento();
				ventana.dispose();
				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btn_aprendizaje =  utilidades.crearBotonesLaterales("Aprendizaje", "imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btn_aprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje();
				ventana.dispose();
			}
		});
		btn_aprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btn_regresar = utilidades.crearBotonesLaterales("Regresar", "imagenes/img_principal/flecha_regresar.png", iconWidth, tamHei, fontSize, iconWidth);
		btn_regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_inicio  sistema = new Controlador_inicio();
				sistema.vista_inicio();
				ventana.dispose();
		
			}
		});
		btn_regresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btn_cerrar_sesion =  utilidades.crearBotonesLaterales("Cerrar sesíon", "imagenes/img_principal/btn_salir.png", iconWidth, tamHei, fontSize, iconWidth);
		btn_cerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_acceso sistema = new Controlador_acceso();
				sistema.vista_acceso();
				ventana.dispose();
		
			}
		});
		btn_cerrar_sesion.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
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
		panel_aprender.add(btn_aprendizaje, gbc);
		panel_regresar.add(btn_regresar, gbc);
		panel_cerrar_sesion.add(btn_cerrar_sesion,gbc);
		
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
		
		
		JLabel lblNewLabel = new JLabel("PERSONAL");
		lblNewLabel.setForeground(Color.decode("#00172C"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Coloca el cursor sobre la actividad a realizar.");
		lblNewLabel_1.setForeground(Color.decode("#00172C"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		vista.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
	
		
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
		JButton btn_necesidades = utilidades.crearBotones("Necesidades", "imagenes/img_necesidades/necesidades/icono necesidades.png", tamWid, tamHei,fontSize,iconWidth);
		btn_necesidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				sistema.vista_necesidades();
				ventana.dispose();
			}
		});
		btn_necesidades.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_agenda =   utilidades.crearBotones("Agenda", "imagenes/img_necesidades/icono agenda.png", tamWid, tamHei,fontSize,iconWidth);
		btn_agenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				sistema.vista_agenda();
				ventana.dispose();
			}
		});
		btn_agenda.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_certificado=   utilidades.crearBotones("Certificado", "imagenes/img_necesidades/icono certificado.png", tamWid, tamHei,fontSize,iconWidth);
		btn_certificado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				sistema.vista_certificado();
				ventana.dispose();
			}
		});
		btn_certificado.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_contactos=   utilidades.crearBotones("Contactos", "imagenes/img_necesidades/icono contacto.png", tamWid, tamHei,fontSize,iconWidth);
		btn_contactos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				sistema.vista_contactos();
				ventana.dispose();
			}
		});
		btn_contactos.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_editar =   utilidades.crearBotones("Editar perfil", "imagenes/img_necesidades/editar.png", tamWid, tamHei,fontSize,iconWidth);
		btn_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				sistema.vista_editar();
				ventana.dispose();
			}
		});
		btn_editar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		JButton btn_dispositivos =  utilidades.crearBotones("Dispositivos", "imagenes/img_necesidades/dispositivos/icono dispositivos.png", tamWid, tamHei,fontSize,iconWidth);
		btn_dispositivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				sistema.vista_dispositivos();
				ventana.dispose();
			}
		});
		btn_dispositivos.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del botón
		
		
		//ocupamos agregarlos a paneles para que puedan tener su vista y poder trabajar mejor en ellos 
		
		panel_3.add(btn_necesidades);	
		panel_4.add(btn_agenda);
		panel_2.add(btn_certificado);
		panel_5.add(btn_contactos);
		panel_6.add(btn_editar);
		panel_7.add(btn_dispositivos);
		
        panel_1.setOpaque(false);
        panel_2.setOpaque(false);
        panel_3.setOpaque(false);
        panel_4.setOpaque(false);
        panel_5.setOpaque(false);
        panel_6.setOpaque(false);
        panel_7.setOpaque(false);
        

		
		panel_1.add(panel_3);
		panel_1.add(panel_4);
		panel_1.add(panel_2);
		panel_1.add(panel_5);
		panel_1.add(panel_6);
		panel_1.add(panel_7);
		
		vista.setBackground(Color.decode("#F1F1F1"));
		
		Panel_Principal.add(vista, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
		
	}

}
