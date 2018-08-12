package com.omt.learn.algo.allAlgos;

public class StringInterleaving {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "xyz";
		String s12 = "axbycz";
		System.out.println(isStringMadeOfTwoString(s1, s2, s12));

	}

	public static boolean isStringMadeOfTwoString(String s1, String s2, String s12) {

		if (s1.length() + s2.length() != s12.length()) {
			return true;
		}

		boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		char c12[] = s12.toCharArray();

		int maxSize = Math.max(s1.length(), s2.length());

		matrix[0][0] = true;
		for (int i = 1; i < maxSize + 1; i++) {
			if (i < s2.length() + 1) {
				if (c2[i - 1] == c12[i - 1] && matrix[i - 1][0]) {
					matrix[i][0] = true;
				}
			}

			if (i < s1.length() + 1) {
				if (c1[i - 1] == c12[i - 1] && matrix[0][i - 1]) {
					matrix[0][i] = true;
				}
			}
		}

		// printMatrix(matrix);

		for (int i = 1; i < s2.length() + 1; i++) {
			for (int j = 1; j < s1.length() + 1; j++) {
				if (c1[j - 1] == c12[j + i - 1] && matrix[i][j - 1]) {
					matrix[i][j] = true;
				} else if (c2[i - 1] == c12[j + i - 1] && matrix[i - 1][j]) {
					matrix[i][j] = true;
				}

			}
		}

		printMatrix(matrix);

		return matrix[s2.length()][s1.length()];

	}

	public static void printMatrix(boolean[][] i) {
		System.out.println("-------------");
		for (boolean[] p : i) {
			for (boolean px : p) {

				System.out.print((px ? "T" : "F") + " ");

			}
			System.out.println("");
		}
	}

}
