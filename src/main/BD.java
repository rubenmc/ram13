package main;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import GUI.Taula;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class BD {

	private static Connection CONEXIO; // Conexió amb la base de dades

	/*
	 * General
	 */
	/**
	 * Metode per conectar-se a la base de dades
	 * 
	 * @param user
	 *            Usuari de la BD
	 * @param pass
	 *            Contrasenya sense encriptar
	 * @return Codi indicant una connexio correcta o error
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
			return 0;
		} catch (MySQLSyntaxErrorException e) {
			return 2;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Mètode per obtenir dades d'una taula i retornar-les en format correcte
	 * 
	 * @param taula
	 *            Nom de la taula
	 * @param width
	 *            Ample de la taula
	 * @param height
	 *            Alçada de la taula
	 * @return Taula amb les dades de la base de dades
	 */
	public static Taula getDades(String taula, int width, int height) {
		String sql_query = "SELECT * FROM " + taula + ";";
		String sql_count = "SELECT count(*) from " + taula + ";";
		ArrayList<String> camps = new ArrayList<String>();
		Object[][] dades;
		Statement sentencia;
		ResultSet resul;
		ResultSet noms;

		try {
			// Noms columnes
			DatabaseMetaData dbmd = BD.CONEXIO.getMetaData();
			noms = dbmd.getColumns(null, null, taula, null);
			while (noms.next()) {
				camps.add(noms.getString("COLUMN_NAME").toUpperCase());
			}
			camps.add("SELECCIONAR");

			// Dades
			sentencia = CONEXIO.createStatement();
			// Obtenim el numero de files
			resul = sentencia.executeQuery(sql_count);
			resul.next();
			// Creem un array de la mida adequada
			dades = new Object[resul.getInt(1)][camps.size()];
			// Obtenim les dades
			resul = sentencia.executeQuery(sql_query);
			int x = 0;
			int y = 0;
			// Omplim l'array amb les dades de la BD
			while (resul.next()) {
				for (y = 0; y < camps.size() - 1; y++) {
					dades[x][y] = resul.getString(y + 1);
				}
				// Al final de cada fila introduim un booleà per poder
				// seleccionar la fila
				dades[x][y] = false;
				x++;
			}
			// Si l'array té dades retornem un objecte Taula
			if (dades[0][0] != null) {
				Taula table = new Taula(dades, camps.toArray(new String[camps
						.size()]), width, height);

				return table;
				// Si l'array no té dades retornem null
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Mètode per obtenir dades d'una taula i retornar-les en format correcte
	 * (sense botó de selecció)
	 * 
	 * @param taula
	 *            Nom de la taula
	 * @param width
	 *            Ample de la taula
	 * @param height
	 *            Alçada de la taula
	 * @return Taula amb les dades de la base de dades
	 */
	public static Taula getDadesConsulta(String taula, int width, int height) {
		String sql_query = "SELECT * FROM " + taula + ";";
		String sql_count = "SELECT count(*) from " + taula + ";";
		ArrayList<String> camps = new ArrayList<String>();
		Object[][] dades;
		Statement sentencia;
		ResultSet resul;
		ResultSet noms;

		try {
			// Noms columnes
			DatabaseMetaData dbmd = BD.CONEXIO.getMetaData();
			noms = dbmd.getColumns(null, null, taula, null);
			while (noms.next()) {
				camps.add(noms.getString("COLUMN_NAME").toUpperCase());
			}

			// Dades
			sentencia = CONEXIO.createStatement();
			// Obtenim el numero de files
			resul = sentencia.executeQuery(sql_count);
			resul.next();
			// Creem un array de la mida adequada
			dades = new Object[resul.getInt(1)][camps.size()];
			// Obtenim les dades
			resul = sentencia.executeQuery(sql_query);
			int x = 0;
			int y = 0;
			// Omplim l'array amb les dades de la BD
			while (resul.next()) {
				for (y = 0; y < camps.size(); y++) {
					dades[x][y] = resul.getString(y + 1);
				}
				x++;
			}
			// Si l'array té dades retornem un objecte Taula
			if (dades[0][0] != null) {
				Taula table = new Taula(dades, camps.toArray(new String[camps
						.size()]), width, height);

				return table;
				// Si l'array no té dades retornem null
			} else {
				return null;
			}
			// Retornem null si hi ha hagut algun error
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Metode per tancar la connexió
	 * 
	 * @return El resultat de tancar la connexió
	 */
	public static boolean close() {
		try {
			CONEXIO.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Métode per codificar la contrasenya de l'usuari
	 * 
	 * @param pass
	 *            Contrasenya sense codificar
	 * @return Contrasenya codificada
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
			// Retornem null si hi ha hagut algun error
		} catch (UnsupportedEncodingException e) {
			return null;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	/**
	 * Métode per obtenir la connexió actual
	 * 
	 * @return La connexó actual
	 */
	public Connection getConnection() {
		return CONEXIO;
	}

	/*
	 * PARTICULAR
	 */
	/**
	 * Métode per obtenir el següent ID de particulars
	 * 
	 * @return L'ID del nou particular
	 * @throws Exception
	 */
	public static String getParticularNextID() throws Exception {
		String sql = "Select particular from clients";
		try {
			Statement sentencia = CONEXIO.createStatement();
			// Obtenim l'id anterior
			ResultSet resul = sentencia.executeQuery(sql);
			resul.next();
			int num = resul.getInt(1);
			// Incrementem el numero
			num++;
			// El guardem a la base de dades
			sentencia.executeUpdate("UPDATE clients set particular='" + num
					+ "';");
			// Retornem el format correcte de l'id
			return "par" + num;
			// Retornem null si hi ha hagut algun error
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Métode per afegir un nou particular a la base de dades
	 * 
	 * @param particular
	 *            Particular a afegir
	 * @return Resultat de la inserció
	 */
	public static boolean addParticular(Particular particular) {
		// Sentencia
		String sql_insert = "INSERT INTO particulars (`id` ,`nom` ,`nif` ,`telf` ,`datanaixement` ,`mail`) VALUES ('"
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
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem null si hi ha hagut algun error
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per actualitzar un particular de la base de dades
	 * 
	 * @param particular
	 *            Particular a actualitzar
	 * @return Resultat de la actualització
	 */
	public static boolean updateParticular(Particular particular) {
		// Sentencia
		String sql_insert = "UPDATE particulars SET " + "nom='"
				+ particular.getNom() + "'," + "nif='" + particular.getNIF()
				+ "', " + "telf='" + particular.getTelf() + "',"
				+ "datanaixement='" + particular.getDataNaixement() + "',"
				+ "mail='" + particular.getMail() + "'" + "WHERE id='"
				+ particular.getId() + "'";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem null si hi ha hagut algun error
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per eliminar un particular de la base de dades
	 * 
	 * @param id
	 *            ID del particular a eliminar
	 * @return Resultat de l'eliminació
	 */
	public static boolean deleteParticular(String id) {
		// Sentencia
		String sql_delete = "DELETE FROM particulars WHERE id='" + id + "';";
		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_delete);
			return true;
			// Retornem null si hi ha hagut algun error
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * MAJORISTA
	 */
	/**
	 * Métode per obtenir el següent identificador de majorista
	 * 
	 * @return L'ID del nou majorista
	 */
	public static String getMajoristaNextID() {
		String sql = "Select majorista from clients";
		try {
			// Obtenim el numero anterior
			Statement sentencia = CONEXIO.createStatement();
			ResultSet resul = sentencia.executeQuery(sql);
			resul.next();
			int num = resul.getInt(1);
			// Incrementem el numero obtingut
			num++;
			// Guardem el nou numero
			sentencia.executeUpdate("UPDATE clients set majorista='" + num
					+ "';");
			// Retornem l'id en format correcte
			return "maj" + num;
			// Retornem null si falla alguna cosa
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Métode per afegir un nou majorista a la base de dades
	 * 
	 * @param majorista
	 *            Majorista a afegir
	 * @return El resultat de la inserció
	 */
	public static boolean addMajorista(Majorista majorista) {
		// Sentencia
		String sql_insert = "INSERT INTO majoristes (`id` ,`nom` ,`nif` ,`telf` ,`contacte` ,`mail`) VALUES ('"
				+ majorista.getId()
				+ "','"
				+ majorista.getNom()
				+ "','"
				+ majorista.getNIF()
				+ "','"
				+ majorista.getTelf()
				+ "','"
				+ majorista.getPersonaContacte()
				+ "','"
				+ majorista.getMail()
				+ "');";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per actualitzar un majorista de la base de dades
	 * 
	 * @param majorista
	 *            Majorista a actualitzar
	 * @return Resultat de la actualització
	 */
	public static boolean updateMajorista(Majorista majorista) {
		// Sentencia
		String sql_insert = "UPDATE majoristes SET " + "nom='"
				+ majorista.getNom() + "'," + "nif='" + majorista.getNIF()
				+ "', " + "telf='" + majorista.getTelf() + "'," + "contacte='"
				+ majorista.getPersonaContacte() + "'," + "mail='"
				+ majorista.getMail() + "'" + "WHERE id='" + majorista.getId()
				+ "'";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per eliminar un majorista de la base de dades
	 * 
	 * @param id
	 *            ID del majorista a eliminar
	 * @return Resultat de la eliminació
	 */
	public static boolean deleteMajorista(String id) {
		// Sentencia
		String sql_delete = "DELETE FROM majoristes WHERE id='" + id + "';";
		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_delete);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * JOC
	 */
	/**
	 * Métode per afegir un joc a la base de dades
	 * 
	 * @param joc
	 *            Joc a afegir
	 * @return Resultat de la inserció
	 */
	public static boolean addJoc(Joc joc) {
		// Sentencia
		String sql_insert = "INSERT INTO jocs (`idproveidor` ,`nom` ,`genere` ,`preu`) VALUES ('"
				+ joc.getProveidor()
				+ "','"
				+ joc.getNom()
				+ "','"
				+ joc.getGenere() + "','" + joc.getPreu() + "');";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per actualitzar un joc de la base de dades
	 * 
	 * @param joc
	 *            Joc a actualitzar
	 * @return Resultat de la actualització
	 */
	public static boolean updateJoc(Joc joc) {
		// Sentencia
		String sql_insert = "UPDATE jocs SET " + "nom='" + joc.getNom() + "',"
				+ "genere='" + joc.getGenere() + "', " + "idproveidor='"
				+ joc.getProveidor() + "'," + "preu='" + joc.getPreu()
				+ "'WHERE id='" + joc.getId() + "'";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per eliminar un joc de la base de dades
	 * 
	 * @param id
	 *            ID del joc a eliminar
	 * @return Resultat de la actualització
	 */
	public static boolean deleteJoc(String id) {
		// Sentencia
		String sql_delete = "DELETE FROM jocs WHERE id='" + id + "';";
		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_delete);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * EMPLEAT
	 */
	/**
	 * Métode per afegir un empleat a la base de dades
	 * 
	 * @param empleat
	 *            Empleat a afegir
	 * @return Resultat de la inserció
	 */
	public static boolean addEmpleat(Empleat empleat) {
		// Sentencia
		String sql_insert = "INSERT INTO empleats (`nom` ,`ss` ,`nif` ,`idtenda`) VALUES ('"
				+ empleat.getNom()
				+ "','"
				+ empleat.getSS()
				+ "','"
				+ empleat.getDNI() + "','" + empleat.getTenda() + "');";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per actualitzar un empleat de la base de dades
	 * 
	 * @param empleat
	 *            Empleat a actualitzar
	 * @return Resultat de la actualització
	 */
	public static boolean updateEmpleat(Empleat empleat) {
		// Sentencia
		String sql_insert = "UPDATE empleats SET " + "nom='" + empleat.getNom()
				+ "'," + "nif='" + empleat.getDNI() + "', " + "ss='"
				+ empleat.getSS() + "'," + "idtenda='" + empleat.getTenda()
				+ "'WHERE id='" + empleat.getId() + "'";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per eliminar un empleat de la base de dades
	 * 
	 * @param id
	 *            ID de l'empleat a eliminar
	 * @return Resultat de la eliminació
	 */
	public static boolean deleteEmpleat(String id) {
		// Sentencia
		String sql_delete = "DELETE FROM empleats WHERE id='" + id + "';";
		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_delete);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * TENDA
	 */
	/**
	 * Métode per afegir una tenda a la base de dades
	 * 
	 * @param tenda
	 *            Tenda a afegir
	 * @return Resultat de la inserció
	 */
	public static boolean addTenda(Tenda tenda) {
		// Sentencia
		String sql_insert = "INSERT INTO tendes (`direccio` ,`telefon`) VALUES ('"
				+ tenda.getDireccio() + "','" + tenda.getTelefon() + "');";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per actualitzar una tenda de la base de dades
	 * 
	 * @param tenda
	 *            Tenda a actualitzar
	 * @return Resultat de la actualització
	 */
	public static boolean updateTenda(Tenda tenda) {
		// Sentencia
		String sql_insert = "UPDATE tendes SET " + "direccio='"
				+ tenda.getDireccio() + "'," + "telefon='" + tenda.getTelefon()
				+ "'WHERE id='" + tenda.getId() + "'";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per eliminar una tenda de la base de dades
	 * 
	 * @param id
	 *            ID de la tenda a eliminar
	 * @return Resultat de la eliminació
	 */
	public static boolean deleteTenda(String id) {
		// Sentencia
		String sql_delete = "DELETE FROM tendes WHERE id='" + id + "';";
		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_delete);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * PROVEIDOR
	 */
	/**
	 * Métode per actualitzar un proveidor de la base de dades
	 * 
	 * @param proveidor
	 *            Proveidor a actualitzar
	 * @return Resultat de la actualització
	 */
	public static boolean updateProveidor(Proveidor proveidor) {
		// Sentencia
		String sql_insert = "UPDATE proveidors SET " + "nom='"
				+ proveidor.getNom() + "'," + "mail='" + proveidor.getMail()
				+ "'," + "nif='" + proveidor.getNIF() + "'," + "telefon='"
				+ proveidor.getTelf() + "'," + "comptecorrent='"
				+ proveidor.getCompteCorrent() + "'WHERE id='"
				+ proveidor.getId() + "'";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per afegir un proveidor a la base de dades
	 * 
	 * @param proveidor
	 *            Proveidor a afegir
	 * @return Resultat de la inserció
	 */
	public static boolean addProveidor(Proveidor proveidor) {
		// Sentencia
		String sql_insert = "INSERT INTO proveidors (`nom` ,`mail`,`nif`,`telefon`,`comptecorrent`) VALUES ('"
				+ proveidor.getNom()
				+ "','"
				+ proveidor.getMail()
				+ "','"
				+ proveidor.getNIF()
				+ "','"
				+ proveidor.getTelf()
				+ "','"
				+ proveidor.getCompteCorrent() + "');";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per eliminar un proveidor de la base de dades
	 * 
	 * @param id
	 *            ID del proveidor a eliminar
	 * @return Resultat de la eliminació
	 */
	public static boolean deleteProveidor(String id) {
		// Sentencia
		String sql_delete = "DELETE FROM proveidors WHERE id='" + id + "';";
		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_delete);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * UNITAT
	 */
	/**
	 * Métode per eliminar una unitat de la base de dades
	 * 
	 * @param id
	 *            ID de la unitat a eliminar
	 * @return Resultat de la eliminació
	 */
	public static boolean deleteUnitat(String id) {
		// Sentencia
		String sql_delete = "DELETE FROM unitats WHERE id='" + id + "';";
		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_delete);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Métode per actualitzar una unitat
	 * 
	 * @param unitat
	 *            Unitat a actualitzar
	 * @return Resultat de la actualització
	 */
	public static boolean updateUnitat(Unitat unitat) {
		// Sentencia
		String sql_insert = "UPDATE unitats SET " + "idtenda='"
				+ unitat.getTenda() + "'," + "idjoc='" + unitat.getJoc()
				+ "'WHERE id='" + unitat.getId() + "'";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Métode per afegir una unitat a la base de dades
	 * 
	 * @param unitat
	 *            Unitat a afegir
	 * @return Resultat de la inserció
	 */
	public static boolean addUnitat(Unitat unitat) {
		// Sentencia
		String sql_insert = "INSERT INTO unitats (`idtenda` ,`idjoc`) VALUES ('"
				+ unitat.getTenda() + "','" + unitat.getJoc() + "');";

		Statement sentencia;
		try {
			// Executem la sentencia, si tot va bé retornem true
			sentencia = CONEXIO.createStatement();
			sentencia.executeUpdate(sql_insert);
			return true;
			// Retornem false si falla alguna cosa
		} catch (Exception e) {
			return false;
		}
	}
}