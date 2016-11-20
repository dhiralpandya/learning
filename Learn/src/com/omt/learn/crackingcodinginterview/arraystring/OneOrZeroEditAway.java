package com.omt.learn.crackingcodinginterview.arraystring;

public class OneOrZeroEditAway {

	public static void main(String[] args) {

		String s1 = "palq";
		String s2 = "pal";
		System.out.println(isOneStepAway(s1, s2));
	}

	public static boolean isOneStepAway(String s1, String s2) {

		String longString = s1.length() > s2.length() ? s1 : s2;
		String smallString = s1.length() < s2.length() ? s1 : s2;

		if (longString.length() - smallString.length() > 1) {
			return false;
		} else {

			int longPointer = 0;
			int smallPointer = 0;

			while (longPointer < longString.length() && smallPointer < smallString.length()) {

				if (longString.charAt(longPointer) != smallString.charAt(smallPointer)) {
					if (longPointer == smallPointer) {
						longPointer++;
					} else {
						return false;
					}
				} else {
					longPointer++;
					smallPointer++;
				}

			}

		}

		return true;
	}

}
