package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador;

public class Panel_principal {

	private JPanel principal;
	private Controlador sistema;

	//aqui creamos el menú del sistema
	public Panel_principal(Controlador sistema) {
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		principal = new JPanel();//creamos el panel principal
		inicializarComponentes();//añadimos sus componentes
	}

	private void inicializarComponentes() {
		
		principal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		principal.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPersonal= new JButton("Personal");//boton de apartado personal
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("personal", (JFrame) principal.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnPersonal);
		
		JButton  btnEntretener= new JButton("Entretenimiento");//boton de apartado entretenimiento
		btnEntretener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("entretenimiento", (JFrame) principal.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnEntretener);
		
		JButton btnAprender= new JButton("Aprendizaje");//boton de apartado aprendizaje
		btnAprender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("aprendizaje", (JFrame) principal.getTopLevelAncestor());//nos manda al panel personal
			}
		});
		panel.add(btnAprender);
		
		JButton btnRegresar = new JButton("Regresar");
		panel.add(btnRegresar);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de acceder
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) principal.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		principal.add(panel_1, BorderLayout.CENTER);
		
	}

	public JPanel vista_principal() {
		return principal;
	}

}
