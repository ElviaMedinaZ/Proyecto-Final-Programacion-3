package modelo;

import java.io.InputStream;

public class Modelo_pdf {
    private String nombre;
    private InputStream archivoStream;

    public Modelo_pdf(String nombre, InputStream archivoStream) {
        this.nombre = nombre;
        this.archivoStream = archivoStream;
    }

    public String getNombre() {
        return nombre;
    }

    public InputStream getArchivoStream() {
        return archivoStream;
    }
}