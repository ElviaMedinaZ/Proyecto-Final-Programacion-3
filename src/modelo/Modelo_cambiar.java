package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo_cambiar {
	
	private Conexion_db sistema;

	public Modelo_cambiar() {
		// TODO Auto-generated constructor stub
		sistema = new Conexion_db();
	}
	
	 // M�todo para verificar si un usuario ya existe en la base de datos
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
	
	// M�todo para cambiar la contrase�a del usuario
    public boolean cambiarContrasena(String usuario, String nuevaContrasena) throws ClassNotFoundException {
        String sql = "UPDATE usuarios SET contrasena = ? WHERE usuario = ?";
        try {
            @SuppressWarnings("static-access")
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
