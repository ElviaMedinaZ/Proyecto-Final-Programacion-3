package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Modelo_acceso {

	private Conexion_db sistema;
	
	//aqui va la conexi�n a la base de datos
	public Modelo_acceso() {
		// TODO Auto-generated constructor stub
		sistema = new Conexion_db();
	}
	
	@SuppressWarnings("static-access")
	public boolean get_validacion_acceso(String usuario,String contrasena) {
		
		try {
			Connection com = sistema.getConexion();
			Statement iniciar = com.createStatement() ;
			ResultSet rs = iniciar.executeQuery("SELECT * FROM usuarios WHERE usuario = '" + usuario + "' AND contrasena = '" + contrasena + "'");
			
			if(rs.next()) {
				com.close();
				return true;
			}
			else {
				com.close();
				return false;
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Driver no encontrados:" + e.getMessage());
		}catch (SQLException e) {
			System.out.println("Error de conexion:"+e.getMessage());
		}
		return false;	
		
	}

}
