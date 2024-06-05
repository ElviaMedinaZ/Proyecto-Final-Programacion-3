package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Modelo_contactos {

	private Conexion_db sistema;
	
	public Modelo_contactos() {
		// TODO Auto-generated constructor stub
		sistema = new Conexion_db();
	}
	
	public List<Object[]> obtenerContactos(String usuario) throws ClassNotFoundException, SQLException {//metodo para obtener los contactos de un usuario
        List<Object[]> listaContactos = new ArrayList<>();
        @SuppressWarnings("static-access")//evita que salgan advertencias
		Connection con = sistema.getConexion();
        
        try {
            String query = "SELECT nombre, numero, relacion FROM contactos WHERE usuario = ?";//usamos el query para hacer la consulta
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);//primer parametro de la consulta
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] contacto = new Object[3];
                contacto[0] = rs.getString("nombre");//obtenemos el nombre
                contacto[1] = rs.getString("numero");//obtenemos el numero
                contacto[2] = rs.getString("relacion");//obtenemos la relacion
                listaContactos.add(contacto);
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
        
        return listaContactos;//devuelve el nombre, numero y relacion 
    }

}
