package com.omt.learn.crackingcodinginterview.arraystring;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compression("aaabbbcccaa"));
	}

	public static String compression(String s) {
		StringBuilder sb = new StringBuilder();
		String compressed = "";

		for (int i = 0; i < s.length();) {

			int count = 1;
			char c = s.charAt(i);

			i++;
			while (i < s.length() && c == s.charAt(i)) {
				i++;
				count++;
			}
			sb.append(c).append(Integer.toString(count));
		}

		compressed = sb.toString();

		return compressed.length() < s.length() ? compressed : s;
	}

}
