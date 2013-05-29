package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public class Comanda {

	private int 		id;
	private int 		empleat;
	private int 		proveidor;
	private boolean 	estat;
	private Date 		data;
	private Joc[] 		articles;
	SimpleDateFormat 	formateador = new SimpleDateFormat(
			"d 'de' MMMM 'de' yyyy - HH:mm", new Locale("es"));

	// Constructor
	/**
	 * 
	 * @param id
	 *            L'identificador de la comanda
	 * @param empleat
	 *            L'identificador de l'empleat
	 * @param proveidor
	 *            L'identificador del proveidor
	 * @param estat
	 *            L'estat de la comanda
	 * @param data
	 *            La data de la comanda
	 * @param articles
	 *            La llista d'articles
	 */
	public Comanda(int id, int empleat, int proveidor, boolean estat,
			Date data, Joc[] articles) {
		this.id = id;
		this.empleat = empleat;
		this.proveidor = proveidor;
		this.estat = estat;
		this.data = data;
		this.articles = articles;
	}

	// Getters i Setters
	/**
	 * @return L'id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            El nou id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return L'empleat
	 */
	public int getempleat() {
		return empleat;
	}

	/**
	 * @param empleat
	 *            El nou empleat
	 */
	public void setempleat(int empleat) {
		this.empleat = empleat;
	}

	/**
	 * @return El proveidor
	 */
	public int getproveidor() {
		return proveidor;
	}

	/**
	 * @param proveidor
	 *            El nou proveidor
	 */
	public void setproveidor(int proveidor) {
		this.proveidor = proveidor;
	}

	/**
	 * @return L'estat
	 */
	public boolean isEstat() {
		return estat;
	}

	/**
	 * @param estat
	 *            El nou estat
	 */
	public void setEstat(boolean estat) {
		this.estat = estat;
	}

	/**
	 * @return La data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 *            La nova data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return Els articles
	 */
	public Joc[] getArticles() {
		return articles;
	}

	/**
	 * @param articles
	 *            Els nous articles
	 */
	public void setArticles(Joc[] articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return empleat + " - " + proveidor + " - " + formateador.format(data);
	}

	public void display() {
		System.out.println("\nDades de la comanda " + id + "\nEmpleat-->"
				+ empleat + "\nProveidor-->" + proveidor + "\nData-->"
				+ formateador.format(data) + "\nArticles:");
		for (int x = 0; x < articles.length; x++) {
			System.out.println(articles[x] + " - " + articles[x].getPreu());
		}
	}

}
