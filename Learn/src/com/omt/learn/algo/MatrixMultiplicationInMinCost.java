package com.omt.learn.algo;

public class MatrixMultiplicationInMinCost {

	public static void main(String... arg) {
		int a[] = { 4, 2, 3, 5, 3 };
		int cost = costOfMatrixMultiplication(a);
		System.out.println("Find cost :" + cost);
	}

	public static int costOfMatrixMultiplication(int matrixRowColumns[]) {
		int[][] costMatrix = new int[matrixRowColumns.length][matrixRowColumns.length];

		for (int l = 2; l < matrixRowColumns.length; l++) {
			for (int i = 0; i < matrixRowColumns.length - l; i++) {

				int j = l + i;
				costMatrix[i][j] = Integer.MAX_VALUE;

				for (int k = i + 1; k < j; k++) {
					int cal = costMatrix[i][k] + costMatrix[k][j]
							+ matrixRowColumns[i] * matrixRowColumns[k] * matrixRowColumns[j];
					if (cal < costMatrix[i][j]) {
						costMatrix[i][j] = cal;
					}
				}

			}
		}

		// printMatrix(costMatrix);
		return costMatrix[0][matrixRowColumns.length - 1];
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