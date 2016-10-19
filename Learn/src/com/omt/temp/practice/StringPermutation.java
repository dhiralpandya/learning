package com.omt.temp.practice;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

	public static void main(String[] args) {
		allPossiblePermutation("", "abc").forEach(s -> {
			System.out.println(s);
		});
	}

	public static Set<String> allPossiblePermutation(String r, String s) {
		Set<String> set = new HashSet<>();

		if (s.isEmpty()) {
			set.add(r);
			return set;
		}

		for (int i = 0; i < s.length(); i++) {
			set.addAll(allPossiblePermutation(r + s.charAt(i), s.substring(0, i) + s.substring(i + 1)));
		}

		return set;
	}

}
