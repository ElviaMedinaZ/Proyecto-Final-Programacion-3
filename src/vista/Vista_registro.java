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
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());

    }

  
	@SuppressWarnings("static-access")
	public void vista_Registro(){
		JPanel panel_acceso = new JPanel();
		panel_acceso.setLayout(new BorderLayout(0, 0));
		panel_acceso.setBackground(Color.decode("#00758E"));

		
		Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(700, ventana.getHeight())); 
        
		panel_acceso.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_registro = new JPanel();
		panel_registro.setBackground(Color.decode("#F1F1F1"));
	
		JScrollPane scroll = new JScrollPane(panel_registro);
		panel.add(scroll, BorderLayout.CENTER);
		panel_registro.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("REGISTRO");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lbl_nombre = new JLabel("Nombre(s)");
		lbl_nombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		JTextField text_nombre = new JTextField();
		utilidades.limitar_textfield(text_nombre, 30); // NOTA: revicion completada
		text_nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));

		
		
		JLabel lbl_apellidos = new JLabel("Apellidos");
		lbl_apellidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		JTextField text_apellidos = new JTextField();
		utilidades.limitar_textfield(text_apellidos, 40);
		
		
		text_apellidos.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_fecha = new JLabel("Fecha de nacimiento");
		lbl_fecha.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JDateChooser calendario = new JDateChooser();
		SimpleDateFormat formato_datos = new SimpleDateFormat("dd-MM-YYYY"); // Ejemplo de formato
		calendario.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		calendario.setDateFormatString(formato_datos.toPattern());
        JFormattedTextField formattedTextField = ((JFormattedTextField) calendario.getDateEditor().getUiComponent());
        calendario.setDateFormatString(formato_datos.toPattern());

        // Obtener el campo de texto interno del JDateChooser
        JFormattedTextField text_calendario = (JFormattedTextField) ((JTextField) calendario.getDateEditor().getUiComponent());
        text_calendario.setEditable(false);// evitar poder manipularlo 
        formattedTextField.setText("DD / MM / YYYY");
		
		JLabel lbl_sexo = new JLabel("Sexo");
		lbl_sexo.setFont(new Font("Tahoma", Font.BOLD, 20));
		

        JRadioButton btnRad_masculino = new JRadioButton("Masculino");
        btnRad_masculino.setFont(new Font("Tahoma", Font.BOLD, 17));
        
        JRadioButton btnRad_femenino = new JRadioButton("Femenino");
        btnRad_femenino.setFont(new Font("Tahoma", Font.BOLD, 17));
        
        //Para permitir que se seleccione solo 1
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(btnRad_masculino);
        grupoGenero.add(btnRad_femenino);
        
        JLabel lbl_discapacidad = new JLabel("Discapacidad o trastorno");
        lbl_discapacidad.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_discapacidad = new JTextField();
		utilidades.limitTextFieldLength(text_discapacidad,40);
		text_discapacidad.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_correo = new JLabel("Correo electronico");
		lbl_correo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_correo = new JTextField();
		utilidades.limitTextFieldLength(text_correo, 40);
		text_correo.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_Usuario = new JLabel("Usuario");
		lbl_Usuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextField text_Usuario = new JTextField();
		utilidades.limitTextFieldLength(text_Usuario, 40);
		
		if (text_Usuario.getText().length() >= 40) {
            JOptionPane.showMessageDialog(null, "Longitud maxima (40) alcanzada");
        }
		
		text_Usuario.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		JLabel lbl_contraseña = new JLabel("Contraseña");
		lbl_contraseña.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPasswordField text_contraseña = new JPasswordField();
		text_contraseña.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
		
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
		
        JButton btn_guardar = new JButton("REGISTRAR");
        
        btn_guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if (text_nombre.getText().isEmpty() || text_apellidos.getText().isEmpty() || calendario.getDate() == null 
            		|| text_correo.getText().isEmpty() || text_Usuario.getText().isEmpty() || text_contraseña.getPassword().length == 0) {
            		
            	     //validacion para no tener campos vacios
            		
            	     JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            	     
            	     if (text_nombre.getText().isEmpty()) {
            	    	 text_nombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	    }else {
            	    	text_nombre.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
            	    }
            	    
            	     if (text_apellidos.getText().isEmpty()) {
            	    	 text_apellidos.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	     }else {
            	    	 text_apellidos.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
             	    }
            	    
            	     if (calendario.getDate() == null) {
            	    	 calendario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	     }else {
            	    	 calendario.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
             	    }
            	     
            	    if (text_correo.getText().isEmpty()) {
            	    	text_correo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	    }else {
            	    	 text_correo.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
            	    }
            	    
            	    if (text_Usuario.getText().isEmpty()) {
            	    	text_Usuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	    }else {
            	    	text_Usuario.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
            	    }
            	    
            	    if (text_contraseña.getPassword().length == 0) {
            	    	text_contraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	    }else {
            	    	text_contraseña.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
            	    }
            	    
            	    if (text_discapacidad.getText().isEmpty()){
            	    	text_discapacidad.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	    }else {
            	    	text_discapacidad.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
            	    }
            	    
            	            return; // No permite el siguiente  si falta algun campo
            	 }
            	
            	
            	
                
               
                text_Usuario.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
                text_contraseña.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
                
                // Obtiene la fecha de nacimiento que se selecciono
                Date fecha_nacimiento = calendario.getDate();
                Calendar fecha_min = Calendar.getInstance();
                Calendar fecha_max = Calendar.getInstance();
                
                if (fecha_nacimiento != null) {
                   
                    fecha_min.add(Calendar.YEAR, -7);
                    fecha_max.add(Calendar.YEAR, -90);

                    if (fecha_nacimiento.after(fecha_min.getTime())) {
                        JOptionPane.showMessageDialog(null, "Debe tener al menos 7 años para registrarse", "Error", JOptionPane.ERROR_MESSAGE);
                        calendario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        return;
                    } else if (fecha_nacimiento.before(fecha_max.getTime())) {
                        JOptionPane.showMessageDialog(null, "Rango de edad no permitido", "Error", JOptionPane.ERROR_MESSAGE);
                        calendario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        return;
                    }
                }
                
                calendario.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
                
                //Validacion para el correo electronico
                String correo = text_correo.getText();
                String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";//Valores aceptados para un correo e
                
                if (!Pattern.matches(emailPattern, correo)) {
                    JOptionPane.showMessageDialog(null, "Correo electronico invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    text_correo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    return;
                } else {
                    text_correo.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
                }

            }  
        });
        
        
        btn_guardar.setFocusable(false);
        btn_guardar.setBackground(Color.decode("#00758E"));
        btn_guardar.setForeground(Color.decode("#FFFFFF"));
        btn_guardar.setFont(new Font("Tahoma", Font.BOLD, 18));

		ventana.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentShown(ComponentEvent e) {
		    	
		    	int tamBtn_ancho = 190;
		    	//conseguimos las dimensiones con las que terminara el panel
		        Dimension panelSize = panel.getSize();
		        //guardamos posiciones
		        int panel_ancho = panelSize.width;
		        int panel_alto = panelSize.height;     
		        
		        //logramos posicionar en el centro usando el tamaño de los botones ya definidos y las medidas conseguidas 
		        int x = (panel_ancho - tamBtn_ancho) / 2;
		        int y = panel_alto/2;
		        

		    	// Establecer un tamaño preferido para el panel_2
		        panel_registro.setPreferredSize(new Dimension(0, panel_alto + y)); 
				panel_registro.revalidate();
		   
		  
				lbl_titulo.setBounds(x-10, y-310 , tamBtn_ancho+120, 120);
				lbl_nombre.setBounds(x-60, y-170 , tamBtn_ancho+20, 40);
				text_nombre.setBounds(x-60, y-130, tamBtn_ancho+120, 30);
				lbl_apellidos.setBounds(x-60, y-90 , tamBtn_ancho , 40);
				text_apellidos.setBounds(x-60,y-50, tamBtn_ancho+120, 30);
				lbl_fecha.setBounds(x-60,y, tamBtn_ancho+120, 30);
				calendario.setBounds(x-60,y+40, tamBtn_ancho-40, 30);
				btn_salida.setBounds(x-60,y+40, tamBtn_ancho+120, 40);
				lbl_sexo.setBounds(x-50, y+90, tamBtn_ancho+20, 40);
				btnRad_masculino.setBounds(x-50, y+150, tamBtn_ancho-50, 20);
				btnRad_femenino.setBounds(x+100, y+150, tamBtn_ancho-50, 20);
				lbl_discapacidad.setBounds(x-60, y+180 , tamBtn_ancho+100, 40);
				text_discapacidad.setBounds(x-60, y+220, tamBtn_ancho+120, 30);
				lbl_correo.setBounds(x-60, y+260 , tamBtn_ancho+100, 40);
				text_correo.setBounds(x-60, y+300, tamBtn_ancho+120, 30);
				lbl_Usuario.setBounds(x-60, y+340 , tamBtn_ancho+100, 40);
				text_Usuario.setBounds(x-60, y+380, tamBtn_ancho+120, 30);
				lbl_contraseña.setBounds(x-60, y+430, tamBtn_ancho+120, 30);
				text_contraseña.setBounds(x-60, y+470, tamBtn_ancho+120, 30);
				
				
				btn_salida.setBounds(x-60, y+580,tamBtn_ancho-40 , 40);
				btn_guardar.setBounds(x+100, y+580,tamBtn_ancho-40 , 40);
		      
				
				// Establecer un tamaño preferido para el panel_2
				panel_registro.setPreferredSize(new Dimension(0, panel_ancho + y)); 
				panel_registro.revalidate();
		      
		    }
		});
		
		panel_registro.add(lbl_fecha);
		panel_registro.add(lbl_sexo);
		panel_registro.add(btn_salida);
		panel_registro.add(btn_guardar);
		panel_registro.add(text_apellidos);
		panel_registro.add(lbl_apellidos);
		panel_registro.add(text_nombre);
		panel_registro.add(lbl_nombre);
		panel_registro.add(lbl_titulo);
		panel_registro.add(calendario);
		panel_registro.add(btnRad_masculino);
		panel_registro.add(btnRad_femenino);
		panel_registro.add(lbl_discapacidad);
		panel_registro.add(text_discapacidad);
		panel_registro.add(lbl_correo);
		panel_registro.add(text_correo);
		panel_registro.add(lbl_Usuario);
		panel_registro.add(text_Usuario);
		panel_registro.add(lbl_contraseña);
		panel_registro.add(text_contraseña);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.WEST);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2, BorderLayout.EAST);
		
		Panel panel_centro = new Panel();
		panel_acceso.add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new BorderLayout(0, 0));
		
		Component vertical_norte = Box.createVerticalStrut(20);
		panel_centro.add(vertical_norte, BorderLayout.NORTH);
		
		Component vertical_Sur = Box.createVerticalStrut(20);
		panel_centro.add(vertical_Sur, BorderLayout.SOUTH);
		
		Component horizontal_este = Box.createHorizontalStrut(20);
		panel_centro.add(horizontal_este, BorderLayout.EAST);
		
		JPanel panel_imagen =new ImganenFondo("imagenes/imagenes_acceso/fondo_registro.png");
		panel_centro.add(panel_imagen, BorderLayout.CENTER);
		
		ventana.getContentPane().add(panel_acceso);
		ventana.setVisible(true); 
		ventana.repaint();
		ventana.revalidate(); 
		
	}
	
	public class ImganenFondo extends JPanel {

		private BufferedImage imagen;

		    public  ImganenFondo(String imagePath) {//constructor que carga la imagen
		        try {
		            imagen = ImageIO.read(new File(imagePath));
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }

		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        if (imagen != null) {
		            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		        }
		    }

		    @Override
		    public Dimension getPreferredSize() {
		        if (imagen != null) {
		            return new Dimension(imagen.getWidth(), imagen.getHeight());
		        }
		        return super.getPreferredSize();
		    }
		}
}