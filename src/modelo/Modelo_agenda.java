package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Modelo_agenda {
	
	private Conexion_db sistema;

	public Modelo_agenda() {
		// TODO Auto-generated constructor stub
		sistema = new Conexion_db();
	}
	
	public List<Object[]> obtenerAgenda(String usuario) throws ClassNotFoundException, SQLException {//metodo para obtener el evento agendado de un usuario
        List<Object[]> listaContactos = new ArrayList<>();//el list es para almacenar
        @SuppressWarnings("static-access")//evita que salgan advertencias
		Connection con = sistema.getConexion();
        
        try {
            String query = "SELECT evento, fecha, hora FROM agenda WHERE usuario = ?";//usamos el query para hacer la consulta
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);//establecemos el primer parametro de la consulta
            ResultSet rs = ps.executeQuery();//ejecutamos el resultado de la consulta
            
            while (rs.next()) {//busca y devuelve el evento, fecha y hora que el usuario buscaba
                Object[] contacto = new Object[3];
                contacto[0] = rs.getString("evento");//obtenemos el evento
                contacto[1] = rs.getDate("fecha");//obtenemos la fecha
                contacto[2] = rs.getTime("hora");//obtenemos la hora
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
        
        return listaContactos;//devuelve el evento, fecha y hora
    }

}
