package main;

import java.sql.*;

public class BD {

	public static Connection connecta() throws InstantiationException,
			IllegalAccessException {
		try {
			// Carregar JDBC
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Crear conexio
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://10.1.105.213/m13", "root", "serverm13");
			System.out.println("That's goood");

			return conexion;

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
