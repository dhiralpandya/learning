package com.omt.learn.algo.allAlgos;

import org.apache.commons.lang3.StringUtils;

public class PalindromeString {

	public static void main(String args[]) {
		// isPalindrome("abaxbabax", 2);
		String s = "abaxbababxa";
		String s2 = StringUtils.reverse(s);
		editDistanceMethod(s, s2, 2);
	}

	public static void editDistanceMethod(String s, String s2, int n) {

		char ch[] = s.toCharArray();
		char ch2[] = s2.toCharArray();

		int[][] matrix = new int[ch.length + 1][ch.length + 1];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			matrix[0][i] = count;
			matrix[i][0] = count++;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if (ch[i - 1] == ch2[j - 1]) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
				}
			}
		}

		int minCount = matrix[matrix.length - 1][matrix.length - 1];
		System.out.println(minCount);
		if (n * 2 >= minCount)

		{
			System.out.println("YES");
		}

		printMatrix(matrix);

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
