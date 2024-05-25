package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;

public class Vista_dispositivos {
	
	public JFrame ventana;
	public JPanel Panel_Principal;

	public Vista_dispositivos() {
		// TODO Auto-generated constructor stub
		ventana = new JFrame();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); // Usa toda la pantalla
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_dispositivos() {
		
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
		
		int tamWid = 400;
		int tamHei = 100;
		int iconWidth = (int) (tamHei * 0.6); // Aumentar un 60% el ancho del icono
		int fontSize = 17;
		
		// Crear botones con tama�o preferido
		JButton btnPersonal =new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona();
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnEntretenimento = new JButton("Entretenimiento");
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento();
				ventana.dispose();				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnAprendizaje = new JButton("Aprendizaje");
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje();
				ventana.dispose();
			}
		});
		btnAprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnRegresar = new JButton("Regresar ");
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador_persona sistema = new Controlador_persona();
				sistema.vista_persona();
				ventana.dispose();
			}
		});
		btnRegresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnCerrar_sesion = new JButton("Cerrar sesi�n");
		btnCerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JPanel panelDispositivos = new JPanel();
		
		panelDispositivos.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panelDispositivos.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnAsistente = new JButton("Asistente de voz");//boton de asistente
		btnAsistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelDispositivos.add(btnAsistente);
		
		JButton btnFoco = new JButton("foco");//boton de foco
		btnFoco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelDispositivos.add(btnFoco);
		
		JButton btnEnchufe = new JButton("Enchufe");//boton de enchufe
		panelDispositivos.add(btnEnchufe);
		
		JButton btnTV = new JButton("Television");//boton de television
		panelDispositivos.add(btnTV);
		
		JButton btnAspiradora = new JButton("Aspiradora");//boton de aspiradora
		panelDispositivos.add(btnAspiradora);
		
		JButton btnTermostato = new JButton("Termostato");//boton de termostato
		panelDispositivos.add(btnTermostato);
		
		Panel_Principal.add(panelDispositivos, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
	}

}
