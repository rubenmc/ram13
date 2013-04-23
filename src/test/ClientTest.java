package test;

//import java.sql.Date;
import java.util.Date;

import main.Mayorista;
import main.Particular;
import main.Proveidor;

public class ClientTest {

	public static void main(String[] args) {

		// Particular
		Date now = new Date();
		Particular algo = new Particular(0, "Nom", "977771562", "99988877A",
				"algo@algo.com", new java.sql.Date(now.getTime()));
		algo.display();

		// Mayorista
		Mayorista pescado = new Mayorista(1, "Mayorista", "5555555555",
				"654375327527B", "bla@bla.bla", "Pepito");
		pescado.display();
		
		//Proveidor
		Proveidor proveidor = new Proveidor(2, "Proveidor", "123123123", "64684638434gfa", "pimpam@cucu.buza", "Ermenegildo", "3514863-38438438-242343");
		proveidor.display();
	}

}
