package main;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public abstract class Persona {

	private String id;
	private String nom;
	private String telf;
	private String NIF;
	private String mail;

	// Constructor
	/**
	 * @param nom
	 *            El nom de la persona
	 * @param telf
	 *            El telefon de la persona
	 * @param NIF
	 *            El NIF de la persona
	 * @param mail
	 *            El mail de la persona
	 */
	public Persona(String id, String nom, String telf, String NIF, String mail) {
		this.id 	= id;
		this.nom 	= nom;
		this.telf 	= telf;
		this.NIF 	= NIF;
		this.mail 	= mail;
	}

	// Getters i Setters
	/**
	 * @return L'id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            El nou id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return El nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            El nou nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return El telefon
	 */
	public String getTelf() {
		return telf;
	}

	/**
	 * @param telf
	 *            El nou telefon
	 */
	public void setTelf(String telf) {
		this.telf = telf;
	}

	/**
	 * @return El nIF
	 */
	public String getNIF() {
		return NIF;
	}

	/**
	 * @param NIF
	 *            El nou NIF
	 */
	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	/**
	 * @return El mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            El nou mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return nom;
	}

	public void display() {
		System.out.println("\nDades del client " + nom + "\nNIF-->" + NIF
				+ "\nTelefon-->" + telf + "\nMail-->" + mail);
	}
}
