package main;
/**
 * 
 * @author Ruben Macias i Albert Llauradó
 *
 */
public class Unitat {

	private int id;
	private int tenda;
	private int joc;

	// Constructor
	/**
	 * @param id
	 *            Identificardor de la unitat
	 * @param tenda
	 *            Identificador de la tenda a la que pertany
	 * @param joc
	 *            Identificador del joc al que pertany
	 */
	public Unitat(int id, int tenda, int joc) {
		this.id 	= id;
		this.tenda 	= tenda;
		this.joc 	= joc;
	}

	// Getters i Setters
	/**
	 * @return l'id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            el nou id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return la tenda
	 */
	public int getTenda() {
		return tenda;
	}

	/**
	 * @param tenda
	 *            la nova tenda
	 */
	public void setTenda(int tenda) {
		this.tenda = tenda;
	}

	/**
	 * @return el joc
	 */
	public int getJoc() {
		return joc;
	}

	/**
	 * @param joc
	 *            el nou joc
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
}
