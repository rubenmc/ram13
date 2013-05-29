package main;

/**
 * 
 * @author Ruben Macias i Albert Llauradó
 * 
 */
public class Majorista extends Persona {

	private String personaContacte;

	// Constructor
	/**
	 * 
	 * @param id
	 *            L'identificador del majorista
	 * @param nom
	 *            El nom del majorista
	 * @param telf
	 *            El telefon del majorista
	 * @param NIF
	 *            El NIF del majorista
	 * @param mail
	 *            El mail del majorista
	 * @param persona
	 *            La persona de contacte del majorista
	 */
	public Majorista(String id, String nom, String telf, String NIF,
			String mail, String persona) {
		super(id, nom, telf, NIF, mail);
		this.personaContacte = persona;
	}

	// Getters i Setters
	/**
	 * @return La persona de contacte
	 */
	public String getPersonaContacte() {
		return personaContacte;
	}

	/**
	 * @param personaContacte
	 *            La nova persona de contacte
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
