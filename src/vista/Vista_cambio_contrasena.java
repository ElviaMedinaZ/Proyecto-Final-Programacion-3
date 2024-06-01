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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Controlador_acceso;
import modelo.Modelo_cambiar;



public class Vista_cambio_contrasena {

	private JFrame ventana;
	private Modelo_cambiar sistema;
	
	public Vista_cambio_contrasena() {
		sistema = new Modelo_cambiar();
		ventana = new JFrame();
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);//usa toda la pantalla 
		ventana.setVisible(false);
		ventana.setTitle("Headway Assist");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_Cambiar() {
		
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
		
		JLabel lbl_title = new JLabel("Modificar contraseña");
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 29));
		
		JLabel lbl_Nombre = new JLabel("Nombre de usuario");
		lbl_Nombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_Nombre = new JTextField();
		text_Nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_contrasena = new JLabel("Contraseña nueva");
		lbl_contrasena.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPasswordField pass_contrasena = new JPasswordField();
		pass_contrasena.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		
		JLabel lbl_combiar_contrasena = new JLabel("Confirmar contraseña");
		lbl_combiar_contrasena.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPasswordField pass_combiar_contrasena = new JPasswordField();
		pass_combiar_contrasena.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		

		
        JButton btn_regresar = new JButton("REGRESAR");
        btn_regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Controlador_acceso sistema = new Controlador_acceso();
            	sistema.vista_acceso();
            	ventana.dispose();

            }
        });
        btn_regresar.setFocusable(false);
        btn_regresar.setBackground(Color.decode("#686D6F"));
        btn_regresar.setForeground(Color.decode("#FFFFFF"));
        btn_regresar.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		
		
		JButton btn_modificar = new JButton("MODIFICAR");
		btn_modificar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(text_Nombre.getText().isEmpty() || pass_combiar_contrasena.getText().isEmpty() ||  pass_contrasena.getText().isEmpty()) {
				
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					
					if(text_Nombre.getText().isEmpty()) {
						text_Nombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					}
					else {
						text_Nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
					}
					if(pass_combiar_contrasena.getText().isEmpty()) {
						pass_combiar_contrasena.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					}
					else {
						pass_combiar_contrasena.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
					}
					if(pass_contrasena.getText().isEmpty()) {
						pass_contrasena.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						
					}
					else {
						pass_contrasena.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));

					}
					
					return;
				}
				
				text_Nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
				pass_combiar_contrasena.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
				pass_contrasena.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
							
				
				if(!pass_contrasena.getText().equals(pass_combiar_contrasena.getText())) {
					JOptionPane.showMessageDialog(null, "La contraseñas no son iguales", "Error", JOptionPane.ERROR_MESSAGE);
					pass_combiar_contrasena.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					pass_contrasena.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					
					return;
				}
				
	           	int response =JOptionPane.showConfirmDialog(
                        null, 
                        "¿Deseas confirmar la operación?", 
                        "", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE
                );

                if (response == JOptionPane.YES_OPTION) {
                	 
    				boolean usuario = sistema.verificarUsuarioExistente(text_Nombre.getText());
    				if (!usuario) {
    					JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    					text_Nombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
    					return;
    				}	
    				
    				boolean cambio_valido = false;
					
    				try {
						cambio_valido = sistema.cambiarContrasena(text_Nombre.getText(),pass_contrasena.getText());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                    if (cambio_valido) {
                        JOptionPane.showMessageDialog(null, "Cambio exitoso...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        Controlador_acceso sistema = new Controlador_acceso();
                        sistema.vista_acceso();
                        ventana.dispose();
                    } 
                               
                } else if (response == JOptionPane.NO_OPTION) {
                    return;
                } else {
                    return;
                }
               
     
				
			}
		});
		
		btn_modificar.setFocusable(false);
		btn_modificar.setBackground(Color.decode("#00758E"));
		btn_modificar.setForeground(new Color(255, 255, 255));
		btn_modificar.setFont(new Font("Tahoma", Font.BOLD, 20));

        
		JLabel lbl_icono_perfil = new JLabel("");
		lbl_icono_perfil.setIcon(new ImageIcon("imagenes/imagenes_acceso/img_perfil.png"));
		
		JLabel lbl_icono_contrasena = new JLabel("");
		lbl_icono_contrasena.setIcon(new ImageIcon("imagenes/imagenes_acceso/img_contraseña.png"));
		
		JLabel lbl_icono_combiar_contrasena = new JLabel("");
		lbl_icono_combiar_contrasena.setIcon(new ImageIcon("imagenes/imagenes_acceso/img_contraseña.png"));
		

		
		ventana.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentShown(ComponentEvent e) {
		    	
		    	int tamBtnWidth = 190;
		    	//conseguimos las dimensiones con las que terminara el panel
		        Dimension panelSize = panel_2.getSize();
		        //guardamos posiciones
		        int panelWidth = panelSize.width;
		        int panelHeight = panelSize.height;
		        //logramos posicionar en el centro usando el tamaño de los botones ya definidos y las medidas conseguidas 
		        
		        
		        
		        int x = (panelWidth - tamBtnWidth) / 2;
		        int y = panelHeight/2;
		        
		  
		        
				lbl_title.setBounds(x-60, y-310 , tamBtnWidth+150, 120);
				lbl_Nombre.setBounds(x-60, y-180 , tamBtnWidth+20, 40);
				text_Nombre.setBounds(x-60, y-140, tamBtnWidth+120, 30);
				lbl_icono_perfil.setBounds(x-100, y-140 , tamBtnWidth+120, 30);
				lbl_contrasena.setBounds(x-60, y-90 , tamBtnWidth , 40);
				pass_contrasena.setBounds(x-60,y-50, tamBtnWidth+120, 30);
				lbl_icono_contrasena.setBounds(x-100,y-50, tamBtnWidth+120, 30);
				btn_regresar.setBounds(x-60,y+120, tamBtnWidth+120, 40);
				btn_modificar.setBounds(x-60,y+190, tamBtnWidth+120, 40);
				lbl_combiar_contrasena.setBounds(x-60, y+10, tamBtnWidth+120, 40);
				pass_combiar_contrasena.setBounds(x-60, y+50, tamBtnWidth+120, 30);
				lbl_icono_combiar_contrasena.setBounds(x-100, y+50, tamBtnWidth+120, 30);
		      
		    }
		});
		
		panel_2.add(lbl_icono_combiar_contrasena);
		panel_2.add(lbl_icono_contrasena);
		panel_2.add(lbl_icono_perfil);
		panel_2.add(lbl_combiar_contrasena);
		panel_2.add(pass_combiar_contrasena);
		panel_2.add(btn_regresar);
		panel_2.add(btn_modificar);
		panel_2.add(pass_contrasena);
		panel_2.add(lbl_contrasena);
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
		
		JPanel panel_3 =new ImganenFondo("imagenes/imagenes_acceso/fondo_cambiar_contraseña.png");
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		ventana.getContentPane().add(panel_acceso);
		ventana.setVisible(true); 
		ventana.repaint();
		ventana.revalidate(); 
		
	}
	
	@SuppressWarnings("serial")
	public class ImganenFondo extends JPanel {

		
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
