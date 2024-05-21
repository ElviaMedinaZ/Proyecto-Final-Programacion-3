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

public class Necesidades {

	private JPanel necesidades;
	private Controlador sistema;
	
	public Necesidades(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		necesidades = new JPanel();//creamos el panel principal
		inicializarComponentes();//a�adimos sus componentes
	}
	
	private void inicializarComponentes() {
		
	necesidades.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		necesidades.add(panel, BorderLayout.WEST);//el panel va a la izquierda 
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
				sistema.mostrarPanel("personal", (JFrame) necesidades.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		panel.add(btnRegresar);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel del menu
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) necesidades.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
		
//		JPanel panel_1 = new JPanel();
//		aprendizaje.add(panel_1, BorderLayout.CENTER);
		
		panel_central();
		
	}
	
	private void panel_central() {//panel de los botones del centro
		JPanel panel = new JPanel();
		necesidades.add(panel, BorderLayout.CENTER); //este panel va en el centro
		panel.setBackground(Color.pink); //color para distinguirlo
		panel.setLayout(new GridLayout(3, 3, 100, 50));//3 columnas, 3 filas, espacios entre el centro de los botones
		panel.setBorder(new EmptyBorder(80, 30, 70, 20));//espacio entre los botones (arriba,izquierda,abajo,derecha)
		
		JButton btnCuidador = new JButton("LLamar cuidador");//boton de necesidades
		panel.add(btnCuidador);
		
		JButton btnHambre = new JButton("Tengo hambre");//boton de agenda
		panel.add(btnHambre);
		
		JButton btnComezon = new JButton("Comez�n");//boton de certificado
		panel.add(btnComezon);
		
		JButton btnSueno = new JButton("Sue�o");//boton de contactos
		panel.add(btnSueno);
		
		JButton btnBano= new JButton("Ba�o");//boton de editar perfil
		panel.add(btnBano);
		
		JButton btnSentirseMal = new JButton("Me siento mal");//boton de dispositivos vinculados
		panel.add(btnSentirseMal);
		
	}

	public JPanel vista_necesidades() {//metodo para mostrar el panel
		return necesidades;
	}

}
