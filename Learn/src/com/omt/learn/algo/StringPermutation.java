package com.omt.learn.algo;

public class StringPermutation {

	public static void main(String[] args) {

		String input = "abc";
		permutation("", input);

	}

	private static void permutation(String prefix, String input) {

		if (input.length() == 0) {
			System.out.println(prefix);
		}

		for (int count = 0; count < input.length(); count++) {
			permutation(prefix + input.charAt(count), input.substring(0, count) + input.substring(count + 1));
		}

	}

}
