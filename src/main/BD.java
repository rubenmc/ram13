package main;

import java.sql.*;

public class BD {

	private static Connection CONEXIO;

	/**
	 * Metode per conectarse a la BD
	 * 
	 * @return El resultat de la conexio
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public boolean connecta() throws InstantiationException,
			IllegalAccessException {
		try {
			// Carregar JDBC
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Crear conexio
			CONEXIO = DriverManager.getConnection(
					"jdbc:mysql://10.1.105.213/m13", "root", "serverm13");
			return true;

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param usuari
	 *            Nom de l'usuari
	 * @param pass
	 *            Contrasenya de l'usuari
	 * @return Codi amb el resultat del login
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public int login(String usuari, String pass) throws InstantiationException,
			IllegalAccessException {
		try {
			// Carregar JDBC
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Crear conexio
			CONEXIO = DriverManager.getConnection(
					"jdbc:mysql://10.1.105.213/m13", "login", "");

			String sql = "Select * from login where usuari='" + usuari + "';";

			Statement sentencia = CONEXIO.createStatement();

			ResultSet resul = sentencia.executeQuery(sql);

			if (resul.next()) {
				if (resul.getString(3).equals(pass)) {
					if (resul.getBoolean(4)) {
						// Dades correctes però ja esta conectat
						return 0;
					} else {
						// Dades correctes i no esta conectat
						return 1;
					}
				} else {
					// Contrasenya incorrecta
					return 2;
				}
			} else {
				// Usuari incorrecte
				return 3;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Error de conexio
		return 4;
	}

	/**
	 * @return La conexio actual
	 */
	public Connection getConnection() {
		return CONEXIO;
	}

	/**
	 * Métode per obtenir el següent ID de particular
	 * 
	 * @return La ID que s'utilitzara en el següent particular
	 * @throws SQLException
	 */
	public String getParticularNextID() throws SQLException {
		String sql = "Select particularNextID()";

		Statement sentencia = CONEXIO.createStatement();
		ResultSet resul = sentencia.executeQuery(sql);
		resul.next();
		return resul.getString(1);
	}

	/**
	 * Metode per afegir un client particular a la BD
	 * 
	 * @param particular
	 *            El particular que s'ha d'afegir
	 * @throws SQLException
	 */
	public void afegeixParticular(Particular particular) throws SQLException {
		String sql_insert = "INSERT INTO provaparticular (`id` ,`nom` ,`nif` ,`telf` ,`datanaixement` ,`mail`) VALUES ('"
				+ particular.getId()
				+ "','"
				+ particular.getNom()
				+ "','"
				+ particular.getNIF()
				+ "','"
				+ particular.getTelf()
				+ "','"
				+ particular.getDataNaixement()
				+ "','"
				+ particular.getMail()
				+ "');";

		Statement sentencia = CONEXIO.createStatement();
		sentencia.executeUpdate(sql_insert);
	}

	/**
	 * Metode per tancar la conexio
	 * 
	 * @return El resultat de intentar tancar la conexio
	 */
	public boolean close() {
		try {
			CONEXIO.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
