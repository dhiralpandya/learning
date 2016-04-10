package com.omt.learn;

public class StringIntern {

	public static void main(String args[]) {

		String s1 = "omt";
		String s2 = "omt";

		System.out.println(s1 == s2);

		String s3 = new String("omt").intern();

		System.out.println(s1 == s3);

	}

}
