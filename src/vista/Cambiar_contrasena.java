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

public class Cambiar_contrasena {

	private JPanel contraseņa;
	private Controlador sistema;

	public Cambiar_contrasena(Controlador sistema) {
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		contraseņa = new JPanel();//creamos el panel de cambiar la contraseņa
		inicializarComponentes();//aņadimos sus componentes
	}
	
	private void inicializarComponentes()//agregamos todos los componentea 
	{
		contraseņa.setBackground(Color.decode("#F0F8FF")); 
		
		JLabel lblTitle = new JLabel("Cambiar contraseņa");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contraseņa.add(lblTitle);
		
		JButton btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) contraseņa.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contraseņa.add(btnAceptar);
		
		JButton btnIngresar = new JButton("cambiar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contraseņa.add(btnIngresar);
	}
	
	public JPanel vista_contraseņa() //retorna el panel
	{
		return contraseņa;
	}

}
