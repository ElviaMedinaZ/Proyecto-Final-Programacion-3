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

public class Aprendizaje {

	private JPanel aprendizaje;
	private Controlador sistema;
	
	public Aprendizaje(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		aprendizaje = new JPanel();//creamos el panel principal
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes() {
		
		aprendizaje.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		aprendizaje.add(panel, BorderLayout.WEST);//el panel va a la izquierda 
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPersonal= new JButton("Personal");//boton de apartado personal
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("personal", (JFrame) aprendizaje.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnPersonal);
		
		JButton  btnEntretener= new JButton("Entretenimiento");//boton de apartado entretenimiento
		btnEntretener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("entretenimiento", (JFrame) aprendizaje.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnEntretener);
		
		JButton btnAprender= new JButton("Aprendizaje");//boton de apartado aprendizaje
		btnAprender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("aprendizaje", (JFrame) aprendizaje.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnAprender);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("principal", (JFrame) aprendizaje.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnRegresar);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de acceder
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) aprendizaje.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
		
		panel_central();
		
	}
	
	private void panel_central() {
		JPanel panel = new JPanel();
		aprendizaje.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.ORANGE); //color para distinguirlo
		panel.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panel.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnEspanol = new JButton("Español");//boton de necesidades
		btnEspanol .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("espanol", (JFrame) aprendizaje.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnEspanol );
		
		JButton btnMatematicas = new JButton("Matemáticas");//boton de matematicas
		btnMatematicas .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("matematicas", (JFrame) aprendizaje.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnMatematicas);
		
		JButton btnGeografia = new JButton("Geografía");//boton de geografia
		btnGeografia .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("geografia", (JFrame) aprendizaje.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnGeografia);
		
		JButton btnHistoria = new JButton("Historia");//boton de historia
		btnHistoria .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("historia", (JFrame) aprendizaje.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnHistoria);
		
		JButton btnCiencias = new JButton("Ciencias naturales");//boton de ciencias
		btnCiencias .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("naturales", (JFrame) aprendizaje.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnCiencias);
		
		JButton btnFilosofia = new JButton("Filosofía");//boton de filosofia
		btnFilosofia .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("filosofia", (JFrame) aprendizaje.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnFilosofia);
	}

	public JPanel vista_aprendizaje() {//metodo para mostrar el panel 
		return aprendizaje;
	}

}
