package com.omt.learn.algo.allAlgos;

//Best way to generate palindrome of string.
public class StringPalindrome {

	public static void main(String[] args) {
		exampleTwo();
	}

	public static void exampleOne() {
		String s = "abc";
		// abccba

		StringBuilder sb1 = new StringBuilder(s.length());
		StringBuilder sb2 = new StringBuilder(s.length());

		int size = s.length() - 1;
		for (int i = 0; i < s.length(); i++, size--) {

			sb1.append(s.charAt(i));
			sb2.append(s.charAt(size));

		}

		sb1.append(sb2.toString());
		System.out.println(sb1.toString());
	}

	public static void exampleTwo() {

		int a[] = generatePatternArray("abcabbacba");
		for (int i : a) {
			System.out.println(i);
		}

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
