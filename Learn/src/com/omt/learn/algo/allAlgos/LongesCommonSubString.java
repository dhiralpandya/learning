package com.omt.learn.algo.allAlgos;

public class LongesCommonSubString {

	public static void main(String[] args) {
		String s1 = "abcdaf";
		String s2 = "zbcdf";
		System.out.println("Longest substring is :" + findLongesSubstring(s1, s2));

	}

	public static String findLongesSubstring(String s1, String s2) {
		String ss = "";

		int[][] matrix = new int[s2.length() + 1][s1.length() + 1];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int maxLenghtAt_i = 0;
		int maxLengthAt_j = 0;
		int maxLenghtFound = 0;

		for (int i = 1; i < s2.length() + 1; i++) {
			char cInRow = c2[i - 1];
			for (int j = 1; j < s1.length() + 1; j++) {
				if (cInRow == c1[j - 1]) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
					if (matrix[i][j] > maxLenghtFound) {
						maxLenghtFound = matrix[i][j];
						maxLenghtAt_i = i;
						maxLengthAt_j = j;
					}
				}
			}
		}

		printMatrix(matrix);

		System.out.println("Max lenght of substring is :" + maxLenghtFound);

		while (maxLenghtAt_i >= 0 && maxLengthAt_j >= 0 && matrix[maxLenghtAt_i][maxLengthAt_j] > 0) {
			ss = c2[maxLenghtAt_i - 1] + ss;
			maxLenghtAt_i--;
			maxLengthAt_j--;
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
