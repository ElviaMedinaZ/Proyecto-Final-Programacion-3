package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modelo_cambiar {
	
	private Conexion_db sistema;

	public Modelo_cambiar() {
		// TODO Auto-generated constructor stub
		sistema = new Conexion_db();
	}
	
	// Método para cambiar la contraseña del usuario
    public boolean cambiarContraseña(String usuario, String nuevaContrasena) throws ClassNotFoundException {
        String sql = "UPDATE usuarios SET contrasena = ? WHERE usuario = ?";
        try {
            PreparedStatement stmt = sistema.getConexion().prepareStatement(sql);
            stmt.setString(1, nuevaContrasena);
            stmt.setString(2, usuario);
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
