package test;

import java.sql.*;

public class TestBD {

	public static void main(String[] args) {
		try {
			// Carregar JDBC
			Class.forName("com.mysql.jdbc.Driver");

			// Crear conexio
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.35/m13", "root", "serverm13");

			// Crear consulta
			Statement sentencia = conexion.createStatement();

			// consulta
			ResultSet resul = sentencia.executeQuery("SELECT * FROM prova");

			// Obtenir i imprimir les dades
			System.out
					.println("--------------------\nPROBA DE CONNEXIO\n--------------------");
			while (resul.next()) {
				System.out.println(resul.getInt(1));
				System.out.println(resul.getString(2));
				System.out.println(resul.getString(3));
			}

			// Tanquem
			resul.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
