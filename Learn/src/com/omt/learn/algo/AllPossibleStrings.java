package com.omt.learn.algo;

import java.util.HashSet;
import java.util.Set;

public class AllPossibleStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String in = "ba";
		for (String s : allPossibleString("", in)) {
			System.out.println(s);
		}

	}

	private static Set<String> allPossibleString(String prefix, String input) {
		Set<String> set = new HashSet<>();

		if (input.length() == 0) {
			set.add(prefix);
			return set;
		}

		for (int i = 0; i < input.length(); i++) {

			set.addAll(allPossibleString(prefix + input.charAt(i), input.substring(i + 1)));

		}

		set.add(prefix);
		return set;

	}

}
