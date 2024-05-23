package controlador;

import vista.Vista_agenda;
import vista.Vista_certificado;
import vista.Vista_contactos;
import vista.Vista_dispositivos;
import vista.Vista_editar;
import vista.Vista_necesidades;
import vista.Vista_persona;

public class Controlador_persona {

	public Controlador_persona() {
		// TODO Auto-generated constructor stub
	}
	
	public void vista_persona() {
		Vista_persona  persona = new Vista_persona();
		persona.vista_persona();	
	}
	
	public void vista_necesidades(){
		
		Vista_necesidades persona = new Vista_necesidades();
		persona.vista_necesidades();
		
	}
	
	public void vista_agenda() {
		Vista_agenda persona = new Vista_agenda();
		persona.vista_agenda();
	}
	
	public void vista_certificado() {
		Vista_certificado persona = new Vista_certificado();
		persona.vista_certificado();
		
	}
	
	public void vista_contactos() {
		Vista_contactos persona = new Vista_contactos();
		persona.vista_contactos();
	}
	
	public void vista_editar() {
		Vista_editar persona = new Vista_editar();
		persona.vista_editar();
			
	}
	
	public void vista_dispositivos() {
		Vista_dispositivos persona = new Vista_dispositivos();
		persona.vista_dispositivos();
	}

}
