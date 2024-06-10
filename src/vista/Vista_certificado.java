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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import controlador.Controlador_acceso;
import controlador.Controlador_aprendizaje;
import controlador.Controlador_entretenimiento;
import controlador.Controlador_persona;
import modelo.Modelo_certificado;
import modelo.Modelo_pdf;

public class Vista_certificado {
	
	public JFrame ventana;
	public JPanel Panel_Principal;
	private Vista_utilidades utilidades;
	private Modelo_certificado sistema;

	public Vista_certificado() {
		// TODO Auto-generated constructor stub
		sistema = new Modelo_certificado();
		utilidades = new Vista_utilidades();
		ventana = new JFrame();
		ventana.setBounds(10, 10, 1280, 720);
        ventana.setVisible(false);
        ventana.setTitle("Headway Assist");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagenes_acceso/logo App.png"));
        ventana.setIconImage(icon.getImage());
	}
	
	public void vista_certificado(String usuario) {
		
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
		JButton btnPersonal =utilidades.crearBotonesLaterales("Personal", "/imagenes/img_principal/btn_persona.png", iconWidth, tamHei, fontSize, iconWidth);
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona(usuario);
				ventana.dispose();
			}
		});
		btnPersonal.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnEntretenimento = utilidades.crearBotonesLaterales("Entretenimiento", "/imagenes/img_principal/btn_entretenimento.png", iconWidth, tamHei, fontSize, iconWidth);
		btnEntretenimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_entretenimiento sistema = new Controlador_entretenimiento();
				sistema.vista_entretenimiento(usuario);
				ventana.dispose();				
			}
		});
		btnEntretenimento.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		 
		JButton btnAprendizaje =utilidades.crearBotonesLaterales("Aprendizaje", "/imagenes/img_principal/btn_aprendizaje.png", iconWidth, tamHei, fontSize, iconWidth);
		btnAprendizaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_aprendizaje sistema = new Controlador_aprendizaje();
				sistema.vista_aprendizaje(usuario);
				ventana.dispose();
			}
		});
		btnAprendizaje.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnRegresar =utilidades.crearBotonesLaterales("Regresar", "/imagenes/img_principal/flecha_regresar.png", iconWidth, tamHei, fontSize, iconWidth);
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
				Controlador_persona persona = new Controlador_persona();
				persona.vista_persona(usuario);
				ventana.dispose();
			}
		});
		btnRegresar.setPreferredSize(new Dimension(tamWid, tamHei)); // Ajustar tamaño del boton
		
		JButton btnCerrar_sesion = utilidades.crearBotonesLaterales("Cerrar sesíon", "/imagenes/img_principal/btn_salir.png", iconWidth, tamHei, fontSize, iconWidth);
		btnCerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilidades.playSound("/sonidos/btn_generico.wav");
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
		
		if(sistema.archivoExiste(usuario)) {
			panel_pre(usuario);
		}
		else {
			panel_central(usuario);
		}
	}
	
	private void panel_pre(String usuario) {
		
		JPanel panel_contacto = new JPanel();
		panel_contacto.setBackground(Color.decode("#F1F1F1"));
		panel_contacto.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("CERTIFICADO");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		
		
        JButton btn_Descargar = new JButton("DESCARGAR");
        btn_Descargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            	Modelo_pdf pdfData = sistema.obtenerPDFYNombrePorUsuario(usuario);

            	if (pdfData != null) {
            	    InputStream pdfStream = pdfData.getArchivoStream();
            	    String nombreArchivo = pdfData.getNombre();
            	    File outputFile = new File(System.getProperty("user.home") + "/Downloads/" + nombreArchivo);
            	    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            	        byte[] buffer = new byte[1024];
            	        int bytesRead;
            	        while ((bytesRead = pdfStream.read(buffer)) != -1) {
            	            fos.write(buffer, 0, bytesRead);
            	        }
            	    } catch (IOException e1) {
            	        System.out.println("Error al guardar el archivo: " + e1.getMessage());
            	    }
            	} else {
            	    System.out.println("No se encontró el archivo PDF para el usuario especificado.");
            	} 
            }
        });
        btn_Descargar.setFocusable(false);
        btn_Descargar.setBackground(Color.decode("#00758E"));
        btn_Descargar.setForeground(Color.decode("#FFFFFF"));
        btn_Descargar.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JButton btn_Eliminar = new JButton("ELIMINAR");
        btn_Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            	 int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el archivo?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                 if (confirm == JOptionPane.YES_OPTION) {
                     boolean success = sistema.eliminarArchivoPorUsuario(usuario);
                     if (success) {
                        JOptionPane.showMessageDialog(null, "Archivo eliminado exitosamente.");
                 		Controlador_persona sistema = new Controlador_persona();
                 		sistema.vista_certificado(usuario);
                 		ventana.dispose();
                     } else {
                         JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo.");
                     }
                 }

            }
        });
        btn_Eliminar.setFocusable(false);
        btn_Eliminar.setBackground(Color.decode("#9E0000"));
        btn_Eliminar.setForeground(Color.decode("#FFFFFF"));
        btn_Eliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		
        InputStream pdfStream = sistema.obtenerPDFPorUsuario(usuario);
        
        JPanel pdf = getPDFPanel(pdfStream,390,450);
        



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
		        


		        pdf.setBounds(x/4, y/2, tamBtn_ancho+200, 450);
				lbl_titulo.setBounds(x-60, y-310 , tamBtn_ancho+120, 120);
				btn_Descargar.setBounds(x+250, y-150, tamBtn_ancho, 50);
				btn_Eliminar.setBounds(x+250, y-70,tamBtn_ancho , 50);
				
			
				// Establecer un tamaño preferido para el panel_2
				panel_contacto.setPreferredSize(new Dimension(0, panel_ancho + y)); 
				panel_contacto.revalidate();
		      
		    }
		});
		
		panel_contacto.add(pdf);
		panel_contacto.add(btn_Eliminar);
		panel_contacto.add(btn_Descargar);
		panel_contacto.add(lbl_titulo);
		
		
		
		Panel_Principal.add(panel_contacto, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
		
		// TODO Auto-generated method stub
		
	}

	public void panel_central(String usuario) {
		
		JPanel panel_contacto = new JPanel();
		panel_contacto.setBackground(Color.decode("#F1F1F1"));
		panel_contacto.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("SUBIR ARCHIVO");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel ibl_img = new JLabel();
		ibl_img.setIcon(new ImageIcon(getClass().getResource("/imagenes/imagenes_acceso/subir_archivo.png")));
		
        JButton btn_crear = new JButton("Seleccionar un archivo");
        btn_crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// Crear un objeto JFileChooser
                JFileChooser fileChooser = new JFileChooser();
                // Limitar la selección a archivos PDF
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", "pdf");
                fileChooser.setFileFilter(filter);
                
                // Mostrar el diálogo para seleccionar un archivo
                int result = fileChooser.showOpenDialog(null);
                
               
                if (result == JFileChooser.APPROVE_OPTION) {
             
                    File selectedFile = fileChooser.getSelectedFile();
                    // Verificar si es un archivo PDF
                    if (selectedFile.getName().toLowerCase().endsWith(".pdf")) {
                    	
                    	//preguntamos para verificar si quiere registrarse 
                    	int response =JOptionPane.showConfirmDialog(
                                null, 
                                "¿Deseas confirmar la operación?", 
                                "", 
                                JOptionPane.YES_NO_OPTION, 
                                JOptionPane.WARNING_MESSAGE
                        );

                        if (response == JOptionPane.YES_OPTION) {
                        	 
                        	boolean cargar = sistema.insertarPDF(usuario, selectedFile);
                        	
                        	
                        	
                        	if(cargar) {
                        		JOptionPane.showMessageDialog(null, "Archivo subido exitosamente.");
                        		Controlador_persona sistema = new Controlador_persona();
                        		sistema.vista_certificado(usuario);
                        		ventana.dispose();
                        		
                        	}
                        	else {
                        		JOptionPane.showMessageDialog(null, "Error con el erchivo.");
                        	}
                        	

                        } else if (response == JOptionPane.NO_OPTION) {
                            return;
                        } else {
                            return;
                        }
                    	
                    } else {
                        // Si no es un archivo PDF, mostrar un mensaje de error
                        JOptionPane.showMessageDialog(null, "Por favor, selecciona un archivo PDF válido.");
                    }
                }

            }
        });
        btn_crear.setFocusable(false);
        btn_crear.setBackground(Color.decode("#C3C3C3"));
        btn_crear.setForeground(Color.decode("#000000"));
        btn_crear.setFont(new Font("Tahoma", Font.BOLD, 20));
        
       
		
       

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
		        


		   
				lbl_titulo.setBounds(x-80, y-310 , tamBtn_ancho+190, 120);
				ibl_img.setBounds(x-50, y-250, tamBtn_ancho*2, 400);
				btn_crear.setBounds(x-100, y+100,tamBtn_ancho+190 , 30);
				
			
				// Establecer un tamaño preferido para el panel_2
				panel_contacto.setPreferredSize(new Dimension(0, panel_ancho + y)); 
				panel_contacto.revalidate();
		      
		    }
		});
		
		
		panel_contacto.add(btn_crear);
		panel_contacto.add(ibl_img);
		panel_contacto.add(lbl_titulo);
		
		
		
		Panel_Principal.add(panel_contacto, BorderLayout.CENTER);
		ventana.setVisible(true);
		ventana.repaint();
		ventana.revalidate();
		
	}

	public static JPanel getPDFPanel(InputStream pdfStream, int panelWidth, int panelHeight) {
		 JPanel panel = new JPanel();
		    try {
		        PDDocument document = PDDocument.load(pdfStream);
		        PDFRenderer renderer = new PDFRenderer(document);
		        BufferedImage image = renderer.renderImageWithDPI(0, 144); // Renderiza la primera página

		        // Escala la imagen al tamaño del panel
		        Image scaledImage = image.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
		        ImageIcon icon = new ImageIcon(scaledImage);
		        JLabel label = new JLabel(icon);
		        
		        // Configuracion del panel y escala
		        panel.setLayout(new BorderLayout());
		        panel.add(label, BorderLayout.CENTER);

		        document.close(); // Cerrar el documento
		    } catch (Exception e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al cargar el PDF", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		    return panel;
	    }
	
}