package test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestCodifica {

	public static void main(String[] args) throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		String originalPassword = new String(
				"En un lugar de la mancha de cullo nombre no me quiero recordar");
		String originalPassword2 = new String("ruben");

		byte[] plainText = originalPassword.getBytes("UTF8");
		byte[] plainText2 = originalPassword2.getBytes("UTF8");

		System.out.println(originalPassword);
		System.out.println(originalPassword2);
		// get a message digest object using the MD5 algorithm
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		// print out the provider used
		// System.out.println("\n" + messageDigest.getProvider().getInfo());

		// calculate the digest and print it out
		messageDigest.update(plainText);
		System.out.println("\nDigest: ");

		byte[] digest = messageDigest.digest();
		StringBuilder sb = new StringBuilder();
		for (byte d : digest) {
			sb.append(String.format("%02x", d));
		}
		System.out.println(sb.toString());

		messageDigest.update(plainText2);
		System.out.println("\nDigest: ");

		byte[] digest2 = messageDigest.digest();
		StringBuilder sb2 = new StringBuilder();
		for (byte d : digest2) {
			sb2.append(String.format("%02x", d));
		}
		System.out.println(sb2.toString());
	}

}
