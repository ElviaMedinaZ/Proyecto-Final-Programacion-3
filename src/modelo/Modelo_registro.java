package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Modelo_registro {
	
	private Conexion_db sistema;

	public Modelo_registro() {
		// TODO Auto-generated constructor stub
		sistema = new Conexion_db();
	}
	
	 // Método para verificar si un usuario ya existe en la base de datos
    public boolean verificarUsuarioExistente(String usuario) {
        try (@SuppressWarnings("static-access")
		Connection con = sistema.getConexion();
             PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE usuario = ?")) {
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Método para guardar un nuevo registro de usuario en la base de datos
    public boolean guardarRegistro(String nombre, String apellidos, Date fechaNacimiento, String sexo,
                                    String discapacidad, String correo, String usuario, String contrasena) {
        try (@SuppressWarnings("static-access")
		Connection con = sistema.getConexion();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO usuarios (nombre, apellidos, fecha_nacimiento, sexo, discapacidad, correo, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setDate(3, new java.sql.Date(fechaNacimiento.getTime()));
            stmt.setString(4, sexo);
            stmt.setString(5, discapacidad);
            stmt.setString(6, correo);
            stmt.setString(7, usuario);
            stmt.setString(8, contrasena);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
