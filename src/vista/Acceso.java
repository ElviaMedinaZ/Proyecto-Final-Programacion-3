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

public class Acceso {

	private JPanel acceso;
	private Controlador sistema;
	
	public Acceso(Controlador sistema) {
		// TODO Auto-generated constructor stub
		this.sistema = sistema;//asignamos el controlador al atributo de la clase
		acceso = new JPanel();//creamos el panel de acceso
		inicializarComponentes();//agregamos todo sus componentes
	}

	private void inicializarComponentes()//aqui creamos los componentes del panel de acceso
	{
		// TODO Auto-generated method stub
		acceso.setBackground(Color.decode("#F0F8FF"));//cambio de color
		
		JLabel lblTitulo = new JLabel("Acceder");//titulo de acceder
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));//tipo y tama�o de letra
		acceso.add(lblTitulo);
		
		JButton btnRegistro = new JButton("Registro");//boton de registro
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("registro", (JFrame) acceso.getTopLevelAncestor());
			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		acceso.add(btnRegistro);
		
		JButton btnContrase�a = new JButton("contrase�a");//si el usuario olvido la contrase�a te lleva al panel para cambiarla
		btnContrase�a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("contrase�a", (JFrame) acceso.getTopLevelAncestor());//asegura que el Controlador reciba el JFrame correcto para el cambio de paneles
			}
		});
		btnContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 20));
		acceso.add(btnContrase�a);
		
		JButton btnIngresar = new JButton("Ingresar");//boton ingresar
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.mostrarPanel("principal", (JFrame) acceso.getTopLevelAncestor());
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		acceso.add(btnIngresar);
		
	}
	
	public JPanel vista_acceso()//retorna la vista del panel de acceso 
	{
		return acceso;
	}

}
