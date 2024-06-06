package modelo;

import java.util.Date;

public class Modelo_usuario {

	private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String sexo;
    private String discapacidad;
    private String correo;

    // Getters y setters para acceder y modificar los valores
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getDiscapacidad() { return discapacidad; }
    public void setDiscapacidad(String discapacidad) { this.discapacidad = discapacidad; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

}
