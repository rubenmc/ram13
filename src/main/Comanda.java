package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Comanda {

	private int id;
	private int emisor;
	private int receptor;
	private boolean estat;
	private Date data;
	private Joc[] articles;
	SimpleDateFormat formateador = new SimpleDateFormat(
			"d 'de' MMMM 'de' yyyy - HH:mm", new Locale("es"));

	// Constructor
	public Comanda(int id, int emisor, int receptor, boolean estat, Date data,
			Joc[] articles) {
		this.id = id;
		this.emisor = emisor;
		this.receptor = receptor;
		this.estat = estat;
		this.data = data;
		this.articles = articles;
	}

	// Getters i Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the emisor
	 */
	public int getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor
	 *            the emisor to set
	 */
	public void setEmisor(int emisor) {
		this.emisor = emisor;
	}

	/**
	 * @return the receptor
	 */
	public int getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor
	 *            the receptor to set
	 */
	public void setReceptor(int receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the estat
	 */
	public boolean isEstat() {
		return estat;
	}

	/**
	 * @param estat
	 *            the estat to set
	 */
	public void setEstat(boolean estat) {
		this.estat = estat;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the articles
	 */
	public Joc[] getArticles() {
		return articles;
	}

	/**
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(Joc[] articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return emisor + " - " + receptor + " - " + formateador.format(data);
	}

	public void display() {
		System.out.println("\nDades de la comanda " + id + "\nEmissor-->"
				+ emisor + "\nReceptor-->" + receptor + "\nData-->"
				+ formateador.format(data) + "\nArticles:");
		for (int x = 0; x < articles.length; x++) {
			System.out.println(articles[x] + " - " + articles[x].getPreu());
		}
	}

}
