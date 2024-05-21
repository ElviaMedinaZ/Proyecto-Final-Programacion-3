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

public class Matematicas {
	private JPanel matematicas;
	private Controlador sistema;
	
	public Matematicas(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		matematicas = new JPanel();//creamos el panel principal
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes() {
		
		matematicas.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			matematicas.add(panel, BorderLayout.WEST);//el panel va a la izquierda 
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
					sistema.mostrarPanel("aprendizaje", (JFrame) matematicas.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
				}
			});
			panel.add(btnRegresar);
			
			JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de login
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sistema.mostrarPanel("login", (JFrame) matematicas.getTopLevelAncestor());
				}
			});
			panel.add(btnSalir);
			
//			JPanel panel_1 = new JPanel();
//			aprendizaje.add(panel_1, BorderLayout.CENTER);
			
			panel_central();
			
		}
	
	private void panel_central() {//panel de los botones del centro
		JPanel panel = new JPanel();
		matematicas.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.yellow); //color para distinguirlo
		panel.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panel.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnCalculadora = new JButton("Calculadora");//boton de calculadora
		panel.add(btnCalculadora);
		
		JButton btnMultiplicar = new JButton("Multiplicaciones");//boton de multiplicaciones
		panel.add(btnMultiplicar);
		
		JButton btnDivision = new JButton("Divisiones");//boton de divisiones
		panel.add(btnDivision);
		
		JButton btnSuma = new JButton("Suma");//boton de suma
		panel.add(btnSuma);
		
		JButton btnResta = new JButton("Resta");//boton de resta
		panel.add(btnResta);
		
		JButton btnCuestionario = new JButton("Cuestionario");//boton de cuestionario
		panel.add(btnCuestionario);
		
	}
	
	public JPanel vista_matematicas() {//metodo para mostrar el panel 
		return matematicas;
	}

}
