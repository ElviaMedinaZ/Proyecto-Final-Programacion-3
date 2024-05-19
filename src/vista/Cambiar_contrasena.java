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

	private JPanel contrase�a;
	private Controlador sistema;

	public Cambiar_contrasena(Controlador sistema) {
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		contrase�a = new JPanel();//creamos el panel de cambiar la contrase�a
		inicializarComponentes();//a�adimos sus componentes
	}
	
	private void inicializarComponentes()//agregamos todos los componentea 
	{
		contrase�a.setBackground(Color.decode("#F0F8FF")); 
		
		JLabel lblTitle = new JLabel("Cambiar contrase�a");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contrase�a.add(lblTitle);
		
		JButton btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) contrase�a.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contrase�a.add(btnAceptar);
		
		JButton btnIngresar = new JButton("cambiar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contrase�a.add(btnIngresar);
	}
	
	public JPanel vista_contrase�a() //retorna el panel
	{
		return contrase�a;
	}

}
