package com.omt.learn.algo;

public class CustomSortingAlgo {

	public static void main(String[] args) {

		char a[] = { 'z', 'q', 'a', 's', 'd', 'y', 'c' };
		String s[] = { "zasd", "qazyc", "yczaq", "caq", "czq", "dzaq", "czqa", "zzsd" };

		s = sortedStringArray(a, s);

		for (String string : s) {
			System.out.println(string);
		}

	}

	public static String[] sortedStringArray(char a[], String s[]) {
		return sortedStringArray(a, s, 0, s.length - 1);
	}

	public static String[] sortedStringArray(char a[], String s[], int start, int end) {

		int i = start;
		int j = end;

		String pivote = s[(start + end) / 2];
		// You can also use start+(end-start)/2 to avoid overflow.
		while (i <= j) {
			while (compareTo(a, s[i], pivote) < 0) {
				i++;
			}
			while (compareTo(a, s[j], pivote) > 0) {
				j--;
			}

			if (i <= j) {
				String temp = s[i];
				s[i] = s[j];
				s[j] = temp;
				i++;
				j--;
			}

		}

		if (i < end) {
			sortedStringArray(a, s, i, end);
		}

		if (j > start) {
			sortedStringArray(a, s, start, j);
		}

		return s;
	}

	public static int compareTo(char a[], String first, String second) {

		int min = Math.min(first.length(), second.length());

		int index = 0;
		while (min > 0) {

			if (first.charAt(index) != second.charAt(index)) {
				return getIndex(a, first.charAt(index)) - getIndex(a, second.charAt(index));
			}

			index++;
			min--;
		}

		return first.length() - second.length();
	}

	public static int getIndex(char a[], char c) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == c) {
				return i;
			}
		}

		return -1;
	}

}
