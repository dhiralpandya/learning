package com.omt.learn.algo;

public class MaxSizeSquareInMatrix {

	static int a[][] = { //
			{ 0, 1, 1, 0, 1, 1 }, //
			{ 1, 1, 0, 1, 1, 1 }, //
			{ 0, 1, 1, 1, 0, 0 }, //
			{ 1, 1, 1, 1, 0, 0 }, //
			{ 1, 1, 1, 1, 1, 0 }, //
			{ 0, 1, 1, 1, 0, 1 },//
	};

	static int b[][] = { //
			{ 0, 1, 1, 0, 0, 0 }, //
			{ 1, 1, 0, 0, 0, 0 }, //
			{ 0, 1, 1, 0, 0, 0 }, //
			{ 1, 1, 1, 1, 0, 0 }, //
			{ 1, 1, 1, 1, 1, 0 }, //
			{ 0, 1, 1, 1, 0, 1 },//
	};

	static int c[][] = { //
			{ 0, 1, 1, 0, 0, 0 }, //
			{ 1, 1, 0, 0, 1, 0 }, //
			{ 0, 1, 1, 0, 0, 0 }, //
			{ 1, 1, 1, 1, 0, 0 }, //
			{ 1, 1, 0, 1, 1, 0 }, //
			{ 0, 1, 1, 1, 0, 1 },//
	};

	static int d[][] = { //
			{ 0, 1, 1, 0, 0, 0 }, //
			{ 1, 1, 0, 0, 1, 0 }, //
			{ 0, 0, 1, 0, 1, 0 }, //
			{ 1, 1, 1, 1, 0, 0 }, //
			{ 1, 0, 0, 1, 1, 0 }, //
			{ 0, 1, 1, 1, 0, 1 },//
	};

	public static void main(String[] args) {

		System.out.println("Max square size for 1 is :" + findMaxSquareSize(1, a));
		System.out.println("Max square size for 0 is :" + findMaxSquareSize(0, a));

		System.out.println("Max square size for 1 is :" + findMaxSquareSize(1, b));
		System.out.println("Max square size for 0 is :" + findMaxSquareSize(0, b));

		System.out.println("Max square size for 1 is :" + findMaxSquareSize(1, c));
		System.out.println("Max square size for 0 is :" + findMaxSquareSize(0, c));

		System.out.println("Max square size for 1 is :" + findMaxSquareSize(1, d));
		System.out.println("Max square size for 0 is :" + findMaxSquareSize(0, d));

	}

	public static int findMaxSquareSize(int squareFor, int[][] matrix) {
		int maxSize = 0;

		int[][] temp = new int[matrix.length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[0][i] == squareFor) {
				temp[0][i] = 1;
			}

			if (matrix[i][0] == squareFor) {
				temp[i][0] = 1;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if (matrix[i][j] == squareFor) {
					int size = 1 + Math.min(temp[i - 1][j], Math.min(temp[i - 1][j - 1], temp[i][j - 1]));
					temp[i][j] = size;
					if (maxSize < size) {
						maxSize = size;
					}
				}
			}
		}

		return (maxSize > 1 ? maxSize : 0);
	}

}
