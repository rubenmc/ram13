package test;

import java.util.Date;

import main.Comanda;
import main.Joc;

public class ComandaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date now = new Date();

		Joc[] articles = new Joc[5];
		for (int x = 0; x < articles.length; x++) {
			articles[x] = new Joc(0, "Joc" + x, 15, 70, "Xupi");
		}
		Comanda comanda = new Comanda(0, 1, 2, false, new java.sql.Date(
				now.getTime()), articles);

		comanda.display();
		System.out.println("toStringComanda-->" + comanda);

	}

}
