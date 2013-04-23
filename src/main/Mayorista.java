package main;

public class Mayorista extends Persona {

	private String personaContacte;

	public Mayorista(int id, String nom, String telf, String NIF, String mail,
			String persona) {
		super(id, nom, telf, NIF, mail);
		this.personaContacte = persona;
	}

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

	public void display() {
		super.display();
		System.out.println("Persona de contacte-->" + personaContacte);

	}

}
