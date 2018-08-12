package com.omt.learn.algo.allAlgos;

public class FlipImage {

	public static void main(String[] args) {

		int n = 4;
		int[][] img = new int[n][n];

		int px = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				img[i][j] = px++;
			}
		}

		printImage(img);
		System.out.println("-----");
		rotate(img, n);
		System.out.println("-----");
		printImage(img);
	}

	public static void printImage(int[][] img) {

		for (int[] a : img) {
			for (int n : a) {
				System.out.print(n + " ");
			}
			System.out.println("");
		}

	}

	public static void flipImage(int[][] img, int n) {

		int count = n - 1;

		for (int i = 0; i < n / 2; i++) {

			for (int j = 0; j < n; j++) {

				int temp = img[i][j];
				img[i][j] = img[count - i][j];
				img[count - i][j] = img[count - i][count - j];
				img[count - i][count - j] = img[i][count - j];
				img[i][count - j] = temp;
				System.out.println("[" + i + "][" + j + "]");
				printImage(img);
			}

		}

	}

	public static void rotate(int[][] matrix, int n) {

		for (int layer = 0; layer < n / 2; ++layer) {

			int first = layer;

			int last = n - 1 - layer;

			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; // top -> right
				matrix[i][last] = top; // right <- saved top

			}

		}

	}

}
