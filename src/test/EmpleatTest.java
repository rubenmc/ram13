package test;

import main.Empleat;
import main.Tenda;

public class EmpleatTest {

	public static void main(String[] args) {
		Tenda tenda = new Tenda(0, "C/Test 123", "977741753");
		Empleat empleat = new Empleat(0, 0, "EmpleatTest", "987654321",
				"988765412-A", tenda.getId());

		empleat.display();

		System.out.println("toStringEmpleat-->" + empleat);

	}

}
