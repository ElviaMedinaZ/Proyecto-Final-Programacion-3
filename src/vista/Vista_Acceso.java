package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Controlador_Contrasena;
import controlador.Controlador_Registro;
import modelo.Acceso_Modelo;

public class Vista_Acceso {

    private JFrame ventana;
    private Controlador_Registro registro;
    private Controlador_Contrasena cambiar;
	private Acceso_Modelo sistema;
	
    
    public Vista_Acceso() {
        // Constructor
    	sistema = new Acceso_Modelo();
        ventana = new JFrame();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); // Usa toda la pantalla
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void vista_Acceso(){
		JPanel panel_acceso = new JPanel();
		panel_acceso.setLayout(new BorderLayout(0, 0));
		panel_acceso.setBackground(Color.decode("#00758E"));

		
		Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(700, ventana.getHeight())); 
        
		panel_acceso.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.decode("#F1F1F1"));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lbl_title = new JLabel("ACCEDER");
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lbl_Nombre = new JLabel("Nombre de usuario");
		lbl_Nombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_Nombre = new JTextField();
		text_Nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_contraseña = new JLabel("Contraseña");
		lbl_contraseña.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPasswordField pass_contraseña = new JPasswordField();
		pass_contraseña.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_error = new JLabel("");
		
		JButton btn_entrar = new JButton("ENTRAR");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sistema.get_validacion_acceso( text_Nombre.getText(),pass_contraseña.getText())){
					
					System.out.println("se inicio");
					
				}
				else {
					text_Nombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					pass_contraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					
					lbl_error.setText("<html><body>Usuario o contraseña incorrecto</body></html>");
					lbl_error.setForeground(Color.red);
					lbl_error.setFont(new Font("Tahoma", Font.PLAIN, 17));//tipo y tama�o de letra
					
				}
			}
		});
		btn_entrar.setFocusable(false);
		btn_entrar.setBackground(Color.decode("#00758E"));
		btn_entrar.setForeground(new Color(255, 255, 255));
		btn_entrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblRegistro = new JLabel("<html><u>¿No tienes cuenta? Regístrate?</u></html>");//etiqueta para registrarse
		lblRegistro.addMouseListener(new MouseAdapter() {//accion para que la etiqueta nos lleve a otro panel
           @Override
           public void mouseClicked(MouseEvent e) {
        	   registro = new Controlador_Registro();
               registro.vista_Registro();
               ventana.dispose();
           }
	    });
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));//tipo y tama�o de letra
		
		JLabel lblContrasena = new JLabel("<html><u>¿Olvidaste tu contraseña? </u></html>");//etiqueta para registrarse
		lblContrasena.addMouseListener(new MouseAdapter() {//accion para que la etiqueta nos lleve a otro panel
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiar = new Controlador_Contrasena();
                cambiar.vista_Cambiar();
                ventana.dispose();
            }
	    });
        lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));//tipo y tama�o de letra
        
		JLabel lbl_icono_perfil = new JLabel("");
		lbl_icono_perfil.setIcon(new ImageIcon(Vista_Acceso.class.getResource("/img_accesos/img_perfil.png")));
		
		JLabel lbl_icono_contraseña = new JLabel("");
		lbl_icono_contraseña.setIcon(new ImageIcon(Vista_Acceso.class.getResource("/img_accesos/img_contraseña.png")));
		

		ventana.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentShown(ComponentEvent e) {
		    	
		    	int tamBtnWidth = 190;
		    	//conseguimos las dimensiones con las que terminara el panel
		        Dimension panelSize = panel.getSize();
		        //guardamos posiciones
		        int panelWidth = panelSize.width;
		        int panelHeight = panelSize.height;
		        //logramos posicionar en el centro usando el tamaño de los botones ya definidos y las medidas conseguidas 
		        int x = (panelWidth - tamBtnWidth) / 2;
		        
				lbl_title.setBounds(x, 10 , tamBtnWidth, 120);
				lbl_Nombre.setBounds(x-60, 150 , tamBtnWidth+20, 40);
				text_Nombre.setBounds(x-60, 190, tamBtnWidth+120, 30);
				lbl_icono_perfil.setBounds(x-100, 190 , tamBtnWidth+120, 30);
				lbl_contraseña.setBounds(x-60,230 , tamBtnWidth , 40);
				pass_contraseña.setBounds(x-60,270, tamBtnWidth+120, 30);
				lbl_error.setBounds(x-60,300, tamBtnWidth+120, 30);
				lbl_icono_contraseña.setBounds(x-100,270, tamBtnWidth+120, 30);
				btn_entrar.setBounds(x-60,370, tamBtnWidth+120, 40);
				lblRegistro.setBounds(x-20, 460, tamBtnWidth+120, 40);
				lblContrasena.setBounds(x, 490, tamBtnWidth+120, 40);
		      
		    }
		});
		
		panel_2.add(lbl_error);
		panel_2.add(lbl_icono_contraseña);
		panel_2.add(lbl_icono_perfil);
		panel_2.add(lblContrasena);
		panel_2.add(lblRegistro);
		panel_2.add(btn_entrar);
		panel_2.add(pass_contraseña);
		panel_2.add(lbl_contraseña);
		panel_2.add(text_Nombre);
		panel_2.add(lbl_Nombre);
		panel_2.add(lbl_title);
				
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.WEST);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2, BorderLayout.EAST);

	
		
		Panel panel_1 = new Panel();
		panel_acceso.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, BorderLayout.EAST);
		
		JPanel panel_3 =new ImganenFondo("src/img_accesos/Acceso.png");
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		ventana.getContentPane().add(panel_acceso);
		ventana.setVisible(true); 
		ventana.repaint();
		ventana.revalidate(); 
		
	}
	
	public class ImganenFondo extends JPanel {

		
		private BufferedImage image;

		    public  ImganenFondo(String imagePath) {
		        try {
		            image = ImageIO.read(new File(imagePath));
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }

		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        if (image != null) {
		            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		        }
		    }

		    @Override
		    public Dimension getPreferredSize() {
		        if (image != null) {
		            return new Dimension(image.getWidth(), image.getHeight());
		        }
		        return super.getPreferredSize();
		
		    }
		}
}