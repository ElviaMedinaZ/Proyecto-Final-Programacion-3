package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controlador.Controlador_Contrasena;
import controlador.Controlador_Registro;

public class Vista_Acceso {

    private JFrame ventana;
    private Controlador_Registro registro;
    private Controlador_Contrasena cambiar;

    public Vista_Acceso() {
        // Constructor
        ventana = new JFrame();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); // Usa toda la pantalla
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void vista_Acceso(){
        // Método para mostrar la vista de acceso
        JPanel acceso = new JPanel();
        acceso.setBackground(Color.decode("#F0F8FF")); // Cambio de color
        
        JLabel lblTitulo = new JLabel("Acceder");//titulo de acceder
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));//tipo y tamaño de letra
		acceso.add(lblTitulo);
		
		JLabel lblRegistro = new JLabel("¿No tienes cuenta? Registrate");//etiqueta para registrarse
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 30));//tipo y tamaño de letra
		lblRegistro.addMouseListener(new MouseAdapter() {//accion para que la etiqueta nos lleve a otro panel
            @Override
            public void mouseClicked(MouseEvent e) {
            	registro = new Controlador_Registro();
            	registro.vista_Registro();
            	ventana.dispose();
            }
        });
		acceso.add(lblRegistro);
		
		JLabel lblContrasena = new JLabel("¿Olvidaste tu contraseña?");//etiqueta para registrarse
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 30));//tipo y tamaño de letra
		lblContrasena.addMouseListener(new MouseAdapter() {//accion para que la etiqueta nos lleve a otro panel
            @Override
            public void mouseClicked(MouseEvent e) {
            	cambiar = new Controlador_Contrasena();
            	cambiar.vista_Cambiar();
            	ventana.dispose();
            }
        });
		acceso.add(lblContrasena);
		
		JButton btnIngresar = new JButton("Entrar");//boton ingresar
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		acceso.add(btnIngresar);
		
		ventana.getContentPane().add(acceso);// Añade la vista al JFrame
		ventana.setVisible(true); // Hace el JFrame visible
		ventana.repaint();
		ventana.revalidate(); 
        
    }


}