package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo_certificado {
	
	private Conexion_db sistema ;
	
	public Modelo_certificado () {
		sistema = new Conexion_db();
	}
	
	 @SuppressWarnings("static-access")
	public boolean insertarPDF(String usuario, File archivoPDF) {
	        boolean exito = false;
	        Connection conexion = null;
	        PreparedStatement statement = null;
	        FileInputStream inputStream = null;
	        
	        try {
	            
	            conexion = sistema.getConexion();
	            String sql = "INSERT INTO archivos_pdf (usuario, nombre, archivo) VALUES (?, ?, ?)";
	            statement = conexion.prepareStatement(sql);
	            statement.setString(1, usuario);
	            statement.setString(2, archivoPDF.getName());
	            inputStream = new FileInputStream(archivoPDF);
	            statement.setBinaryStream(3, inputStream, (int) archivoPDF.length());
	            int row = statement.executeUpdate();
	            // Comprobar si la inserci�n fue exitosa
	            if (row > 0) {
	                exito = true;
	            }
	        } catch (SQLException | FileNotFoundException | ClassNotFoundException e) {
	            e.printStackTrace();
	            // Manejar cualquier excepci�n ocurrida durante la inserci�n
	        } finally {
	            // Cerrar los recursos (Statement, Connection, InputStream)
	            try {
	                if (inputStream != null) {
	                    inputStream.close();
	                }
	                if (statement != null) {
	                    statement.close();
	                }
	                if (conexion != null) {
	                    conexion.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        
	        return exito;
	    }
	 
	 public boolean archivoExiste(String usuario){
	        String sql = "SELECT COUNT(*) FROM archivos_pdf WHERE usuario = ?";
	        try (@SuppressWarnings("static-access")
			Connection conn = sistema.getConexion();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	               pstmt.setString(1, usuario);
	               ResultSet rs = pstmt.executeQuery();
	               if (rs.next()) {
	                   return rs.getInt(1) > 0; // Retorna true si hay al menos un archivo subido por el usuario
	               }
	           } catch (SQLException e) {
	               System.out.println("Error al verificar la existencia del archivo: " + e.getMessage());
	           } catch (ClassNotFoundException e1) {
			
				e1.printStackTrace();
			}
	           return false;
	 	}
	 
	 public InputStream obtenerPDFPorUsuario(String usuario) {
	        String sql = "SELECT archivo FROM archivos_pdf WHERE usuario = ?";
	        InputStream archivoStream = null;
	        try (@SuppressWarnings("static-access")
			Connection conn = sistema.getConexion();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, usuario);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                archivoStream = rs.getBinaryStream("archivo");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener el PDF: " + e.getMessage());
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        return archivoStream; // Retorna el InputStream del PDF, o null si no se encuentra
	    }
	 
	 public boolean eliminarArchivoPorUsuario(String usuario) {
	        String sql = "DELETE FROM archivos_pdf WHERE usuario = ?";
	        try (@SuppressWarnings("static-access")
			Connection conn = sistema.getConexion(); 
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, usuario);
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
	    }
	 
	 public Modelo_pdf obtenerPDFYNombrePorUsuario(String usuario) {
		    String sql = "SELECT nombre, archivo FROM archivos_pdf WHERE usuario = ?";
		    try (@SuppressWarnings("static-access")
			Connection conn = sistema.getConexion();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        pstmt.setString(1, usuario);
		        ResultSet rs = pstmt.executeQuery();
		        if (rs.next()) {
		            String nombre = rs.getString("nombre");
		            InputStream archivoStream = rs.getBinaryStream("archivo");
		            return new Modelo_pdf(nombre, archivoStream);
		        }
		    } catch (SQLException e) {
		        System.out.println("Error al obtener el PDF y nombre: " + e.getMessage());
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
		    return null; // Retorna null si no se encuentra el archivo o si hay un error
		}
}
