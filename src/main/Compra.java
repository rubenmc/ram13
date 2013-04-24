package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Compra {

	private int id;
	private int client;
	private int venedor;
	private Unitat[] articles;
	private float preu;
	private Date data;
	SimpleDateFormat formateador = new SimpleDateFormat("d 'de' MMMM 'de' yyyy - HH:mm", new Locale("es"));
	
	//Constructor
	public Compra(int id, int client, int venedor, Unitat[] article,
			float preu, Date data) {
		this.id = id;
		this.client = client;
		this.venedor = venedor;
		this.articles = article;
		this.preu = preu;
		this.data=data;
	}

	

	//Getters i Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the client
	 */
	public int getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(int client) {
		this.client = client;
	}

	/**
	 * @return the venedor
	 */
	public int getVenedor() {
		return venedor;
	}

	/**
	 * @param venedor the venedor to set
	 */
	public void setVenedor(int venedor) {
		this.venedor = venedor;
	}

	/**
	 * @return the article
	 */
	public Unitat[] getArticle() {
		return articles;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Unitat[] article) {
		this.articles = article;
	}

	/**
	 * @return the preu
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * @param preu the preu to set
	 */
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return venedor+" - "+client+" - "+formateador.format(data);
	}

	public void display() {
		System.out.println("\nDades de la compra " + id + "\nVenedor-->"
				+ venedor + "\nClient-->" + client + "\nPreu-->"
				+ preu+ "\nData-->"	+ formateador.format(data)+"\nArticles:");
		for(int x=0;x<articles.length;x++){
			System.out.println(articles[x].getId()+"."+articles[x].getJoc()+" - "+articles[x].getPreu());
		}
	}


}
