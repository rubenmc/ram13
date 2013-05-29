package main;

/**
 * 
 * @author Ruben Macias i Albert Llaurad�
 * 
 */
public class Tenda {

	private int 	id;
	private String 	direccio;
	private String 	telefon;

	// Constructor
	/**
	 * @param id
	 *            L'identificador de la tenda
	 * @param direccio
	 *            La direcci� de la tenda
	 * @param telefon
	 *            El telefon de la tenda
	 */
	public Tenda(int id, String direccio, String telefon) {
		this.id 		= id;
		this.direccio 	= direccio;
		this.telefon 	= telefon;
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
	 * @return La direcci�
	 */
	public String getDireccio() {
		return direccio;
	}

	/**
	 * @param direccio
	 *            La nova direcci�
	 */
	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	/**
	 * @return El telefon
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * @param telefon
	 *            El nou telefon
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
