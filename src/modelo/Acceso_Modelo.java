package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class Acceso_Modelo {

	private ConexionDB sistema;
	
	//aqui va la conexi�n a la base de datos
	public Acceso_Modelo() {
		// TODO Auto-generated constructor stub
		sistema = new ConexionDB();
	}
	
	public boolean login(String usuario,String contrasena) {
		
		try {
			Connection com = sistema.getConexion();
			Statement iniciar = com.createStatement() ;
			ResultSet rs = iniciar.executeQuery("SELECT * FROM user WHERE nombre = '" + usuario + "' AND contrase�a = '" + contrasena + "'");
			
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
