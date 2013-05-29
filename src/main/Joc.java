package main;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public class Joc {

	private String 	proveidor;
	private String 	nom;
	private String 	genere;
	private float 	preu;
	private int 	id;

	// Constructor
	/**
	 * @param id
	 *            L'identificador del joc
	 * @param nom
	 *            El nom del joc
	 * @param proveidor
	 *            L'identificador del proveidor
	 * @param preu
	 *            El preu del joc
	 * @param genere
	 *            El genere del joc
	 */
	public Joc(int id, String nom, String proveidor, float preu, String genere) {
		this.id 		= id;
		this.nom 		= nom;
		this.proveidor 	= proveidor;
		this.preu 		= preu;
		this.genere 	= genere;
	}

	// Getters i Setters
	/**
	 * @return El proveidor
	 */
	public String getProveidor() {
		return proveidor;
	}

	/**
	 * @param proveidor
	 *            El nou proveidor
	 */
	public void setProveidor(String proveidor) {
		this.proveidor = proveidor;
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
	 * @return El genere
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * @param genere
	 *            El nou genere
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
