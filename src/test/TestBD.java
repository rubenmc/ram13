package test;

import java.sql.*;

import com.mysql.jdbc.CommunicationsException;

public class TestBD {

	public static void main(String[] args) {
		try {
			// Carregar JDBC
			Class.forName("com.mysql.jdbc.Driver");

			// Crear conexio
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/m13", "root", "");

			// Crear consulta
			Statement sentencia = conexion.createStatement();

			// consulta
			ResultSet resul = sentencia.executeQuery("SELECT * FROM prova");

			// Obtenir i imprimir les dades
			System.out
					.println("--------------------\nPROBA DE CONNEXIO\n--------------------");
			while (resul.next()) {
				System.out.println(resul.getString(1));
			}

			// Tanquem
			resul.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (CommunicationsException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
