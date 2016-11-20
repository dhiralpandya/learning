package com.omt.learn.algo;

public class SubSetSumProblemDy {

	public static void main(String[] args) {

		int a[] = { 2, 3, 7, 8, 10 };
		int total = 21;

		System.out.println(isSubsetsum(a, total));

	}

	public static boolean isSubsetsum(int a[], int total) {

		boolean m[][] = new boolean[a.length][total + 1];

		for (int count = 0; count < a.length; count++) {
			m[count][0] = true;
		}

		if (a[0] < total) {
			m[0][a[0]] = true;
		}

		for (int row = 1; row < a.length; row++) {

			for (int col = 1; col < total + 1; col++) {
				if (col < a[row]) {
					m[row][col] = m[row - 1][col];
				} else {
					m[row][col] = m[row - 1][col] || m[row - 1][col - a[row]];
				}
			}

		}

		return m[a.length - 1][total];

	}

}
