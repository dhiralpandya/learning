package com.omt.learn.algo.allAlgos;

public class HousesWithMoney {

	public static void main(String[] args) {
		// int a[] = { 8, 10, 10, 40, 50, 35 };
		int a[] = { 8, 5, 10, 40, 50, 35 };
		System.out.println(maxValue(a, 0));

	}

	public static int maxValue(int a[], int i) {

		if (i >= a.length) {
			return 0;
		}

		int one = a[i] + maxValue(a, i + 2);
		int two = a[i] + maxValue(a, i + 3);
		int three = maxValue(a, i + 1);

		return Math.max(Math.max(one, two), three);

	}

}
