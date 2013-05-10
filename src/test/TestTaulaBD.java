package test;

import GUI.Taula;
import main.BD;

public class TestTaulaBD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BD bd = new BD();
		try {
			int res = bd.connecta("usuari", "serverm13");
			if(res==1){
				Taula taula = BD.getDades("provaparticular");
			} else {
				System.out.println("FALLA CONEXION");
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Taula taula = new Taula("datos", "camps");

	}

}
