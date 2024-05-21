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

public class Geografia {

	private JPanel geografia;
	private Controlador sistema;
	
	public Geografia(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema=sistema;
		geografia=new JPanel();
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		
		geografia.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		geografia.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPersonal= new JButton("Personal");//boton de apartado personal
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("personal", (JFrame) geografia.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnPersonal);
		
		JButton  btnEntretener= new JButton("Entretenimiento");//boton de apartado entretenimiento
		btnEntretener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("entretenimiento", (JFrame) geografia.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnEntretener);
		
		JButton btnAprender= new JButton("Aprendizaje");//boton de apartado aprendizaje
		btnAprender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("aprendizaje", (JFrame) geografia.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnAprender);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("aprendizaje", (JFrame) geografia.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnRegresar);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de acceder
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) geografia.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
			
			panel_central();
			
		}
	
	private void panel_central() {//panel de los botones del centro
		JPanel panel = new JPanel();
		geografia.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.pink); //color para distinguirlo
		panel.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panel.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnFabula = new JButton("Cancion de los paises");//boton de fabula
		panel.add(btnFabula);
		
		JButton btnCuento = new JButton("Continentes");//boton de cuento
		panel.add(btnCuento);
		
		JButton btnNoticias = new JButton("Placas tectinicas");//boton de noticias
		panel.add(btnNoticias);
		
		JButton btnLeyenda = new JButton("Capas terrestres");//boton de leyenda
		panel.add(btnLeyenda);
		
		JButton btnNovela = new JButton("Efecto invernadero");//boton de novela
		panel.add(btnNovela );
		
		JButton btnCuestionario = new JButton("Cuestionario");//boton de cuestionario
		panel.add(btnCuestionario);
		
	}
	
	public JPanel vista_geografia() {//metodo para mostrar el panel 
		return geografia;
	}
	
	

}
