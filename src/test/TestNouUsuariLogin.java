package test;

import main.BD;

public class TestNouUsuariLogin {

	public static void main(String[] args) {
		BD bd = new BD();
		try {
			bd.connecta("root", "serverm13");
			// bd.nouUsuari("Test", "pass");
			// System.out.println("NO ERROR");
		} catch (InstantiationException | IllegalAccessException e) {
		}

		/*
		 * try { int res = bd.login("Test", "pass"); System.out.println(res); }
		 * catch (InstantiationException | IllegalAccessException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

}
