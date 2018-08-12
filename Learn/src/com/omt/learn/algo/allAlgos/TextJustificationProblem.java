package com.omt.learn.algo.allAlgos;

public class TextJustificationProblem {

	public static void main(String[] args) {
		String[] a = { "Abcdef", "Xyz", "Likes", "To", "Code" };
		// String[] a = { "omt", "omt", "omt", "omt" };
		int width = 10;
		printText(a, width);
	}

	public static void printText(String[] a, int width) {

		int matrix[][] = new int[a.length][a.length];
		int totals[] = new int[a.length];
		int flag[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {

			matrix[i][i] = width - a[i].length();

			for (int j = i + 1; j < a.length; j++) {

				matrix[i][j] = matrix[i][j - 1] - a[j].length() - 1;

			}

		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (matrix[i][j] < 0) {
					matrix[i][j] = Integer.MAX_VALUE;
				} else {
					matrix[i][j] = (int) Math.pow(matrix[i][j], 2);
				}
			}
		}

		printMatrix(matrix);

		totals[a.length - 1] = matrix[a.length - 1][a.length - 1];
		flag[a.length - 1] = a.length;
		for (int i = a.length - 2; i >= 0; i--) {
			for (int j = a.length - 1; j >= i; j--) {
				if (matrix[i][j] != Integer.MAX_VALUE) {
					int v = matrix[i][j];
					if (j == a.length - 1) {
						totals[i] = v;
						flag[i] = j + 1;
					} else {
						v += totals[j + 1];
						if (totals[i] == 0 || totals[i] > v) {
							totals[i] = v;
							flag[i] = j + 1;
						}
					}
				}
			}

		}

		for (int t : totals) {
			System.out.print(" " + t);
		}
		System.out.println();
		for (int f : flag) {
			System.out.print(" " + f);
		}
		System.out.println();

		int i = 0;
		int j = 0;
		String ss = "";

		do {
			j = flag[i];

			for (int k = i; k < j; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
			i = j;
		} while (j < a.length);

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
