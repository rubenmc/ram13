package test;

import java.util.Scanner;

import main.BD;

public class LoginTest {

	public static void main(String[] args) {
		BD bd = new BD();
		Scanner scan = new Scanner(System.in);
		System.out.print("usuari:");
		String usuari = scan.nextLine();
		System.out.print("pass:");
		String pass = scan.nextLine();
		try {
			int res = bd.connecta(usuari, pass);
			System.out.println(res);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scan.close();
		}

	}

}
