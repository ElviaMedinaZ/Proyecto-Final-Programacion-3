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
	
	public void vista_persona(String usuario) {
		Vista_persona  persona = new Vista_persona();
		persona.vista_persona(usuario);	
	}
	
	public void vista_necesidades(String usuario){
		
		Vista_necesidades persona = new Vista_necesidades();
		persona.vista_necesidades(usuario);
		
	}
	
	public void vista_agenda(String usuario) {
		Vista_agenda persona = new Vista_agenda();
		persona.vista_agenda(usuario);
	}
	
	public void vista_certificado(String usuario) {
		Vista_certificado persona = new Vista_certificado();
		persona.vista_certificado(usuario);
		
	}
	
	public void vista_contactos(String usuario) {
		Vista_contactos persona = new Vista_contactos();
		persona.vista_contactos(usuario);
	}
	
	public void vista_editar(String usuario) {
		Vista_editar persona = new Vista_editar();
		persona.vista_editar(usuario);
			
	}
	
	public void vista_dispositivos(String usuario) {
		Vista_dispositivos persona = new Vista_dispositivos();
		persona.vista_dispositivos(usuario);
	}

}
