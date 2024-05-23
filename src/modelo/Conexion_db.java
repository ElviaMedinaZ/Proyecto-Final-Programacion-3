package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_db {
	
	private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_trabajo?serverTimezone=UTC";
    private static final String USERNAME = "freedb_kris12";
    private static final String PASSWORD = "@hAh6K*Vk#Q*acS";
	
	public static Connection getConexion() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}

}
