package controlador;

import vista.Vista_Acceso;

public class Controlador_Acceso {

    private Vista_Acceso usuarios;

    public Controlador_Acceso(){
        // Constructor
    	usuarios = new Vista_Acceso();
       
    }
    
    public void vista_Acceso() {
    	usuarios.vista_Acceso();
    }

    
}
