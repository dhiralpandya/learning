package com.omt.learn.practice;

public class AddBinary {

	public static void main(String args[]) {

		String a = "1101101";
		String b = "1011";
		System.out.println(addTwoBinary(a, b));
	}

	public static String addTwoBinary(String a, String b) {
		int aLength = a.length() - 1;
		int bLength = b.length() - 1;
		String result = "";
		int carry = 0;

		while (aLength > -1 || bLength > -1) {

			int aChar = 0;
			int bChar = 0;

			if (aLength > -1) {
				aChar = a.charAt(aLength) - '0';
			}
			if (bLength > -1) {
				bChar = b.charAt(bLength) - '0'; // ACCI 23 - 22 = 1
			}

			carry += aChar + bChar;

			// Here carry can be 1,2,3
			result = (carry % 2) + result;
			carry /= 2;

			aLength--;
			bLength--;
		}

		if (carry > 0) {
			result = "1" + result;
		}

		return result;

	}

}
