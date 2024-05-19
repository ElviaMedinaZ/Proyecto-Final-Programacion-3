package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador;

public class Ventana {

	private JFrame frame;
	private JPanel vista;
	private Controlador sistema;
	
	public Ventana ( Controlador sistema) {
		this.sistema = sistema;
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//usa toda la pantalla 
		frame.setVisible(false);
		frame.setTitle("Headway Assist");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void vista() {
		
		vista = sistema.vista("login",frame);// Obtiene la vista de login desde el Controlador
		frame.getContentPane().add(vista);// Añade la vista al JFrame
		frame.setVisible(true); // Hace el JFrame visible
		frame.repaint();
		frame.revalidate(); 
		
	}

}
