package main;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;

import GUI.Taula;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

public class BD {

	private static Connection CONEXIO;

	/**
	 * Metode per conectar-se a la base de dades
	 * 
	 * @param user
	 * 			Usuari de la BD
	 * @param pass
	 * 			Contrasenya sense encriptar
	 * @return
	 * 			Codi indicant una connexio correcta o error
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public int connecta(String user, String pass)
			throws InstantiationException, IllegalAccessException {
		String truePass = codifica(pass);
		try {
			// Carregar JDBC
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Crear conexio
			CONEXIO = DriverManager.getConnection(
					"jdbc:mysql://10.1.105.213/m13", user, truePass);
			return 1;

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (MySQLSyntaxErrorException e){
			return 2;
		} catch (SQLException e) {
			return 0;
		} 
		return 0;
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
	public static String getParticularNextID() throws SQLException {
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
	public static boolean afegeixParticular(Particular particular) {
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

		Statement sentencia;
		try {
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	/**
	 * Metode per tancar la conexio
	 * 
	 * @return El resultat de intentar tancar la conexio
	 */
	public static boolean close() {
		try {
			CONEXIO.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metode per a crear un nou usuari per utilitzar l'aplicatiu
	 * 
	 * @param name
	 *            Nom de l'usuari
	 * @param pass
	 *            Contrasenya de l'usuari
	 * @return
	 */
	public static boolean nouUsuari(String name, String pass) {
		// Codifiquem la contrasenya
		String passCodificada = codifica(pass);
		// Creem l'string sql
		String sql_insert = "INSERT INTO login (`id` ,`usuari` ,`contrasenya` ,`conectat`) VALUES ('"
				+ 0 + "','" + name + "','" + passCodificada + "','" + 0 + "');";
		Statement sentencia;
		try {
			// Executem
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			// Retornem true si s'ha inserit correctament
			return true;
		} catch (SQLException e) {
		}
		// Retornem false si hi ha hagut algun error
		return false;

	}

	/**
	 * Metode per codificar la contrasenya avans de guardar el nou usuari
	 * 
	 * @param pass
	 *            Password sense codificar
	 * @return Password codificada
	 */
	private static String codifica(String pass) {
		byte[] plainText;
		try {
			// Passem l'string a bytes
			plainText = pass.getBytes("UTF8");
			// Creem una instancia MD5
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// Codifiquem i guardem a l'array de bytes
			messageDigest.update(plainText);
			byte[] digest = messageDigest.digest();
			// Instanciem un objecte StringBuilder
			StringBuilder sb = new StringBuilder();
			for (byte d : digest) {
				// Afegim a l'stringbuilder els bytes codificats
				sb.append(String.format("%02x", d));
			}
			// Retornem l'string resultant
			return sb.toString();
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
		}
		// Retornem null si hi ha hagut algun error
		return null;
	}


	public static Taula getDades(String taula) {
		String sql_query = "SELECT * FROM "+taula+";";
		String sql_count = "SELECT count(*) from "+taula+";";
		ArrayList<String> camps = new ArrayList<String>();
		Object[][] dades;
		Statement sentencia;
		ResultSet resul;
		ResultSet noms;
		
		try {
			//Noms columnes
			DatabaseMetaData dbmd = BD.CONEXIO.getMetaData();
			noms = dbmd.getColumns(null, null, taula, null);
			while(noms.next()){
				camps.add(noms.getString("COLUMN_NAME"));
			}
			
					
			//Dades
			sentencia = CONEXIO.createStatement();
			resul = sentencia.executeQuery(sql_count);
			resul.next();
			dades = new Object[resul.getInt(1)][camps.size()+2];
			resul = sentencia.executeQuery(sql_query);
			int x=0;
			while(resul.next()){
				dades[x][0]=resul.getString(1);
				dades[x][1]=resul.getString(2);
				dades[x][2]=resul.getString(3);
				dades[x][3]=resul.getString(4);
				dades[x][4]=resul.getString(5);
				dades[x][5]=resul.getString(6);
				dades[x][6]= new JButton("BTN1");
				dades[x][7]= new JButton("BTN2");
				x++;
			}
			
			Taula table = new Taula(dades, camps.toArray(new String[camps.size()]));
			return table;
		} catch (SQLException e) {
		}
		return null;
	}
	
	
}
