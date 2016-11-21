package com.omt.learn.algo;

public class BinaryStringZOCount {

	public static void main(String[] args) {

		String s = "000111000";
		System.out.println("Count:" + validCount(s));

	}

	public static int validCount(String s) {
		int count = 0;

		for (int j = 1; j < s.length(); j++) {
			if (s.charAt(j - 1) != s.charAt(j)) {
				count++;

				if ((j - 1 > 0 && j + 1 < s.length()) && s.charAt(j - 1 - 1) != s.charAt(j + 1)) {
					count++;
					j++;
				}
			}

		}

		return count;
	}

}
