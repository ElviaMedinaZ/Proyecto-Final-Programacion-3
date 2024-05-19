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

	private JPanel pricipal;
	private Controlador sistema;

	//aqui creamos el menú del sistema
	public Panel_principal(Controlador sistema) {
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		pricipal = new JPanel();//creamos el panel principal
		inicializarComponentes();//añadimos sus componentes
	}

	private void inicializarComponentes() {
		
		pricipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		pricipal.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAprender = new JButton("aprender");
		panel.add(btnAprender);
		
		JButton btnPersonal = new JButton("personal");
		panel.add(btnPersonal);
		
		JButton btnEntretener = new JButton("entretenimiento");
		panel.add(btnEntretener);
		
		JButton btnSalir= new JButton("salir");//boton que nos regresa al panel de acceder
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) pricipal.getTopLevelAncestor());
			}
		});
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		pricipal.add(panel_1, BorderLayout.CENTER);
		
	}
	

	public JPanel vista_principal() {
		return pricipal;
	}

}
