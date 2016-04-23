package com.omt.learn.algo;

import java.util.Stack;

public class MatrixWithZero {

	public static void main(String args[]) {
		int n = 4;
		int[][] image = new int[n][n];

		int count = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (count == 10 || count == 7) {
					image[i][j] = 0;
				} else {
					image[i][j] = count;
				}
				count++;
			}
		}

		printImage(image);
		processMatrix(image);
		System.out.println("-----------");
		printImage(image);
	}

	public static void printImage(int[][] i) {
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

	public static void processMatrix(int[][] matrix) {

		Stack<Integer> rowClm = new Stack<>();

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowClm.push(i);
					rowClm.push(j);
				}
			}

		}

		while (!rowClm.isEmpty()) {
			int col = rowClm.pop();
			int row = rowClm.pop();

			int colSize = matrix[row].length;
			int rowSize = matrix.length;

			int count = Math.max(colSize, rowSize);

			for (int i = 0; i < count; i++) {
				if (i < rowSize) {
					matrix[i][col] = 0;
				}

				if (i < colSize) {
					matrix[row][i] = 0;
				}
			}

		}

	}

}
