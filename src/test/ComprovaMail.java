package test;

public class ComprovaMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String correcte = new String("mai.l@mail.com");
		if (correcte.contains("@")) {
			String resta = correcte.substring(correcte.indexOf('@'));
			if (resta.contains(".")) {
				System.out.println("correcte");
			} else {
				System.out.println("Incorrecte");
			}
		} else {
			System.out.println("Incorrecte");
		}
	}

}
