package com.omt.learn.algo.allAlgos;

public class SubsetSumProblem {

	public static void main(String[] args) {
		int a[] = { 2, 3, 7, 8, 10 };
		int find = 5;
		System.out.println(isFound(a, 0, find));

	}

	public static boolean isFound(int a[], int i, int remainingFind) {

		if (i >= a.length) {
			return false;
		}
		if (remainingFind == 0) {
			return true;
		}

		boolean v1 = false || isFound(a, i + 1, remainingFind - a[i]);
		boolean v2 = false || isFound(a, i + 1, remainingFind);

		return v1 || v2;
	}

}