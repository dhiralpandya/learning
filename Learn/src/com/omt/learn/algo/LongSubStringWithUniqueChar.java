package com.omt.learn.algo;

public class LongSubStringWithUniqueChar {

	private static boolean[] cache = new boolean[256];

	public static void main(String args[]) {
		System.out.println("Large Substring with distinct characters :" + getLargestSubString("omtomsairam"));
	}

	public static String getLargestSubString(String s) {
		StringBuilder result = new StringBuilder();
		generateLargestSubString(s, result);
		return result.toString();
	}

	public static void generateLargestSubString(String s, StringBuilder result) {

		if (s.length() > 0) {
			char c = s.charAt(0);
			if (!cache[c]) {
				cache[c] = true;
				result.append(c);
			}

			generateLargestSubString(s.substring(1), result);
		}
	}

}
