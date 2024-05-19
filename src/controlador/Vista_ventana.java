package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vista.Cambiar_contrasena;
import vista.Acceso;
import vista.Panel_principal;
import vista.Registro;

public class Vista_ventana {

	private Acceso acceso;
	private Registro registro;
	private Cambiar_contrasena contraseña;
	private Panel_principal principal;
	
	public Vista_ventana(Controlador sistema)//cada una de las vistas interactua con el controlador
	{
		acceso = new Acceso(sistema);
		registro = new Registro(sistema);
		contraseña = new Cambiar_contrasena(sistema);
		principal = new Panel_principal(sistema);
	}
	
	public JPanel vista(String op, JFrame frame) 
	{
		switch (op) //retornamos el panel segun la opcion del usuario
		{
			case "login":
				return acceso.vista_acceso();
			case "registro":
				return registro.vista_registro();
			case "contraseña":
				return contraseña.vista_contraseña();
			case "principal":
				return principal.vista_principal();
			default:
				return null;
		}
	}
}
