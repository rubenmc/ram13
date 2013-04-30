package main;

public class Unitat {

	private int id;
	private int tenda;
	private int joc;

	// Constructor
	/**
	 * @param id
	 * @param tenda
	 * @param joc
	 */
	public Unitat(int id, int tenda, int joc) {
		this.id = id;
		this.tenda = tenda;
		this.joc = joc;
	}

	// Getters i Setters
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

	/**
	 * @return the joc
	 */
	public int getJoc() {
		return joc;
	}

	/**
	 * @param joc
	 *            the joc to set
	 */
	public void setJoc(int joc) {
		this.joc = joc;
	}

	@Override
	public String toString() {
		return joc + "." + id;
	}

	public void display() {
		System.out.println("\nDades de la unitat " + id + " del joc " + joc
				+ "\nTenda-->" + tenda + "\nPreu-->" + joc);
	}

	public float getPreu() {
		// Consulta a BD utilizando el ID del juego y devolviendo el precio
		return 0;
	}

}
