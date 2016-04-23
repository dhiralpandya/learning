package com.omt.learn.algo;

public class WaterGlass {

	static int CAPACITY_OF_GLASS = 1;

	public static void main(String[] args) {
		waterInGlass(11, 5, 2);
	}

	public static void waterInGlass(int x, int row, int glass) {
		int[][] matrix = new int[row][row];

		for (int i = 0; i < row; i++) {
			matrix[i][0] = 1;
			matrix[0][i] = 1;
		}

		for (int i = 1; i < row; i++) {
			int k = i;
			for (int j = 1; j <= i; j++) {
				matrix[k][j] = matrix[k - 1][j] + matrix[k][j - 1];
				k--;
			}

		}

		printMatrix(matrix);

		int r = row - 1;
		float usedWater = (r > 0 ? (float) ((r * (r + 1)) / 2) : 1.0f) * CAPACITY_OF_GLASS;
		float remainingWater = x - usedWater;
		float pow = (float) Math.pow(2, r);
		int g = glass - 1;
		float waterInGlass = remainingWater > 0 ? remainingWater * (matrix[r - g][g] / pow) : 0;

		System.out.println("Water In Glass :" + waterInGlass);

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
