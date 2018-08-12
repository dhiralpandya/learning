package com.omt.learn.algo.allAlgos;

import java.util.Arrays;

public class MaxProductOfThree {

	public static void main(String[] args) {

		int[] a = { 6, 7, 8, 1, 2, 3, 9, 10 };

		for (int i : maxProduct(a, 3)) {
			System.out.print(i + " ");
		}

	}

	public static int[] maxProduct(int a[], int n) {

		Arrays.sort(a);

		int[] r = new int[n];

		int j = n - 1;
		for (int i = a.length - 1; j >= 0; i--, j--) {
			r[j] = a[i];
		}

		return r;

	}

}
