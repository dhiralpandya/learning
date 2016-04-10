package com.omt.learn.algo;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class AESEncriptionDecription {

	public static void main(String args[]) throws Exception {
		String data = "omt om sai ram";

		SecretKey key = generateKey();

		System.out.println("Encrypted Data");
		String encryptedData = encryptData(data, key);
		System.out.println(encryptedData);

		System.out.println("Decrypted Data");
		System.out.println(decryptData(encryptedData, key));

	}

	private static String encryptData(String data, SecretKey key) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] en = cipher.doFinal(data.getBytes());
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(en);
	}

	private static String decryptData(String data, SecretKey key) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Base64.Decoder decoder = Base64.getDecoder();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		return new String(cipher.doFinal(decoder.decode(data)));
	}

	private static SecretKey generateKey() {
		KeyGenerator keyGenerator = null;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// Please Handle exception here....
		}

		keyGenerator.init(256);
		return keyGenerator.generateKey();
	}

}
