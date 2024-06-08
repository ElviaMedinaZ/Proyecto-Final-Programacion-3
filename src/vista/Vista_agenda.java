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
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;
import modelo.Modelo_agenda;

public class Vista_agenda {
	
	public JFrame ventana;
	public JPanel Panel_Principal;
	private Vista_utilidades utilidades;
	private Modelo_agenda sistema;

	public Vista_agenda() {

		sistema = new Modelo_agenda();
		utilidades = new Vista_utilidades();
		ventana = new JFrame();
		ventana.setBounds(10, 10, 1280, 720);
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imagenes/imagenes_acceso/logo App.png");
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_agenda(String usuario) {
		
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
				persona.vista_persona(usuario);
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnEntretenimento = utilidades.crearBotonesLaterales("Entretenimiento", "imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento(usuario);
				ventana.dispose();				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		 
		JButton btnAprendizaje =utilidades.crearBotonesLaterales("Aprendizaje", "imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje(usuario);
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
				persona.vista_persona(usuario);
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
		
		panel_central(usuario);
	}

	@SuppressWarnings("static-access")
	public void panel_central(String usuario) {
		
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
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
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
        
        List<Object[]> contactos;
        Object[][] datos = null;
        try {
			contactos = sistema.obtenerAgenda(usuario);
	        // Convertir la lista a un arreglo de Object[][]
			datos = new Object[contactos.size()][4];
	        for (int i = 0; i < contactos.size(); i++) {
	            datos[i] = contactos.get(i);
	        }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Nombre de las columnas
        String[] columnNames = {"id","evento", "fecha", "hora"};
        // Crear el modelo de la tabla con los datos y nombres de las columnas
        EditableTableModel model = new EditableTableModel(datos, columnNames);
        JTable table = new JTable(model);
        
        // Obtener el modelo de la tabla
        TableModel prueva = table.getModel();

        // Obtener el número total de columnas
        int columnCount = prueva.getColumnCount();

        // Iterar sobre las columnas para buscar la columna de fecha
        int indiceDeLaColumnaDeFecha = -1; // Inicializar con un valor que indique que la columna no se encontró
        for (int i = 0; i < columnCount; i++) {
            String nombreColumna = prueva.getColumnName(i);
            if (nombreColumna.equals("fecha")) { // Reemplaza "fecha" con el nombre real de tu columna de fecha
                indiceDeLaColumnaDeFecha = i; // Guardar el índice de la columna de fecha
                break; // Salir del bucle una vez que se encuentre la columna
            }
        }

        // Verificar si se encontró la columna de fecha
        if (indiceDeLaColumnaDeFecha != -1) {
            // Configurar el editor de celdas para la columna de fecha
            table.getColumnModel().getColumn(indiceDeLaColumnaDeFecha).setCellEditor(new DateCellEditor());
        } else {
            System.out.println("No se encontró la columna de fecha.");
        }
        
     // Iterar sobre las columnas para buscar la columna de hora
        int indiceDeLaColumnaDeHora = -1; // Inicializar con un valor que indique que la columna no se encontró
        for (int i = 0; i < columnCount; i++) {
            String nombreColumna = model.getColumnName(i);
            if (nombreColumna.equals("hora")) { // Reemplaza "hora" con el nombre real de tu columna de hora
                indiceDeLaColumnaDeHora = i; // Guardar el índice de la columna de hora
                break; // Salir del bucle una vez que se encuentre la columna
            }
        }

        // Verificar si se encontró la columna de hora
        if (indiceDeLaColumnaDeHora != -1) {
            // Configurar el editor de celdas para la columna de hora
            table.getColumnModel().getColumn(indiceDeLaColumnaDeHora).setCellEditor(new TimeCellEditor());
        } else {
            System.out.println("No se encontró la columna de hora.");
        }
        
        
        // Configurar el ancho de la columna "id" a 0
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
   
    
        // Crear un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
		
		
		
        JButton btn_crear = new JButton("CREAR");
        btn_crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String evento = text_evento.getText();
                Date fecha = calendario.getDate();
                Date date = (Date) spinnerModel.getValue();
                Time hora = new Time(date.getTime());
                
                if (!validarCampos(evento, fecha, hora) || !validarFechaHora(fecha, hora)) {
                    return;
                }
            	
            	int response =JOptionPane.showConfirmDialog(
                        null, 
                        "¿Deseas confirmar la operación?", 
                        "Eliminacion", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE
                );

                if (response == JOptionPane.YES_OPTION) {
                	 
                	 evento = text_evento.getText();
                     fecha = calendario.getDate();
                     date = (Date) spinnerModel.getValue();
                     hora = new Time(date.getTime());
                     
                     try {
						sistema.agregarContacto(usuario, evento, fecha, hora);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                   
                 	
                } else if (response == JOptionPane.NO_OPTION) {
                    return;
                } else {
                    return;
                }
            	
                Controlador_persona sistema = new Controlador_persona();
                sistema.vista_agenda(usuario);
                ventana.dispose();
            	

            }
        });
        btn_crear.setFocusable(false);
        btn_crear.setBackground(Color.decode("#00758E"));
        btn_crear.setForeground(Color.decode("#FFFFFF"));
        btn_crear.setFont(new Font("Tahoma", Font.BOLD, 18));
        
       
		
        JButton btn_eliminar = new JButton("ELIMINAR");
        
        btn_eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	int response =JOptionPane.showConfirmDialog(
                        null, 
                        "¿Deseas confirmar la operación?", 
                        "Eliminacion", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE
                );

                if (response == JOptionPane.YES_OPTION) {
                	 
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Obtener el id del contacto seleccionado
                        int id = (int) table.getValueAt(selectedRow, 0);
                        try {
                            // Llamar al método para borrar el contacto de la base de datos
                            if (sistema.borrarEventoPorId(id)) {
                            	
                                JOptionPane.showMessageDialog(null, "Evento eliminado exitosamente.");
                                
                                Controlador_persona sistema = new Controlador_persona();
                                sistema.vista_agenda(usuario);
                                ventana.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al eliminar el evento.");
                            }
                        } catch (ClassNotFoundException | SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al evento con la base de datos.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecciona un evento para eliminar.");
                    }
                	

                } else if (response == JOptionPane.NO_OPTION) {
                    return;
                } else {
                    return;
                }
            	
                Controlador_persona sistema = new Controlador_persona();
                sistema.vista_agenda(usuario);
                ventana.dispose();
            	
            }  
        });
        
        
        btn_eliminar.setFocusable(false);
        btn_eliminar.setBackground(Color.decode("#9E0000"));
        btn_eliminar.setForeground(Color.decode("#FFFFFF"));
        btn_eliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JButton btn_editar = new JButton("EDITAR");
        // Añadir un ListSelectionListener al modelo de selección de la tabla
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Esta verificación evita múltiples eventos
                    if (table.getSelectedRow() != -1) {
                        // Cambiar el color del botón cuando se selecciona una fila
                        btn_editar.setBackground(Color.decode("#00758E"));
                    } else {
                        // Revertir al color original si no hay ninguna fila seleccionada
                        btn_editar.setBackground(Color.decode("#686D6F"));
                    }
                }
            }
        });
        
      
        
        
        btn_editar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int selectedRow = table.getSelectedRow(); // Obtener la fila seleccionada en la tabla
                if (selectedRow != -1) {
                    if (btn_editar.getText().equals("EDITAR")) {
                        // Permitir la edición de la fila seleccionada
                    	model.setEditable(true);
                        // Editar la celda seleccionada
                        table.editCellAt(selectedRow, 1); // Ejemplo, editar la segunda columna
                        table.getEditorComponent().requestFocusInWindow();
                        btn_editar.setText("GUARDAR");
                        btn_eliminar.setEnabled(false); // Desactivar el botón de eliminar mientras se edita
                    } else if (btn_editar.getText().equals("GUARDAR")) 
                    {
                    	    	
                        // Finalizar la edición y actualizar el modelo
                    	 if (table.isEditing() && table.getCellEditor() != null) {
                             table.getCellEditor().stopCellEditing();
                         }
                        model.setEditable(false);
                        // Obtener los nuevos valores de los campos editados
                        String evento = (String) table.getValueAt(selectedRow, 1);
                        Date fecha = (Date) table.getValueAt(selectedRow, 2);
                        Time hora = (Time) table.getValueAt(selectedRow, 3);
                        String newhora = hora.toGMTString();

                        if(evento.length()<=0 || fecha==null || hora == null || hora.toString().trim().isEmpty())
                        {	
	                        JOptionPane.showMessageDialog(null, "los campos no pueden quedar vacios.");
	                        model.setEditable(true);
	                        table.editCellAt(selectedRow, 1);
	                        table.getEditorComponent().requestFocusInWindow();
	                       // table.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	                        return;
                        }
                        else
                        {
	                        // Obtener el ID del evento seleccionado en la tabla
	                        int id = (int) prueva.getValueAt(selectedRow, 0);
	                        
		                        // Actualizar el evento en la base de datos
		                        try {
		                            if (sistema.actualizarEvento(id, evento, fecha, hora)) {
		                                JOptionPane.showMessageDialog(null, "Evento actualizado exitosamente.");
		                                Controlador_persona sistema = new Controlador_persona();
		                                sistema.vista_agenda(usuario);
		                                ventana.dispose();
		                            } else {
		                                JOptionPane.showMessageDialog(null, "Error al actualizar el evento.");
		                            }
		                        } catch (ClassNotFoundException | SQLException ex) {
		                            ex.printStackTrace();
		                            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
		                        }
                        
                        }

                        // Restaurar el botón "EDITAR" a su estado original
                        btn_editar.setText("EDITAR");
                        btn_editar.setBackground(Color.decode("#686D6F"));
                        btn_eliminar.setEnabled(true); // Reactivar el botón de eliminar
                	}
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un evento de la tabla para editarlo.");
                }
            }
        });
        btn_editar.setFocusable(false);
        btn_editar.setBackground(Color.decode("#686D6F"));
        btn_editar.setForeground(Color.decode("#FFFFFF"));
        btn_editar.setFont(new Font("Tahoma", Font.BOLD, 18));

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
	
	
	public boolean validarCampos(String evento, Date fecha, Date hora) {
	    if (evento == null || evento.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "El campo Evento no puede quedar vacio");
	        return false;
	    }
	    if (fecha == null) {
	        JOptionPane.showMessageDialog(null, "El campo  fecha  no puede quedar vacio.");
	        return false;
	    }
	    if (hora == null) {
	        JOptionPane.showMessageDialog(null, "El campo  hora no puede estar vacio");
	        return false;
	    }
	    return true;
	}
	

	public boolean validarFechaHora(Date fecha, Date hora) {
	    Date actual = new Date();
	    if (fecha.after(actual)) {
	        JOptionPane.showMessageDialog(null, "La fecha no puede ser menor a la actual");
	        return false;
	    }
	    if (fecha.equals(actual) && hora.after(actual)) {
	        JOptionPane.showMessageDialog(null, "La hora no puede ser anterior a la hora actual");
	        return false;
	    }
	    return true;
	}

}