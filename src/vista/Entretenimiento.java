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

public class Entretenimiento {

	private JPanel entretenimiento;
	private Controlador sistema;
	
	public Entretenimiento(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		entretenimiento = new JPanel();//creamos el panel principal
		inicializarComponentes();//a�adimos sus componentes
	}
	
	private void inicializarComponentes() {
		
		entretenimiento.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		entretenimiento.add(panel, BorderLayout.WEST);//el panel va a la izquierda 
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
				sistema.mostrarPanel("principal", (JFrame) entretenimiento.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnRegresar);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de login
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) entretenimiento.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		entretenimiento.add(panel_1, BorderLayout.CENTER);
		
		panel_central();
		
	}
	
	private void panel_central() {
		JPanel panel = new JPanel();
		entretenimiento.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.MAGENTA); //color para distinguirlo
		panel.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panel.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnPeliculas = new JButton("Pel�culas");//boton de necesidades
		panel.add(btnPeliculas);
		
		JButton btnYouTube = new JButton("YouTube");//boton de agenda
		panel.add(btnYouTube);
		
		JButton btnTicTac = new JButton("Tic Tac Toe");//boton de certificado
		panel.add(btnTicTac);
		
		JButton btnBuscaMinas = new JButton("Busca minas");//boton de contactos
		panel.add(btnBuscaMinas);
		
		JButton btnRompecabezas = new JButton("Rompecabezas num�rico");//boton de editar perfil
		panel.add(btnRompecabezas);
		
		JButton btnSpotify = new JButton("Spotify");//boton de dispositivos vinculados
		panel.add(btnSpotify);
		
	}

	public JPanel vista_entretenimiento() {//metodo para mostrar el panel personal
		return entretenimiento;
	}

}
