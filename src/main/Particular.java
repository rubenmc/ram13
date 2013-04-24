package main;

import java.sql.Date;

public class Particular extends Persona {

	private Date dataNaixement;

	public Particular(int id, String nom, String telf, String NIF, String mail,
			Date data) {
		super(id, nom, telf, NIF, mail);
		this.dataNaixement = data;
	}

	/**
	 * @return the dataNaixement
	 */
	public Date getDataNaixement() {
		return dataNaixement;
	}

	/**
	 * @param data
	 *            the dataNaixement to set
	 */
	public void setDataNaixement(Date data) {
		this.dataNaixement = data;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public void display() {
		super.display();
		System.out.println("Data de naixement-->" + dataNaixement);

	}

}
