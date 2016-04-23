package com.omt.learn.algo;

public class RotateImage {

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
		printImage(image);

		rotate(image);
		System.out.println("--------");
		printImage(image);

	}

	public static void printImage(int[][] i) {
		for (int[] p : i) {
			for (int px : p) {
				System.out.print(px + " ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int size = n - 1;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil((n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[size - j][i];
				matrix[size - j][i] = matrix[size - i][size - j];
				matrix[size - i][size - j] = matrix[j][size - i];
				matrix[j][size - i] = temp;
			}
		}
	}

	public static void flipImg(int[][] img, int n) {

		for (int i = 0; i < n / 2; i++) {

			int count = n - 1 - i;
			int k = i;

			for (int j = k; j < count; j++) {

				int o = j - k;

				int temp = img[k][j];
				img[k][j] = img[count - o][k];
				img[count - o][k] = img[count][count - o];
				img[count][count - o] = img[j][count];
				img[j][count] = temp;
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

				matrix[last][last - offset] = matrix[i][last];

				// top -> right

				matrix[i][last] = top; // right <- saved top

			}

		}
	}

}
