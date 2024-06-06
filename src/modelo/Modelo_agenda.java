package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

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
            String query = "SELECT id, evento, fecha, hora FROM agenda WHERE usuario = ?";//usamos el query para hacer la consulta
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);//establecemos el primer parametro de la consulta
            ResultSet rs = ps.executeQuery();//ejecutamos el resultado de la consulta
            
            while (rs.next()) {//busca y devuelve el evento, fecha y hora que el usuario buscaba
                Object[] contacto = new Object[4];
                contacto[0] = rs.getInt("id");
                contacto[1] = rs.getString("evento");//obtenemos el evento
                contacto[2] = rs.getDate("fecha");//obtenemos la fecha
                contacto[3] = rs.getTime("hora");//obtenemos la hora
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
	
	public boolean agregarContacto(String usuario, String evento, Date fecha, java.sql.Time hora) throws ClassNotFoundException, SQLException {
        // Método para agregar un contacto
        @SuppressWarnings("static-access")
        Connection con = sistema.getConexion();
        boolean resultado = false;

        try {
        	
        	// Verificar si el contacto ya existe
            if (eventoExiste(usuario, evento, fecha, hora)) {
                return false; // El contacto ya existe, no se puede agregar
            }
            
            String query = "INSERT INTO agenda (usuario, evento, fecha, hora) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, evento);
            ps.setDate(3,new java.sql.Date(fecha.getTime()) );
            ps.setTime(4,hora );

            int filasAfectadas = ps.executeUpdate();
            resultado = (filasAfectadas > 0); // Si al menos una fila fue afectada, la inserción fue exitosa
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close(); // Cerramos la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado; // Devuelve true si se insertó exitosamente, false en caso contrario
    }
	
	public boolean eventoExiste(String usuario, String evento, Date fecha, java.sql.Time hora) throws ClassNotFoundException, SQLException {
        @SuppressWarnings("static-access")
        Connection con = sistema.getConexion();
        boolean existe = false;

        try {
            String query = "SELECT COUNT(*) FROM agenda WHERE usuario = ? AND evento = ? AND fecha = ? AND hora = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, evento);
            ps.setDate(3, new java.sql.Date(fecha.getTime()));
            ps.setTime(4,hora);

            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                existe = true; // El contacto ya existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close(); // Cerramos la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return existe;
    }
	
	public boolean borrarEventoPorId(int id) throws ClassNotFoundException, SQLException {
        // Método para borrar un contacto por su id
        @SuppressWarnings("static-access")
        Connection con = sistema.getConexion();
        boolean resultado = false;

        try {
            String query = "DELETE FROM agenda WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id); // Primer parámetro de la consulta

            int filasAfectadas = ps.executeUpdate();
            resultado = (filasAfectadas > 0); // Si al menos una fila fue afectada, el borrado fue exitoso
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close(); // Cerramos la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado; // Devuelve true si se borró exitosamente, false en caso contrario
    }
	
	public boolean actualizarEvento(int id, String evento, Date fecha, java.sql.Time hora) throws ClassNotFoundException, SQLException {
	    // Verificar que la fecha no sea null
	    if (fecha == null) {
	        throw new IllegalArgumentException("La fecha no puede ser null");
	    }

	    String query = "UPDATE agenda SET evento = ?, fecha = ?, hora = ? WHERE id = ?";
	    try (@SuppressWarnings("static-access")
	         Connection con = sistema.getConexion();
	         PreparedStatement ps = con.prepareStatement(query)) {
	        
	        ps.setString(1, evento);
	        ps.setDate(2, new java.sql.Date(fecha.getTime()));
	        ps.setTime(3, hora);
	        ps.setInt(4, id);

	        int rowsUpdated = ps.executeUpdate();
	        return rowsUpdated > 0; // Devuelve true si al menos una fila fue actualizada
	    }
	}

 

}
