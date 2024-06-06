package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo_editar {
	
	private Conexion_db sistema;

	public Modelo_editar() {
		// TODO Auto-generated constructor stub
		sistema = new Conexion_db();	
	}
	
	@SuppressWarnings("static-access")//evita quen salgan advertencias
	public Modelo_usuario obtenerDatosUsuario(String usuario) throws ClassNotFoundException, SQLException {//metodo para obtener los datos del usuario 
       
		Modelo_usuario  datosUsuario = null;//creamos el objeto usuario
        Connection con = sistema.getConexion();
        
        try {
            String query = "SELECT nombre, apellidos, fecha_nacimiento, sexo, discapacidad, correo FROM usuarios WHERE usuario = ?";//usamos el query para hacer la consulta
            PreparedStatement ps = con.prepareStatement(query);//hace la consulta
            ps.setString(1, usuario);//primer parametro de la consulta
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                datosUsuario = new Modelo_usuario ();//creamos un nuevo usuario
                datosUsuario.setNombre(rs.getString("nombre"));// se establece el valor recuperado de la base de datos 
                datosUsuario.setApellidos(rs.getString("apellidos"));
                datosUsuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                datosUsuario.setSexo(rs.getString("sexo"));
                datosUsuario.setDiscapacidad(rs.getString("discapacidad"));
                datosUsuario.setCorreo(rs.getString("correo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();//cerramos la conexion
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return datosUsuario;//devolvemos el objeto de usuario con los datos obtenidos de la base de datos
    }

}
