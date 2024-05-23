package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador_acceso;

public class Vista_registro {
	
	private JFrame ventana;	
	private Controlador_acceso acceso;

	public Vista_registro() {
		// TODO Auto-generated constructor stub
		ventana = new JFrame();
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);//usa toda la pantalla 
		ventana.setVisible(false);
		ventana.setTitle("Headway Assist");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void vista_Registro() {
		
		JPanel registro = new JPanel();
		registro.setBackground(Color.decode("#F0F854")); 
		
		JLabel lblTitle = new JLabel("Registro");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		registro.add(lblTitle);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acceso = new Controlador_acceso();
				acceso.vista_acceso();
				ventana.dispose();
			}
		});
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registro.add(btnAcceder);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registro.add(btnFinalizar);
	
	
		ventana.getContentPane().add(registro);
		ventana.setVisible(true); 
		ventana.repaint();
		ventana.revalidate(); 
		
	}

}
