package com.omt.learn.algo;

public class ShortestPalindrome {

	public static void main(String[] args) {

		String text = "abab";// "abc";
		String newText = text + org.apache.commons.lang3.StringUtils.reverse(text);
		int kmp[] = generateKMPArray(newText);

		String shortestPalindrome = "";
		for (int i = text.length(); i < newText.length() - kmp[kmp.length - 1]; i++) {
			shortestPalindrome += newText.charAt(i);
		}

		shortestPalindrome += text;

		System.out.println("Shortest Palindrome : " + shortestPalindrome);

	}

	public static int[] generateKMPArray(String s) {
		int a[] = new int[s.length()];
		char c[] = s.toCharArray();

		int i = 0;
		for (int j = 1; j < s.length(); j++) {
			if (c[i] == c[j]) {
				i++;
				a[j] = i;
			} else if (i != 0) {
				i = a[i - 1];
			}
		}

		return a;
	}

}
