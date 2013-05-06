package main;

public class Joc {

	private String proveidor;
	private String nom;
	private String genere;
	private float preu;
	private int id;

	// Constructor
	/**
	 * @param id
	 * @param nom
	 * @param proveidor
	 * @param preu
	 */
	public Joc(int id, String nom, String proveidor, float preu, String genere) {
		this.id = id;
		this.nom = nom;
		this.proveidor = proveidor;
		this.preu = preu;
		this.genere = genere;
	}

	// Getters i Setters
	/**
	 * @return the proveidor
	 */
	public String getProveidor() {
		return proveidor;
	}

	/**
	 * @param proveidor
	 *            the proveidor to set
	 */
	public void setProveidor(String proveidor) {
		this.proveidor = proveidor;
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
	 * @return the preu
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * @param preu
	 *            the preu to set
	 */
	public void setPreu(float preu) {
		this.preu = preu;
	}

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
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * @param genere
	 *            the genere to set
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return nom;
	}

	public void display() {
		System.out.println("\nDades del joc " + nom + "\nProveidor-->"
				+ proveidor + "\nPreu-->" + preu + "\nGenere-->" + genere);
	}
}
