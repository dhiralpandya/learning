package com.omt.learn.algo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AllPossibleUniqueSubString {

	public static void main(String[] args) {

		List<String> allLargestSubStrings = new LinkedList<>();
		String currentLargestString = "";
		for (String s : allPossibleUniqueSubString("omtomsairam", "")) {
			if (s.length() > currentLargestString.length()) {
				currentLargestString = s;
				allLargestSubStrings.clear();
				allLargestSubStrings.add(s);
			} else if (s.length() == currentLargestString.length()) {
				allLargestSubStrings.add(s);
			}
		}
		System.out.println("All possible largest substrings with distinct characters");
		for (String s : allLargestSubStrings) {
			System.out.println(s);
		}
	}

	public static Set<String> allPossibleUniqueSubString(String input, String result) {

		Set<String> setOfStrings = new HashSet<>();

		if (input.length() > 0) {

			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);

				if (!result.contains(c + "")) {
					setOfStrings.addAll(allPossibleUniqueSubString(input.substring(i), result + c));
				}
			}

		}
		setOfStrings.add(result);

		return setOfStrings;

	}

}
