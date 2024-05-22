package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador_Acceso;

public class Vista_Cambio_Contrasena {

	private JFrame ventana;
	private Controlador_Acceso acceso;
	
	public Vista_Cambio_Contrasena() {
		// TODO Auto-generated constructor stub
		ventana = new JFrame();
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);//usa toda la pantalla 
		ventana.setVisible(false);
		ventana.setTitle("Headway Assist");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void vista_Cambiar() {
		
		JPanel contrasena = new JPanel();
		contrasena.setBackground(Color.decode("#F0DFFF")); 
		
		JLabel lblTitle = new JLabel("Cambiar contraseña");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contrasena.add(lblTitle);
		
		JButton btnRegresar = new JButton("Regresar");//boton de regresar al login
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceso = new Controlador_Acceso();
				acceso.vista_Acceso();
				ventana.dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contrasena.add(btnRegresar);
		
		JButton btnModificar = new JButton("Modificar");//voton de modificar la contraseña
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contrasena.add(btnModificar);
	
		ventana.getContentPane().add(contrasena);
		ventana.setVisible(true); 
		ventana.repaint();
		ventana.revalidate(); 
		
	}

}
