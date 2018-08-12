package com.omt.learn.algo.allAlgos;

public class KMPStringMatching {

	public static void main(String[] args) {

		// String pattern = "abcdabca";
		// String pattern = "aabaabaaa";
		String pattern = "abcaby";
		String s = "abxabcabcaby";
		int[] a = generatePatternArray(pattern);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Is string contains pattern :" + isStringContainsPattern(s, pattern, a));

	}

	public static boolean isStringContainsPattern(String s, String pattern, int a[]) {

		char sc[] = s.toCharArray();
		char pc[] = pattern.toCharArray();

		int i = 0;
		for (int j = 0; j < s.length();) {

			if (i >= a.length - 1) {
				return true;
			}

			if (pc[i] == sc[j]) {
				i++;
				j++;
			} else if (i == 0) {
				j++;
			} else {
				i = a[i - 1];
			}

		}

		return false;

	}

	public static int[] generatePatternArray(String pattern) {
		int[] a = new int[pattern.length()];
		char[] c = pattern.toCharArray();

		int i = 0;

		for (int j = 1; j < a.length;) {

			if (c[i] == c[j]) {
				a[j] = i + 1;
				j++;
				i++;
			} else if (i == 0) {
				a[j] = 0;
				j++;
			} else {
				i = a[i - 1];
			}

		}

		return a;
	}

}
