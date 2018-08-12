package com.omt.learn.algo.allAlgos;

public class LongesCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "abcdaf";
		String s2 = "acbcf";
		System.out.println(getCommonSubsequence(s1, s2));

	}

	// If both are same then 1+[i-1][j-1]
	// If both are not same then Max( [i][j-1],[i-1][j] )

	public static String getCommonSubsequence(String s1, String s2) {
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();

		int matrix[][] = new int[s2.length() + 1][s1.length() + 1];

		for (int i = 1; i < s2.length() + 1; i++) {
			for (int j = 1; j < s1.length() + 1; j++) {
				if (c2[i - 1] == c1[j - 1]) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				}
			}
		}

		printMatrix(matrix);

		System.out.println("String length :" + matrix[s2.length()][s1.length()]);
		String ss = "";

		int i = s2.length();
		int j = s1.length();

		while (i >= 1 && j >= 1) {
			if (c2[i - 1] == c1[j - 1]) {
				ss = c2[i - 1] + ss;
				i--;
				j--;
			} else if (matrix[i - 1][j] > matrix[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		return ss;

	}

	public static void printMatrix(int[][] i) {
		for (int[] p : i) {
			for (int px : p) {
				if (px > 9) {
					System.out.print(px + " ");
				} else {
					System.out.print(px + "  ");
				}
			}
			System.out.println();
		}
	}

}
