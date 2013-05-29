package main;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public class Proveidor extends Persona {

	private String compteCorrent;

	// Constructor
	/**
	 * 
	 * @param id
	 *            L'identificador del proveidor
	 * @param nom
	 *            El nom del proveidor
	 * @param telf
	 *            El telefon del proveidor
	 * @param NIF
	 *            El NIF del proveidor
	 * @param mail
	 *            El mail del proveidor
	 * @param compte
	 *            El compte corrent del proveidor
	 */
	public Proveidor(String id, String nom, String telf, String NIF,
			String mail, String compte) {
		super(id, nom, telf, NIF, mail);
		this.compteCorrent = compte;
	}

	// Getters i Setters

	/**
	 * @return El compte corrent
	 */
	public String getCompteCorrent() {
		return compteCorrent;
	}

	/**
	 * @param compte
	 *            El nou compte corrent
	 */
	public void setCompteCorrent(String compte) {
		this.compteCorrent = compte;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Compte corrent-->" + compteCorrent);

	}

}
