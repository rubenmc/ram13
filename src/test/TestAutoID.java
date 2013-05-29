package test;

import java.sql.SQLException;
import java.util.Date;

import main.BD;
import main.Particular;

public class TestAutoID {

	public static void main(String[] args) throws Exception {
		BD bd = new BD();
		Date now = new Date();

		try {
			bd.connecta("usuari", "serverm13");
			// System.out.println(bd.getParticularNextID());
			Particular particular = new Particular(BD.getParticularNextID(),
					"ParticularAutoID", "977159753", "399876543S",
					"auto@id.com", new java.sql.Date(now.getTime()));

			BD.addParticular(particular);

			System.out.println("YIJA");

			BD.close();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
