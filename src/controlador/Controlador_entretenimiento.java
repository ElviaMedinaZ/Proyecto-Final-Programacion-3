package controlador;

import vista.Vista_entretenimiento;

public class Controlador_entretenimiento {

	private Vista_entretenimiento persona;
	
	public Controlador_entretenimiento() {
		persona = new Vista_entretenimiento();
	}
	
	public void vista_entretenimiento(String usuario) {
		persona.vista_entretenimiento(usuario);
	}

}
