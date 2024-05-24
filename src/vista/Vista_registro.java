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
import java.text.SimpleDateFormat;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;

import controlador.Controlador_acceso;


public class Vista_registro {
	
	private JFrame ventana;	
	private Vista_utilidades utilidades;
	
	public Vista_registro() {

		utilidades = new Vista_utilidades();
        ventana = new JFrame();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); // Usa toda la pantalla
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

  
	public void vista_Registro(){
		JPanel panel_acceso = new JPanel();
		panel_acceso.setLayout(new BorderLayout(0, 0));
		panel_acceso.setBackground(Color.decode("#00758E"));

		
		Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(700, ventana.getHeight())); 
        
		panel_acceso.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#F1F1F1"));
	
		JScrollPane scrollPane = new JScrollPane(panel_2);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lbl_title = new JLabel("Registro");
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lbl_Nombre = new JLabel("Nombre(s)");
		lbl_Nombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		JTextField text_Nombre = new JTextField();
		utilidades.applyLettersOnlyFilter(text_Nombre);
		text_Nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		text_Nombre.requestFocus();
		
		
		JLabel lbl_apellidos = new JLabel("Apellidos");
		lbl_apellidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_apellidos = new JTextField();
		utilidades.applyLettersOnlyFilter(text_apellidos); //este metodo ayuda a no poder ingresar numeros en este campo 
		text_apellidos.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_fecha = new JLabel("Fecha de nacimiento");
		lbl_fecha.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JDateChooser dateChooser = new JDateChooser();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY"); // Ejemplo de formato
		dateChooser.setDateFormatString(dateFormat.toPattern());
        JFormattedTextField formattedTextField = ((JFormattedTextField) dateChooser.getDateEditor().getUiComponent());
        dateChooser.setDateFormatString(dateFormat.toPattern());

        // Obtener el campo de texto interno del JDateChooser
        JFormattedTextField textField = (JFormattedTextField) ((JTextField) dateChooser.getDateEditor().getUiComponent());
        textField.setEditable(false);// evitar poder manipularlo 
        formattedTextField.setText("DD / MM / YYYY");
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 20));
		

        JRadioButton btnRadMasculino = new JRadioButton("Masculino");
        btnRadMasculino.setFont(new Font("Tahoma", Font.BOLD, 17));
        
        JRadioButton btnRadFemenino = new JRadioButton("Femenino");
        btnRadFemenino.setFont(new Font("Tahoma", Font.BOLD, 17));
     
        
        JLabel lbl_Discapacidad = new JLabel("Discapacidad o trastorno");
        lbl_Discapacidad.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_Discapacidad = new JTextField();
		text_Discapacidad.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_Correo = new JLabel("Correo electronico");
		lbl_Correo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_Correo = new JTextField();
		text_Correo.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_Usuario = new JLabel("Usuarios");
		lbl_Usuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_Usuario = new JTextField();
		text_Usuario.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_Contraseña = new JLabel("Contraseña");
		lbl_Contraseña.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPasswordField text_Contraseña = new JPasswordField();
		text_Contraseña.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		
        JButton btn_salida = new JButton("REGRESAR");
        btn_salida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Controlador_acceso sistema = new Controlador_acceso();
            	sistema.vista_acceso();
            	ventana.dispose();

            }
        });
        btn_salida.setFocusable(false);
        btn_salida.setBackground(Color.decode("#686D6F"));
        btn_salida.setForeground(Color.decode("#FFFFFF"));
        btn_salida.setFont(new Font("Tahoma", Font.BOLD, 18));
		
        JButton btn_guardar = new JButton("SIGUIENTE");
        btn_guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	

            }
        });
        btn_guardar.setFocusable(false);
        btn_guardar.setBackground(Color.decode("#00758E"));
        btn_guardar.setForeground(Color.decode("#FFFFFF"));
        btn_guardar.setFont(new Font("Tahoma", Font.BOLD, 18));

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
		        int y = panelHeight/2;
		        

		    	// Establecer un tamaño preferido para el panel_2
				panel_2.setPreferredSize(new Dimension(0, panelHeight + y)); 
                panel_2.revalidate();
		   
		  
				lbl_title.setBounds(x, y-310 , tamBtnWidth, 120);
				lbl_Nombre.setBounds(x-60, y-170 , tamBtnWidth+20, 40);
				text_Nombre.setBounds(x-60, y-130, tamBtnWidth+120, 30);
				lbl_apellidos.setBounds(x-60, y-90 , tamBtnWidth , 40);
				text_apellidos.setBounds(x-60,y-50, tamBtnWidth+120, 30);
				lbl_fecha.setBounds(x-60,y, tamBtnWidth+120, 30);
				dateChooser.setBounds(x-60,y+40, tamBtnWidth-40, 30);
				btn_salida.setBounds(x-60,y+40, tamBtnWidth+120, 40);
				lblSexo.setBounds(x-50, y+90, tamBtnWidth+20, 40);
				btnRadMasculino.setBounds(x-50, y+150, tamBtnWidth-50, 20);
				btnRadFemenino.setBounds(x+100, y+150, tamBtnWidth-50, 20);
				lbl_Discapacidad.setBounds(x-60, y+180 , tamBtnWidth+100, 40);
				text_Discapacidad.setBounds(x-60, y+220, tamBtnWidth+120, 30);
				lbl_Correo.setBounds(x-60, y+260 , tamBtnWidth+100, 40);
				text_Correo.setBounds(x-60, y+300, tamBtnWidth+120, 30);
				lbl_Usuario.setBounds(x-60, y+340 , tamBtnWidth+100, 40);
				text_Usuario.setBounds(x-60, y+380, tamBtnWidth+120, 30);
				lbl_Contraseña.setBounds(x-60, y+430, tamBtnWidth+120, 30);
				text_Contraseña.setBounds(x-60, y+470, tamBtnWidth+120, 30);
				
				
				btn_salida.setBounds(x-60, y+580,tamBtnWidth-40 , 40);
				btn_guardar.setBounds(x+100, y+580,tamBtnWidth-40 , 40);
		      
				
				// Establecer un tamaño preferido para el panel_2
				panel_2.setPreferredSize(new Dimension(0, panelHeight + y)); 
                panel_2.revalidate();
		      
		    }
		});
		
		panel_2.add(lbl_fecha);
		panel_2.add(lblSexo);
		panel_2.add(btn_salida);
		panel_2.add(btn_guardar);
		panel_2.add(text_apellidos);
		panel_2.add(lbl_apellidos);
		panel_2.add(text_Nombre);
		panel_2.add(lbl_Nombre);
		panel_2.add(lbl_title);
		panel_2.add(dateChooser);
		panel_2.add(btnRadMasculino);
		panel_2.add(btnRadFemenino);
		panel_2.add(lbl_Discapacidad);
		panel_2.add(text_Discapacidad);
		panel_2.add(lbl_Correo);
		panel_2.add(text_Correo);
		panel_2.add(lbl_Usuario);
		panel_2.add(text_Usuario);
		panel_2.add(lbl_Contraseña);
		panel_2.add(text_Contraseña);
		
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
		
		JPanel panel_3 =new ImganenFondo("imagenes/imagenes_acceso/fondo_registro.png");
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		ventana.getContentPane().add(panel_acceso);
		ventana.setVisible(true); 
		ventana.repaint();
		ventana.revalidate(); 
		
	}
	
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