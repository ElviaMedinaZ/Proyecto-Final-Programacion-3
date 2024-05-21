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

	private JPanel contrasena;
	private Controlador sistema;

	public Cambiar_contrasena(Controlador sistema) {
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		contrasena = new JPanel();//creamos el panel de cambiar la contraseña
		inicializarComponentes();//añadimos sus componentes
	}
	
	private void inicializarComponentes()//agregamos todos los componentea 
	{
		contrasena.setBackground(Color.decode("#F0F8FF")); 
		
		JLabel lblTitle = new JLabel("Cambiar contraseña");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contrasena.add(lblTitle);
		
		JButton btnRegresar = new JButton("Regresar");//boton de regresar al login
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("login", (JFrame) contrasena.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contrasena.add(btnRegresar);
		
		JButton btnModificar = new JButton("Modificar");//voton de modificar la contraseña
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contrasena.add(btnModificar);
	}
	
	public JPanel vista_contrasena() //retorna el panel
	{
		return contrasena;
	}

}
