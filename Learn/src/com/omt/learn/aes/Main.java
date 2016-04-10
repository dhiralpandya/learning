package com.omt.learn.aes;

import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		// KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		// keyGen.init(256);
		//
		// SecretKey keyOne = keyGen.generateKey();
		// SecretKey keyTwo = keyGen.generateKey();
		//
		// System.out.println("Key One :" + keyOne.getEncoded());
		// System.out.println("Key Two :" + keyTwo.getEncoded());

		String[] s = new String[2];
		s[0] = "Dhiral Pandya <dhiral_pandya@apple.com>";
		s[1] = "Unlock Support <unlock-support@group.apple.com>";

		System.out.println(s.toString());

	}

}
