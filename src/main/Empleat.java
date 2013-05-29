package main;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public class Empleat {

	private String 	nom;
	private String 	SS;
	private String 	DNI;
	private int 	tenda;
	private int 	id;

	// Constructor
	/**
	 * @param id
	 *            L'identificador de l'empleat
	 * @param nom
	 *            El nom de l'empleat
	 * @param SS
	 *            El numero de la seguretat social de l'empleat
	 * @param DNI
	 *            El DNI de l'empleat
	 * @param tenda
	 *            L'identificador de la tenda de l'empleat
	 */
	public Empleat(int id, String nom, String SS, String DNI, int tenda) {
		this.id 	= id;
		this.nom 	= nom;
		this.SS 	= SS;
		this.DNI 	= DNI;
		this.tenda 	= tenda;
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
	 * @return El numero de la seguretat social
	 */
	public String getSS() {
		return SS;
	}

	/**
	 * @param SS
	 *            El nou numero de la seguretat social
	 */
	public void setSS(String SS) {
		this.SS = SS;
	}

	/**
	 * @return El DNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param DNI
	 *            El nou DNI
	 */
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	/**
	 * @return La tenda
	 */
	public int getTenda() {
		return tenda;
	}

	/**
	 * @param tenda
	 *            La nova tenda
	 */
	public void setTenda(int tenda) {
		this.tenda = tenda;
	}

	@Override
	public String toString() {
		return nom;
	}

	public void display() {
		System.out.println("\nDades de l'empleat " + nom + "\nNº SS-->" + SS
				+ "\nDNI-->" + DNI + "\nTenda-->" + tenda);
	}

}
