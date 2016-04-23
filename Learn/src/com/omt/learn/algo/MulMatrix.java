package com.omt.learn.algo;

public class MulMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] image = new int[n][n];

		int count = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				image[i][j] = count++;

			}
		}

		printMatrix(image);
		System.out.println("--------");
		mulMatrix(image, image);
	}

	public static void mulMatrix(int[][] m1, int[][] m2) {
		int n = m1.length;

		int[][] mulMatrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			int c1 = 0;
			int c2 = 0;
			for (int j = 0; j < n * n; j++) {

				if (c1 == n) {
					c1 = 0;
					c2++;
				}
				mulMatrix[i][c2] += m1[i][c1] * m2[c1][c2];

				c1++;

			}
		}

		printMatrix(mulMatrix);

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
