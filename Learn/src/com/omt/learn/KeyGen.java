package com.omt.learn;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyGen {

	public static void main(String args[]) throws NoSuchAlgorithmException {

		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);

		SecretKey sk = keyGen.generateKey();
		System.out.println(sk.getEncoded());

		byte[] encoded = sk.getEncoded();// Key data

		SecretKey secretKey = new SecretKeySpec(encoded, "AES");

		System.out.println(secretKey.equals(sk));
	}

}
