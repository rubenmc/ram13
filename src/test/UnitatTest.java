package test;

import main.Joc;
import main.Proveidor;
import main.Tenda;
import main.Unitat;

public class UnitatTest {


	public static void main(String[] args) {
		
		Proveidor proveidor = new Proveidor(0, "Proveidor_Test", "977456123",
				"6543434", "algo@algo.com", "Pepito", "53467-354385438-354354");
		
		Joc joc = new Joc(0, "Tetris", proveidor.getId(), 70, "Genere");
		
		Tenda tenda = new Tenda(0, "C/inventat 123", "977852741");
		
		Unitat article = new Unitat(0, tenda.getId(), joc.getId());
		
		article.display();
		
		System.out.println("toStringUnitat-->"+article);

	}

}
