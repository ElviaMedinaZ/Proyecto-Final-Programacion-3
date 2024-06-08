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
            String query = "SELECT id, nombre, numero, relacion FROM contactos WHERE usuario = ?";//usamos el query para hacer la consulta
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);//primer parametro de la consulta
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] contacto = new Object[4];
                contacto[0] = rs.getInt("id");
                contacto[1] = rs.getString("nombre");//obtenemos el nombre
                contacto[2] = rs.getString("numero");//obtenemos el numero
                contacto[3] = rs.getString("relacion");//obtenemos la relacion
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
	
	 public boolean borrarContactoPorId(int id) throws ClassNotFoundException, SQLException {
	        // Método para borrar un contacto por su id
	        @SuppressWarnings("static-access")
	        Connection con = sistema.getConexion();
	        boolean resultado = false;

	        try {
	            String query = "DELETE FROM contactos WHERE id = ?";
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
	 
	    public boolean agregarContacto(String usuario, String nombre, String numero, String relacion) throws ClassNotFoundException, SQLException {
	        // Método para agregar un contacto
	        @SuppressWarnings("static-access")
	        Connection con = sistema.getConexion();
	        boolean resultado = false;

	        try {
	        	
	        	// Verificar si el contacto ya existe
	            if (contactoExiste(usuario, nombre, numero, relacion)) {
	                return false; // El contacto ya existe, no se puede agregar
	            }
	            
	            String query = "INSERT INTO contactos (usuario, nombre, numero, relacion) VALUES (?, ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, usuario);
	            ps.setString(2, nombre);
	            ps.setString(3, numero);
	            ps.setString(4, relacion);

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
	    
	   
		public boolean contactoExiste(String usuario, String nombre, String numero, String relacion) throws ClassNotFoundException, SQLException {
	        @SuppressWarnings("static-access")
	        Connection con = sistema.getConexion();
	        boolean existe = false;

	        try {
	            String query = "SELECT COUNT(*) FROM contactos WHERE usuario = ? AND nombre = ? AND numero = ? AND relacion = ?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, usuario);
	            ps.setString(2, nombre);
	            ps.setString(3, numero);
	            ps.setString(4, relacion);

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

	    public boolean  actualizarContacto(int id, String nombre, String numero, String relacion) throws ClassNotFoundException, SQLException {
	        String query = "UPDATE contactos SET nombre = ?, numero = ?, relacion = ? WHERE id = ?";
	        try (@SuppressWarnings("static-access")
			Connection con = sistema.getConexion();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, nombre);
	            ps.setString(2, numero);
	            ps.setString(3, relacion);
	            ps.setInt(4, id);
	            int rowsUpdated = ps.executeUpdate();
	            return rowsUpdated > 0; // Devuelve true si al menos una fila fue actualizada
	        }
	    }
}
