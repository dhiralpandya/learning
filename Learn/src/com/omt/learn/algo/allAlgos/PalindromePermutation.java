package com.omt.learn.algo.allAlgos;

import java.util.Arrays;

public class PalindromePermutation {

	public static void main(String[] args) {

		System.out.println(isPermutationPalindrome("abcabcz"));
	}

	public static boolean isPermutationPalindrome(String s) {
		char c[] = s.toCharArray();
		Arrays.sort(c);

		int oddCount = 0;

		for (int i = 0; i < c.length; i++) {
			if (i + 1 >= c.length) {
				oddCount++;
				continue;
			}
			if (c[i] == c[i + 1]) {
				i++;
			} else {
				oddCount++;
			}
		}

		return oddCount < 2;
	}

}
