package main;

public class Tenda {

	private int id;
	private String direccio;
	private String telefon;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param direccio
	 * @param telefon
	 */
	public Tenda(int id, String direccio, String telefon) {
		this.id = id;
		this.direccio = direccio;
		this.telefon = telefon;
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
	 * @return the direccio
	 */
	public String getDireccio() {
		return direccio;
	}

	/**
	 * @param direccio
	 *            the direccio to set
	 */
	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	/**
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * @param telefon
	 *            the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Tenda " + id;
	}

	public void display() {
		System.out.println("\nDades de la tenda " + id + "\nDireccio-->"
				+ direccio + "\nTelefon-->" + telefon);
	}

}
