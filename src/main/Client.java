package main;

public class Client {

	private String nom;
	private String telf;
	private String NIF;
	private String mail;
	
	public Client(String nom,String telf,String NIF,String mail){
		this.nom=nom;
		this.telf=telf;
		this.NIF=NIF;
		this.mail=mail;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
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
	 * @param telf the telf to set
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
	 * @param nIF the nIF to set
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
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String toString(){
		return "Dades del client "+nom+
				"\nNIF-->"+NIF+
				"\nTelefon-->"+telf+
				"\nMail-->"+mail;
	}
}
