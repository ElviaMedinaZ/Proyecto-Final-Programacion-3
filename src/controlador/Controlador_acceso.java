package controlador;

import vista.Vista_acceso;

public class Controlador_acceso {

    private Vista_acceso usuarios;

    public Controlador_acceso(){
        // Constructor
    	usuarios = new Vista_acceso();
       
    }
    
    public void vista_acceso() {
    	usuarios.vista_Acceso();
    }

    
}
