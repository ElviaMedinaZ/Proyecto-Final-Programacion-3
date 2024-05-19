package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class Registro {

	private JPanel registro;
	private Controlador sistema;

	//creamos el registro del sistema
	public Registro(Controlador sistema) {
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		registro = new JPanel();//creamos el panel de registro
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes() {
		registro.setBackground(Color.decode("#F0F854")); 
		
		JLabel lblTitle = new JLabel("Registro");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		registro.add(lblTitle);
		
		JButton btnLogin = new JButton("Acceder");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 // Muestra el panel de login cuando se hace clic en el botón
				sistema.mostrarPanel("login", (JFrame) registro.getTopLevelAncestor());
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registro.add(btnLogin);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registro.add(btnFinalizar);
	}
	
	public JPanel vista_registro()//mostramos el panel
	{
		return registro;
	}
}
