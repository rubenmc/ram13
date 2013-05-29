package test;

import java.util.Date;

import main.*;

public class CompraTest {

	public static void main(String[] args) {

		Date now = new Date();
		Particular algo = new Particular("0", "Nom del client", "977771562",
				"99988877A", "algo@algo.com", new java.sql.Date(now.getTime()));

		Tenda tenda = new Tenda(0, "C/inventat 123", "977852741");

		Empleat empleat = new Empleat(0, "EmpleatTest", "987654321",
				"988765412-A", tenda.getId());

		Proveidor proveidor = new Proveidor("0", "Proveidor_Test", "977456123",
				"6543434", "algo@algo.com", "53467-354385438-354354");

		Joc joc = new Joc(0, "Joc-Name", proveidor.getId(), 70, "Genere");

		Unitat[] articles = new Unitat[5];

		for (int x = 0; x < articles.length; x++) {
			articles[x] = new Unitat(x, tenda.getId(), joc.getId());
		}

		Compra compra = new Compra(0, algo.getId(), empleat.getId(), articles,
				now);

		compra.display();

		System.out.println("toStringCompra-->" + compra);

	}

}
