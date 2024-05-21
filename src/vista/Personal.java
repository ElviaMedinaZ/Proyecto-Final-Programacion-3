package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

public class Personal {
	
	private JPanel personal;
	private Controlador sistema;

	public Personal(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		personal = new JPanel();//creamos el panel principal
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes() {
		
		personal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		personal.add(panel, BorderLayout.WEST);//el panel va a la izquierda 
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPersonal= new JButton("Personal");//boton de apartado personal
		panel.add(btnPersonal);
		
		JButton  btnEntretener= new JButton("Entretenimiento");//boton de apartado entretenimiento
		panel.add(btnEntretener);
		
		JButton btnAprender= new JButton("Aprendizaje");//boton de apartado aprendizaje
		panel.add(btnAprender);
		
		JButton btnRegresar = new JButton("Regresar");//boton de regresar al menu
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("principal", (JFrame) personal.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnRegresar);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel del menu
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) personal.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
		
//		JPanel panel_1 = new JPanel();
//		personal.add(panel_1, BorderLayout.CENTER);
		
		panel_central();
		
	}
	
	private void panel_central() {
		JPanel panel = new JPanel();
		personal.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.green); //color para distinguirlo
		panel.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panel.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnNecesidades = new JButton("Necesidades");//boton de necesidades
		btnNecesidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("necesidades", (JFrame) personal.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnNecesidades);
		
		JButton btnAgenda = new JButton("Agenda");//boton de agenda
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("agenda", (JFrame) personal.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnAgenda);
		
		JButton btnEntretener = new JButton("Certificado");//boton de certificado
		panel.add(btnEntretener);
		
		JButton btnContactos = new JButton("Contactos");//boton de contactos
		panel.add(btnContactos );
		
		JButton btnEditarPerfil = new JButton("Editar perfil");//boton de editar perfil
		panel.add(btnEditarPerfil);
		
		JButton btnDispositivos = new JButton("Dispositivos");//boton de dispositivos vinculados
		panel.add(btnDispositivos);
		
	}
		

	public JPanel vista_personal() {//metodo para mostrar el panel personal
		return personal;
	}

}
