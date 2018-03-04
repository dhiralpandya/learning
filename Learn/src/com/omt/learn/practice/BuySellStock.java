package com.omt.learn.practice;

public final class BuySellStock {

	public static void main(String[] args) {

		int a[] = { 2, 3, 15, 0, 1, 5, 8, 10 };

		System.out.println("Get max difference :" + getMaxDifferece(a));

		int b[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Get max difference :" + getMaxDifferece(b));

	}

	public static int getMaxDifferece(int a[]) {
		int maxDifference = 0;

		int i = 0;
		for (int j = 1; j < a.length; j++) {
			if (a[j] > a[i]) {
				if ((a[j] - a[i]) > maxDifference) {
					maxDifference = a[j] - a[i];
				}
			} else {
				i = j;
			}
		}

		return maxDifference;
	}

}
