package controlador;

import vista.Vista_aprendizaje;
import vista.Vista_espanol;
import vista.Vista_filosofia;
import vista.Vista_geografia;
import vista.Vista_historia;
import vista.Vista_matematicas;
import vista.Vista_naturales;

public class Controlador_aprendizaje {

	public Controlador_aprendizaje() {
		// TODO Auto-generated constructor stub
	}
	
	public void vista_aprendizaje(String usuario) {
		Vista_aprendizaje materia = new Vista_aprendizaje();
		materia.vista_aprendizaje(usuario);
	}

	public void vista_espanol(String usuario) {
		Vista_espanol materia = new Vista_espanol();
		materia.vista_espanol(usuario);
	}
	
	public void vista_matematicas(String usuario) {
		Vista_matematicas materia = new Vista_matematicas();
		materia.vista_matematicas(usuario);
	}
	
	public void vista_geografia(String usuario) {
		Vista_geografia materia = new  Vista_geografia(); 
		materia.vista_geografia(usuario);
	}
	
	public void vista_historia(String usuario) {
		Vista_historia materia = new Vista_historia();
		materia.vista_historia(usuario);
	}
	
	public void vista_naturales(String usuario) {
		Vista_naturales materia = new Vista_naturales();
		materia.vista_naturales(usuario);
	}
	
	public void vista_filosofia(String usuario) {
		
		Vista_filosofia materia = new Vista_filosofia();
		materia.vista_filosofia(usuario);
		
	}

}
