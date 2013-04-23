package main;

public abstract class Persona {

	private int id;
	private String nom;
	private String telf;
	private String NIF;
	private String mail;

	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param telf
	 * @param NIF
	 * @param mail
	 */
	public Persona(int id, String nom, String telf, String NIF, String mail) {
		this.id = id;
		this.nom = nom;
		this.telf = telf;
		this.NIF = NIF;
		this.mail = mail;
	}

	/**
	 * Getters i Setters
	 */

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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the telf
	 */
	public String getTelf() {
		return telf;
	}

	/**
	 * @param telf
	 *            the telf to set
	 */
	public void setTelf(String telf) {
		this.telf = telf;
	}

	/**
	 * @return the nIF
	 */
	public String getNIF() {
		return NIF;
	}

	/**
	 * @param nIF
	 *            the nIF to set
	 */
	public void setNIF(String nIF) {
		NIF = nIF;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	public void display() {
		System.out.println("\nDades del client " + nom + "\nNIF-->" + NIF
				+ "\nTelefon-->" + telf + "\nMail-->" + mail);
	}
}
