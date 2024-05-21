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

public class Ciencias_naturales {
	private JPanel naturales;
	private Controlador sistema;
	
	public Ciencias_naturales(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		naturales = new JPanel();//creamos el panel 
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes() {
		
		naturales.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		naturales.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPersonal= new JButton("Personal");//boton de apartado personal
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("personal", (JFrame) naturales.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnPersonal);
		
		JButton  btnEntretener= new JButton("Entretenimiento");//boton de apartado entretenimiento
		btnEntretener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("entretenimiento", (JFrame) naturales.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnEntretener);
		
		JButton btnAprender= new JButton("Aprendizaje");//boton de apartado aprendizaje
		btnAprender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("aprendizaje", (JFrame) naturales.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnAprender);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("aprendizaje", (JFrame) naturales.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnRegresar);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de acceder
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) naturales.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
			
			panel_central();
			
		}
	
	private void panel_central() {//panel de los botones del centro
		JPanel panel = new JPanel();
		naturales.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.BLUE); //color para distinguirlo
		panel.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panel.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnEvolucion = new JButton("Evolucion");//boton de evolucion
		panel.add(btnEvolucion);
		
		JButton btnGenetica = new JButton("Genetica");//boton de genetica
		panel.add(btnGenetica);
		
		JButton btnBiomas = new JButton("Biomas");//boton de biomas
		panel.add(btnBiomas);
		
		JButton btnFotosintesis = new JButton("Fotosintesis");//boton de fotosintesis
		panel.add(btnFotosintesis);
		
		JButton btnCuerpo = new JButton("Cuerpo Humano");//boton de cuerpo humano
		panel.add(btnCuerpo );
		
		JButton btnCuestionario = new JButton("Cuestionario");//boton de cuestionario
		panel.add(btnCuestionario);
		
	}
	
	public JPanel vista_naturales() {//metodo para mostrar el panel 
		return naturales;
	}

}