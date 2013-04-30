package main;

public class Mayorista extends Persona {

	private String personaContacte;

	// Constructor
	public Mayorista(int id, String nom, String telf, String NIF, String mail,
			String persona) {
		super(id, nom, telf, NIF, mail);
		this.personaContacte = persona;
	}

	// Getters i Setters
	/**
	 * @return the personaContacte
	 */
	public String getPersonaContacte() {
		return personaContacte;
	}

	/**
	 * @param personaContacte
	 *            the personaContacte to set
	 */
	public void setPersonaContacte(String personaContacte) {
		this.personaContacte = personaContacte;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Persona de contacte-->" + personaContacte);

	}

}
