package main;

public class Proveidor extends Persona {

	private String personaContacte;
	private String compteCorrent;

	public Proveidor(int id, String nom, String telf, String NIF, String mail,
			String persona, String compte) {
		super(id, nom, telf, NIF, mail);
		this.personaContacte = persona;
		this.compteCorrent = compte;
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

	/**
	 * @return the compteCorrent
	 */
	public String getCompteCorrent() {
		return compteCorrent;
	}

	/**
	 * @param compteCorrent
	 *            the compteCorrent to set
	 */
	public void setCompteCorrent(String compte) {
		this.compteCorrent = compte;
	}

	public void display() {
		super.display();
		System.out.println("Persona de contacte-->" + personaContacte
				+ "\nCompte corrent-->" + compteCorrent);

	}

}
