package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public class Compra {

	private int 		id;
	private String 		client;
	private int 		venedor;
	private Unitat[] 	articles;
	private float 		preu;
	private Date 		data;
	SimpleDateFormat 	formateador = new SimpleDateFormat(
			"d 'de' MMMM 'de' yyyy - HH:mm", new Locale("es"));

	// Constructor
	/**
	 * 
	 * @param id
	 *            L'identificador de la compra
	 * @param client
	 *            L'identificador del client
	 * @param venedor
	 *            L'identificador del venedor
	 * @param article
	 *            L'identificador de l'article venut
	 * @param data
	 *            La data de la compra
	 */
	public Compra(int id, String client, int venedor, Unitat[] article,
			Date data) {
		this.id = id;
		this.client = client;
		this.venedor = venedor;
		this.articles = article;
		this.data = data;
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
	 * @return El client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            El nou client
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return El venedor
	 */
	public int getVenedor() {
		return venedor;
	}

	/**
	 * @param venedor
	 *            El nou venedor
	 */
	public void setVenedor(int venedor) {
		this.venedor = venedor;
	}

	/**
	 * @return L'article
	 */
	public Unitat[] getArticle() {
		return articles;
	}

	/**
	 * @param article
	 *            El nou article
	 */
	public void setArticle(Unitat[] article) {
		this.articles = article;
	}

	/**
	 * @return El preu
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * @param preu
	 *            El nou preu
	 */
	public void setPreu(float preu) {
		this.preu = preu;
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

	@Override
	public String toString() {
		return venedor + " - " + client + " - " + formateador.format(data);
	}

	public void display() {
		System.out.println("\nDades de la compra " + id + "\nVenedor-->"
				+ venedor + "\nClient-->" + client + "\nPreu-->" + preu
				+ "\nData-->" + formateador.format(data) + "\nArticles:");
		for (int x = 0; x < articles.length; x++) {
			System.out
					.println(articles[x].getId() + "." + articles[x].getJoc());
		}
	}

}
