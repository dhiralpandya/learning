package com.omt.learn.algo;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;

public class Base64Example {

	public static void main(String args[]) throws NoSuchAlgorithmException {

		String s = "This is the encoding and decoding using JAVA 8 Base64 util";

		Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(s.getBytes());
		System.out.println("Encoded String : " + encodedString);

		Decoder decoder = Base64.getDecoder();
		String decodedString = new String(decoder.decode(encodedString));
		System.out.println("Decoded String : " + decodedString);

		System.out.println(Cipher.getMaxAllowedKeyLength("AES"));

	}

}
