package controlador;

import vista.Vista_Cambio_Contrasena;

public class Controlador_Contrasena {
	
	private Vista_Cambio_Contrasena cambiar;

	public Controlador_Contrasena() {
		// TODO Auto-generated constructor stub
		cambiar = new Vista_Cambio_Contrasena();
	}
	
	public void vista_Cambiar() {
		cambiar.vista_Cambiar();
	}

}
