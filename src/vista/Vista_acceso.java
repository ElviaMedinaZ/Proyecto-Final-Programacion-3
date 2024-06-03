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

import controlador.Controlador_contrasena;
import controlador.Controlador_registro;
import controlador.Controlador_inicio;
import modelo.Modelo_acceso;

public class Vista_acceso {

    private JFrame ventana;
    private Controlador_registro registro;
    private Controlador_contrasena cambiar;
	private Modelo_acceso sistema;
	private Controlador_inicio inicio;
	
	
	
    
    public Vista_acceso() {
        // Constructor
    	sistema = new Modelo_acceso();
        ventana = new JFrame();
        ventana.setBounds(10, 10, 1280, 720);
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());


    }

    public void vista_Acceso(){
		JPanel panel_acceso = new JPanel();
		panel_acceso.setLayout(new BorderLayout(0, 0));
		panel_acceso.setBackground(Color.decode("#00758E"));

		
		Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(ventana.getWidth()/2, ventana.getHeight())); 
        
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
	
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(sistema.get_validacion_acceso( text_Nombre.getText(),pass_contraseña.getText())){
					
					inicio = new Controlador_inicio();
					inicio.vista_inicio();
					ventana.dispose();
				}
				else {
					text_Nombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					pass_contraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					
					lbl_error.setText("<html><body>Usuario o contraseña incorrecto</body></html>");
					lbl_error.setForeground(Color.red);
					lbl_error.setFont(new Font("Tahoma", Font.PLAIN, 17));//tipo y tamaño de letra
					
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
        	   registro = new Controlador_registro();
               registro.vista_Registro();
               ventana.dispose();
           }
	    });
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));//tipo y tamaño de letra
		
		JLabel lblContrasena = new JLabel("<html><u>¿Olvidaste tu contraseña? </u></html>");//etiqueta para registrarse
		lblContrasena.addMouseListener(new MouseAdapter() {//accion para que la etiqueta nos lleve a otro panel
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiar = new Controlador_contrasena();
                cambiar.vista_Cambiar();
                ventana.dispose();
            }
	    });
        lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));//tipo y tamaño de letra
        
		JLabel lbl_icono_perfil = new JLabel("");
		lbl_icono_perfil.setIcon(new ImageIcon("imagenes/imagenes_acceso/img_perfil.png"));
		
		JLabel lbl_icono_contraseña = new JLabel("");
		lbl_icono_contraseña.setIcon(new ImageIcon("imagenes/imagenes_acceso/img_contraseña.png"));
		

		ventana.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentShown(ComponentEvent e) {
		    	
		    	int tamBtnWidth = 190;
		    	//conseguimos las dimensiones con las que terminara el panel
		        Dimension panelSize = panel_2.getSize();
		        System.err.println(panelSize);
		        //guardamos posiciones
		        int panelWidth = panelSize.width;
		        int panelHeight = panelSize.height;
		        //logramos posicionar en el centro usando el tamaño de los botones ya definidos y las medidas conseguidas 
		        
		        
		        
		        int x = (panelWidth - tamBtnWidth) / 2;
		        int y = panelHeight/2;
		        
		  
		        
				lbl_title.setBounds(x, y-310 , tamBtnWidth, 120);
				lbl_Nombre.setBounds(x-60, y-180 , tamBtnWidth+20, 40);
				text_Nombre.setBounds(x-60, y-140, tamBtnWidth+120, 30);
				lbl_icono_perfil.setBounds(x-100, y-140 , tamBtnWidth+120, 30);
				lbl_contraseña.setBounds(x-60, y-90 , tamBtnWidth , 40);
				pass_contraseña.setBounds(x-60,y-50, tamBtnWidth+120, 30);
				lbl_error.setBounds(x-60,y-20, tamBtnWidth+120, 30);
				lbl_icono_contraseña.setBounds(x-100,y-50, tamBtnWidth+120, 30);
				btn_entrar.setBounds(x-60,y+40, tamBtnWidth+120, 40);
				lblRegistro.setBounds(x-20, y+100, tamBtnWidth+120, 40);
				lblContrasena.setBounds(x, y+150, tamBtnWidth+120, 40);
		      
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
		
		JPanel panel_3 =new ImganenFondo("imagenes/imagenes_acceso/fondo_acceso.png");
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		ventana.getContentPane().add(panel_acceso);
		ventana.setVisible(true); 
		ventana.repaint();
		ventana.revalidate(); 
		
	}
	
	@SuppressWarnings("serial")
	public class ImganenFondo extends JPanel {//mostramos la imagen al fondo del jpanel

		
		private BufferedImage image;

		    public  ImganenFondo(String imagePath) {//constructor que carga la imagen
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