package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vista.Cambiar_contrasena;
import vista.Ciencias_naturales;
import vista.Entretenimiento;
import vista.Espanol;
import vista.Filosofia;
import vista.Geografia;
import vista.Historia;
import vista.Matematicas;
import vista.Necesidades;
import vista.Acceso;
import vista.Agenda;
import vista.Aprendizaje;
import vista.Panel_principal;
import vista.Personal;
import vista.Registro;

public class Vista_ventana {

	private Acceso acceso;
	private Registro registro;
	private Cambiar_contrasena contrasena;
	private Panel_principal principal;
	private Personal personal;
	private Entretenimiento entretenimiento;
	private Aprendizaje aprendizaje;
	private Necesidades necesidades;
	private Agenda agenda;
	private Espanol espanol;
	private Matematicas matematicas;
	private Geografia geografia;
	private Ciencias_naturales naturales;
	private Filosofia filosofia;
	private Historia historia;
	
	public Vista_ventana(Controlador sistema)//cada una de las vistas interactua con el controlador
	{
		acceso = new Acceso(sistema);
		registro = new Registro(sistema);
		contrasena = new Cambiar_contrasena(sistema);
		principal = new Panel_principal(sistema);
		personal = new Personal(sistema);
		entretenimiento = new Entretenimiento(sistema);
		aprendizaje = new Aprendizaje(sistema);
		necesidades = new Necesidades(sistema);
		agenda = new Agenda(sistema);
		espanol = new Espanol(sistema);
		matematicas = new Matematicas(sistema);
		geografia = new Geografia(sistema);
		naturales = new Ciencias_naturales(sistema);
		filosofia = new Filosofia(sistema);
		historia = new Historia(sistema);
		
	}
	
	public JPanel vista(String op, JFrame frame) 
	{
		switch (op) //retornamos el panel segun la opcion del usuario
		{
			case "login":
				return acceso.vista_acceso();
			case "registro":
				return registro.vista_registro();
			case "contrasena":
				return contrasena.vista_contrasena();
			case "principal":
				return principal.vista_principal();
			case "personal":
				return personal.vista_personal();
			case "entretenimiento":
				return entretenimiento.vista_entretenimiento();
			case "aprendizaje":
				return aprendizaje.vista_aprendizaje();
			case "necesidades":
				return necesidades.vista_necesidades();
			case "agenda":
				return agenda.vista_agenda();
			case "espanol":
				return espanol.vista_espanol();
			case "matematicas":
				return matematicas.vista_matematicas();
			case "geografia":
				return geografia.vista_geografia();
			case "naturales":
				return naturales.vista_naturales();
			case "filosofia":
				return filosofia.vista_filosofia();
			case "historia":
				return historia.vista_historia();
			default:
				return null;
		}
	}
}
