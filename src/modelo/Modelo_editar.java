package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public boolean actualizarDatosUsuario(String usuario, String nombre, String apellidos, Date fechaNacimiento, String sexo, String discapacidad, String correo) throws ClassNotFoundException, SQLException {
        boolean isUpdated = false;
        @SuppressWarnings("static-access")
		Connection con = sistema.getConexion();

        try {
            String query = "UPDATE usuarios SET nombre = ?, apellidos = ?, fecha_nacimiento = ?, sexo = ?, discapacidad = ?, correo = ? WHERE usuario = ?";
            PreparedStatement ps = con.prepareStatement(query);
            // Formato de fecha
            SimpleDateFormat formatoDatos = new SimpleDateFormat("dd-MM-yyyy");
            // Imprimir fecha antes de la actualización
            System.out.println("Fecha de Nacimiento Antes de Actualizar: " + formatoDatos.format(fechaNacimiento));
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setDate(3, new java.sql.Date(fechaNacimiento.getTime()));
            ps.setString(4, sexo);
            ps.setString(5, discapacidad);
            ps.setString(6, correo);
            ps.setString(7, usuario);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUpdated;
    }

}
