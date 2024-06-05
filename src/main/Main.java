package main;

import controlador.Controlador_acceso;
import controlador.Controlador_persona;

public class Main {

	public static void main(String[] args) {

		Controlador_acceso sistema = new Controlador_acceso();
		sistema.vista_acceso();

//		Controlador_persona sistema  = new Controlador_persona();
//		sistema.vista_agenda();
	}

}
