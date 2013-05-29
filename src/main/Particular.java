package main;

import java.sql.Date;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public class Particular extends Persona {

	private Date dataNaixement;

	// Constructor
	/**
	 * 
	 * @param id
	 *            L'identificador del particular
	 * @param nom
	 *            El nom del particular
	 * @param telf
	 *            El telefon del particular
	 * @param NIF
	 *            El NIF del particular
	 * @param mail
	 *            El mail del particular
	 * @param data
	 *            La data de naixement del particular
	 */
	public Particular(String id, String nom, String telf, String NIF,
			String mail, Date data) {
		super(id, nom, telf, NIF, mail);
		this.dataNaixement = data;
	}

	// Getters i Setters
	/**
	 * @return La data de naixement
	 */
	public Date getDataNaixement() {
		return dataNaixement;
	}

	/**
	 * @param data
	 *            La nova data de naixement
	 */
	public void setDataNaixement(Date data) {
		this.dataNaixement = data;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Data de naixement-->" + dataNaixement);

	}

}
