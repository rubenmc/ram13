package main;

public class Empleat {

	private int id;
	private int vendes;
	private String nom;
	private String SS;
	private String DNI;
	private int tenda;

	//Constructor
	/**
	 * @param id
	 * @param vendes
	 * @param nom
	 * @param SS
	 * @param DNI
	 * @param tenda
	 */
	public Empleat(int id, int vendes, String nom, String SS, String DNI,
			int tenda) {
		this.id = id;
		this.vendes = vendes;
		this.nom = nom;
		this.SS = SS;
		this.DNI = DNI;
		this.tenda = tenda;
	}

	
	//Getters i Setters
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
	 * @return the vendes
	 */
	public int getVendes() {
		return vendes;
	}

	/**
	 * @param vendes
	 *            the vendes to set
	 */
	public void setVendes(int vendes) {
		this.vendes = vendes;
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
	 * @return the sS
	 */
	public String getSS() {
		return SS;
	}

	/**
	 * @param sS
	 *            the sS to set
	 */
	public void setSS(String sS) {
		SS = sS;
	}

	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param dNI
	 *            the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * @return the tenda
	 */
	public int getTenda() {
		return tenda;
	}

	/**
	 * @param tenda
	 *            the tenda to set
	 */
	public void setTenda(int tenda) {
		this.tenda = tenda;
	}
	
	@Override
	public String toString() {
		return nom;
	}

	public void display() {
		System.out.println("\nDades de l'empleat " + nom + "\nNº SS-->"
				+ SS + "\nDNI-->" + DNI + "\nTenda-->"
				+ tenda+ "\nVendes-->"
				+ vendes);
	}

}
