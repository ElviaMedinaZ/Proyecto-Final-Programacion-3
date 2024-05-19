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

	private JPanel contraseña;
	private Controlador sistema;

	public Cambiar_contrasena(Controlador sistema) {
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		contraseña = new JPanel();//creamos el panel de cambiar la contraseña
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes()//agregamos todos los componentea 
	{
		contraseña.setBackground(Color.decode("#F0F8FF")); 
		
		JLabel lblTitle = new JLabel("Cambiar contraseña");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contraseña.add(lblTitle);
		
		JButton btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) contraseña.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contraseña.add(btnAceptar);
		
		JButton btnIngresar = new JButton("cambiar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contraseña.add(btnIngresar);
	}
	
	public JPanel vista_contraseña() //retorna el panel
	{
		return contraseña;
	}

}
