package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vista.Ventana;

public class Controlador {

	private Ventana ventana;
	private Vista_ventana vista;
	
	public Controlador() {
		ventana = new Ventana(this);
		vista = new Vista_ventana(this);
	}

	public void iniciar()//llama la vista de la ventana para mostrar el sistema
	{
		ventana.vista();
	}
	
	public JPanel vista(String op, JFrame frame)//regresa el panel dependiendo de la opcion del usuario
	{
		return vista.vista(op, frame);
	}
	
	//este metodo es para cambiar entre paneles de pantalla completa
	public void mostrarPanel(String op, JFrame frame) {
		JPanel nuevoPanel = vista(op, frame);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(nuevoPanel);
		frame.repaint();
		frame.revalidate();
	}

}
