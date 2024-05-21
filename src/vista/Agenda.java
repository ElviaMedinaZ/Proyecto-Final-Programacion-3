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

public class Agenda {

	private JPanel agenda;
	private Controlador sistema;
	
	public Agenda(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		agenda = new JPanel();//creamos el panel principal
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes() {
		
		agenda.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			agenda.add(panel, BorderLayout.WEST);//el panel va a la izquierda 
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			
			JButton btnPersonal= new JButton("Personal");//boton de apartado personal
			btnPersonal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sistema.mostrarPanel("personal", (JFrame) agenda.getTopLevelAncestor());//nos manda al panel personal
				}
			});
			panel.add(btnPersonal);
			
			JButton  btnEntretener= new JButton("Entretenimiento");//boton de apartado entretenimiento
			btnEntretener.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sistema.mostrarPanel("entretenimiento", (JFrame) agenda.getTopLevelAncestor());//nos manda al panel personal
				}
			});
			panel.add(btnEntretener);
			
			JButton btnAprender= new JButton("Aprendizaje");//boton de apartado aprendizaje
			btnAprender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sistema.mostrarPanel("aprendizaje", (JFrame) agenda.getTopLevelAncestor());//nos manda al panel personal
				}
			});
			panel.add(btnAprender);
			
			JButton btnRegresar = new JButton("Regresar");
			btnRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sistema.mostrarPanel("personal", (JFrame) agenda.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
				}
			});
			panel.add(btnRegresar);
			
			JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de acceder
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sistema.mostrarPanel("login", (JFrame) agenda.getTopLevelAncestor());
				}
			});
			panel.add(btnSalir);
			
			panel_central();
			
		}
	
	private void panel_central() {//panel de los botones del centro
		JPanel panel = new JPanel();
		agenda.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.blue); //color para distinguirlo
		//panel.setLayout(new GridLayout(0, 1, 0, 0));//3 columnas, 3 filas, espacios entre el centro de los botones
		
		JButton btnCrear = new JButton("Crear");//boton de crear
		panel.add(btnCrear);
		
		JButton btnEditar = new JButton("Editar");//boton de editar
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");//boton de eliminar
		panel.add(btnEliminar);
		
	}
	
	public JPanel vista_agenda() {//metodo para mostrar el panel 
		return agenda;
	}

}
