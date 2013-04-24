package main;

public class Unitat {

	private int id;
	private Tenda tenda;
	private Joc joc;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param tenda
	 * @param joc
	 */
	public Unitat(int id, Tenda tenda, Joc joc) {
		this.id = id;
		this.tenda = tenda;
		this.joc = joc;
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
	 * @return the tenda
	 */
	public Tenda getTenda() {
		return tenda;
	}

	/**
	 * @param tenda
	 *            the tenda to set
	 */
	public void setTenda(Tenda tenda) {
		this.tenda = tenda;
	}

	/**
	 * @return the joc
	 */
	public Joc getJoc() {
		return joc;
	}

	/**
	 * @param joc
	 *            the joc to set
	 */
	public void setJoc(Joc joc) {
		this.joc = joc;
	}

	@Override
	public String toString() {
		return joc.getNom() + "." + id;
	}

	public void display() {
		System.out.println("\nDades de la unitat " + id + " del joc"
				+ joc.getNom() + "\nTenda-->" + tenda.getId() + "\nPreu-->"
				+ joc.getPreu());
	}

}
