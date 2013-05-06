package test;

import main.Joc;
import main.Proveidor;

public class JocTest {

	public static void main(String[] args) {
		Proveidor proveidor = new Proveidor("0", "Proveidor_Test", "977456123",
				"6543434", "algo@algo.com", "Pepito", "53467-354385438-354354");
		Joc joc = new Joc(0, "Joc-Name", proveidor.getId(), 70, "Genere");

		joc.display();

	}

}
