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
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;

public class Vista_agenda {
	
	public JFrame ventana;
	public JPanel Panel_Principal;
	private Vista_utilidades utilidades;

	public Vista_agenda() {
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
	
	public void vista_agenda() {
		
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
		
		// Crear botones con tamaño preferido
		JButton btnPersonal =utilidades.crearBotonesLaterales("Personal", "imagenes/img_principal/btn_persona.png", iconWidth, tamHei, fontSize, iconWidth);
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona();
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnEntretenimento = utilidades.crearBotonesLaterales("Entretenimiento", "imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento();
				ventana.dispose();				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		 
		JButton btnAprendizaje =utilidades.crearBotonesLaterales("Aprendizaje", "imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje();
				ventana.dispose();
			}
		});
		btnAprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
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
		btnRegresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnCerrar_sesion = utilidades.crearBotonesLaterales("Cerrar sesíon", "imagenes/img_principal/btn_salir.png", iconWidth, tamHei, fontSize, iconWidth);
		btnCerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_acceso sistema = new Controlador_acceso();
				sistema.vista_acceso();
				ventana.dispose();
			}
		});
		btnCerrar_sesion.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
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
		gbc.insets = new Insets(0, 20, 0, 20); // Añadir separacion a los lados
		
		// Añadir los botones a los paneles centrados
		panel_personal.add(btnPersonal, gbc);
		panel_entretener.add(btnEntretenimento, gbc);
		panel_aprender.add(btnAprendizaje, gbc);
		panel_regresar.add(btnRegresar, gbc);
		panel_cerrar_sesion.add(btnCerrar_sesion,gbc);
		
		panel_central();
	}

	@SuppressWarnings("static-access")
	public void panel_central() {
		
		JPanel panel_contacto = new JPanel();
		panel_contacto.setBackground(Color.decode("#F1F1F1"));
		panel_contacto.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("AGENDA");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lbl_evento = new JLabel("Evento");
		lbl_evento.setFont(new Font("Tahoma", Font.BOLD, 20));
		JTextField text_evento = new JTextField();
		utilidades.limitar_textfield(text_evento, 30); // NOTA: revicion completada
		text_evento.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));

		
		
		JLabel lbl_numero = new JLabel("Fecha");
		lbl_numero.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		
        JLabel lbl_relacion = new JLabel("Hora");
        lbl_relacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		
        // Crear un Spinner para la hora
        SpinnerDateModel spinnerModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(spinnerModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "hh:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(Calendar.getInstance().getTime());
        timeSpinner.setBorder(BorderFactory.createLineBorder(Color.decode("#00758E"), 2));
		
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
        
		//creacion de tabla 
		Object[][] datos = {};
		// Nombre de las columnas
        String[] columnNames = {"Evento", "Fecha", "Hora"};
        // Crear el modelo de la tabla con los datos y nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(datos, columnNames);
        // Crear la tabla
        JTable table = new JTable(model);
        // Crear un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
		
		
		
        JButton btn_crear = new JButton("CREAR");
        btn_crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	

            }
        });
        btn_crear.setFocusable(false);
        btn_crear.setBackground(Color.decode("#00758E"));
        btn_crear.setForeground(Color.decode("#FFFFFF"));
        btn_crear.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JButton btn_editar = new JButton("EDITAR");
        btn_editar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	
            }
        });
        btn_editar.setFocusable(false);
        btn_editar.setBackground(Color.decode("#686D6F"));
        btn_editar.setForeground(Color.decode("#FFFFFF"));
        btn_editar.setFont(new Font("Tahoma", Font.BOLD, 18));
		
        JButton btn_eliminar = new JButton("ELIMINAR");
        
        btn_eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }  
        });
        
        
        btn_eliminar.setFocusable(false);
        btn_eliminar.setBackground(Color.decode("#9E0000"));
        btn_eliminar.setForeground(Color.decode("#FFFFFF"));
        btn_eliminar.setFont(new Font("Tahoma", Font.BOLD, 18));

		ventana.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentShown(ComponentEvent e) {
		    	
		    	int tamBtn_ancho = 190;
		    	//conseguimos las dimensiones con las que terminara el panel
		       
		    	Dimension panelSize = panel_contacto.getSize();
		       
		        //guardamos posiciones
		        int panel_ancho = panelSize.width;
		        int panel_alto = panelSize.height;     
		        
		        //logramos posicionar en el centro usando el tamaño de los botones ya definidos y las medidas conseguidas 
		        int x = (panel_ancho - tamBtn_ancho) / 2;
		        int y = panel_alto/2;
		        

		    	// Establecer un tamaño preferido para el panel_2
		        panel_contacto.setPreferredSize(new Dimension(0, panel_alto + y)); 
		        panel_contacto.revalidate();
		   
				lbl_titulo.setBounds(x, y-310 , tamBtn_ancho+120, 120);
				
				lbl_evento.setBounds(x/3, y-170 , tamBtn_ancho+20, 40);
				text_evento.setBounds(x/3, y-130, tamBtn_ancho, 30);
				
				lbl_numero.setBounds(x-20, y-170 , tamBtn_ancho+100, 40);
				calendario.setBounds(x-20, y-130, tamBtn_ancho, 30);
				
				lbl_relacion.setBounds(x+200, y-170 , tamBtn_ancho , 40);
				timeSpinner.setBounds(x+200,y-130, tamBtn_ancho-80, 30);
			
				scrollPane.setBounds(x/3, y-70, tamBtn_ancho+450, 180);
				
				
				btn_crear.setBounds(x/3, y+250,tamBtn_ancho-40 , 50);
				btn_editar.setBounds(x-10, y+250,tamBtn_ancho-40 , 50);
				btn_eliminar.setBounds(x+220, y+250,tamBtn_ancho-40 , 50);
		      
			
				// Establecer un tamaño preferido para el panel_2
				panel_contacto.setPreferredSize(new Dimension(0, panel_ancho + y)); 
				panel_contacto.revalidate();
		      
		    }
		});
		
		panel_contacto.add(lbl_relacion);
		panel_contacto.add(lbl_numero);
		panel_contacto.add(btn_crear);
		panel_contacto.add(btn_eliminar);
		panel_contacto.add(btn_editar);
		panel_contacto.add(timeSpinner);
		panel_contacto.add(text_evento);
		panel_contacto.add(lbl_evento);
		panel_contacto.add(lbl_titulo);
		panel_contacto.add(scrollPane);
		panel_contacto.add(calendario);

		
		
		Panel_Principal.add(panel_contacto, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
		
	}

}
