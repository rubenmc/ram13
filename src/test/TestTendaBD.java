package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.Tenda;
import main.BD;

public class TestTendaBD {

	public static void main(String[] args) throws SQLException {
		ResultSet resul = null;
		Statement sentencia = null;
		Connection conexio = null;
		try {
			conexio = BD.connecta();
			if (conexio != null) {
				// Crear consulta
				sentencia = conexio.createStatement();

				// consulta
				resul = sentencia
						.executeQuery("SELECT * FROM prova where id=1");

				// Obtenir i imprimir les dades
				System.out
						.println("--------------------\nPROBA DE CONNEXIO I CREACIO D'OBJECTE\n--------------------");
				while (resul.next()) {
					Tenda tenda = new Tenda(resul.getInt(1),
							resul.getString(2), resul.getString(3));
					tenda.display();
				}
			} else {
				System.out.println("Conexion nula");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Tanquem
		resul.close();
		sentencia.close();
		conexio.close();

	}

}
