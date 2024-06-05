package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;

public class Vista_editar {
	
	public JFrame ventana;
	public JPanel Panel_Principal;
	private Vista_utilidades utilidades;

	public Vista_editar() {
		// TODO Auto-generated constructor stub
		utilidades = new Vista_utilidades();
		ventana = new JFrame();
		ventana.setBounds(10, 10, 1280, 720);
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_editar() {
		
		Panel_Principal = new JPanel();
		
		Panel_Principal.setBackground(Color.decode("#00758E"));
			
		ventana.getContentPane().add(Panel_Principal);
		Panel_Principal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		Panel_Principal.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 20, 10));
			
		// Crear paneles con GridBagLayout para centrar los botones
		JPanel panel_personal = new JPanel(new GridBagLayout());
		JPanel panel_entretener = new JPanel(new GridBagLayout());
		JPanel panel_aprender = new JPanel(new GridBagLayout());
		JPanel panel_regresar = new JPanel(new GridBagLayout());
		JPanel panel_cerrar_sesion = new JPanel(new GridBagLayout());
		
		panel_personal.setOpaque(false);
		panel_entretener.setOpaque(false);
		panel_aprender.setOpaque(false);
		panel_regresar.setOpaque(false);
		panel_cerrar_sesion.setOpaque(false);
		
		int tamWid = 300;
		int tamHei = 90;
		int iconWidth = (int) (tamHei * 0.7); // Aumentar un 70% el ancho del icono
		int fontSize = 19;
		
		// Crear botones con tama�o preferido
		JButton btnPersonal =utilidades.crearBotonesLaterales("Personal", "imagenes/img_principal/btn_persona.png", iconWidth, tamHei, fontSize, iconWidth);
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona();
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnEntretenimento = utilidades.crearBotonesLaterales("Entretenimiento", "imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento();
				ventana.dispose();				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		 
		JButton btnAprendizaje =utilidades.crearBotonesLaterales("Aprendizaje", "imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje();
				ventana.dispose();
			}
		});
		btnAprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnRegresar =utilidades.crearBotonesLaterales("Regresar", "imagenes/img_principal/flecha_regresar.png", iconWidth, tamHei, fontSize, iconWidth);
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona();
				ventana.dispose();
			}
		});
		btnRegresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		JButton btnCerrar_sesion = utilidades.crearBotonesLaterales("Cerrar ses�on", "imagenes/img_principal/btn_salir.png", iconWidth, tamHei, fontSize, iconWidth);
		btnCerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_acceso sistema = new Controlador_acceso();
				sistema.vista_acceso();
				ventana.dispose();
			}
		});
		btnCerrar_sesion.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tama�o del boton
		
		//paneles para los botones
		panel.add(panel_personal);
		panel.add(panel_entretener);
		panel.add(panel_aprender);
		panel.add(panel_regresar);
		panel.add(panel_cerrar_sesion);
		
		// Configurar GridBagConstraints para centrar los botones verticalmente
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 20, 0, 20); // A�adir separacion a los lados
		
		// A�adir los botones a los paneles centrados
		panel_personal.add(btnPersonal, gbc);
		panel_entretener.add(btnEntretenimento, gbc);
		panel_aprender.add(btnAprendizaje, gbc);
		panel_regresar.add(btnRegresar, gbc);
		panel_cerrar_sesion.add(btnCerrar_sesion,gbc);
		
		panel_central();
	}
	
	public void panel_central() {
		
		JPanel panel_editar = new JPanel();
		panel_editar.setBackground(Color.decode("#F1F1F1"));
		panel_editar.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("EDITAR PERFIL");
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
		
        JButton btn_cancelar = new JButton("CANCELAR");
        btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Controlador_acceso sistema = new Controlador_acceso();
            	sistema.vista_acceso();
            	ventana.dispose();

            }
        });
        btn_cancelar.setFocusable(false);
        btn_cancelar.setBackground(Color.decode("#686D6F"));
        btn_cancelar.setForeground(Color.decode("#FFFFFF"));
        btn_cancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		
        JButton btn_guardar = new JButton("REGISTRAR");
        
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
		    	
		    	int tamBtn_ancho = 190;
		    	//conseguimos las dimensiones con las que terminara el panel
		       
		    	Dimension panelSize = panel_editar.getSize();
		       
		        //guardamos posiciones
		        int panel_ancho = panelSize.width;
		        int panel_alto = panelSize.height;     
		        
		        //logramos posicionar en el centro usando el tama�o de los botones ya definidos y las medidas conseguidas 
		        int x = (panel_ancho - tamBtn_ancho) / 2;
		        int y = panel_alto/2;
		        

		    	// Establecer un tama�o preferido para el panel_2
		        panel_editar.setPreferredSize(new Dimension(0, panel_alto + y)); 
		        panel_editar.revalidate();
		   
		  
				lbl_titulo.setBounds(x-70, y-310 , tamBtn_ancho+140, 120);
				
				lbl_nombre.setBounds(x/3, y-170 , tamBtn_ancho+20, 40);
				text_nombre.setBounds(x/3, y-130, tamBtn_ancho+120, 30);
				
				lbl_discapacidad.setBounds(x+100, y-170 , tamBtn_ancho+100, 40);
				text_discapacidad.setBounds(x+100, y-130, tamBtn_ancho+120, 30);
				
				lbl_apellidos.setBounds(x/3, y-90 , tamBtn_ancho , 40);
				text_apellidos.setBounds(x/3,y-50, tamBtn_ancho+120, 30);
			
				lbl_correo.setBounds(x+100, y-90 , tamBtn_ancho+100, 40);
				text_correo.setBounds(x+100, y-50, tamBtn_ancho+120, 30);
				
				lbl_fecha.setBounds(x/3,y, tamBtn_ancho+120, 30);
				calendario.setBounds(x/3,y+40, tamBtn_ancho-40, 30);
				
				
				lbl_sexo.setBounds(x/3, y+90, tamBtn_ancho+20, 40);
				btnRad_masculino.setBounds(x/3, y+150, tamBtn_ancho-50, 20);
				btnRad_femenino.setBounds(x-100, y+150, tamBtn_ancho-50, 20);
				

				
				
				btn_cancelar.setBounds(x+20, y+250,tamBtn_ancho-40 , 50);
				btn_guardar.setBounds(x+240, y+250,tamBtn_ancho-40 , 50);
		      
				
				// Establecer un tama�o preferido para el panel_2
				panel_editar.setPreferredSize(new Dimension(0, panel_ancho + y)); 
				panel_editar.revalidate();
		      
		    }
		});
		
		panel_editar.add(lbl_fecha);
		panel_editar.add(lbl_sexo);
		panel_editar.add(btn_cancelar);
		panel_editar.add(btn_guardar);
		panel_editar.add(text_apellidos);
		panel_editar.add(lbl_apellidos);
		panel_editar.add(text_nombre);
		panel_editar.add(lbl_nombre);
		panel_editar.add(lbl_titulo);
		panel_editar.add(calendario);
		panel_editar.add(btnRad_masculino);
		panel_editar.add(btnRad_femenino);
		panel_editar.add(lbl_discapacidad);
		panel_editar.add(text_discapacidad);
		panel_editar.add(lbl_correo);
		panel_editar.add(text_correo);

		
		
		Panel_Principal.add(panel_editar, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
		
	}
}
