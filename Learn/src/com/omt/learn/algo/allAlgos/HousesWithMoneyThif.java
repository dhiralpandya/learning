package com.omt.learn.algo.allAlgos;

public class HousesWithMoneyThif {

	public static void main(String[] args) {
		int a[] = { 100, 4, 1, 6, 1, 8, 8, 98 };//
		// int a[] = { 8, 5, 10, 40, 50, 35 };
		System.out.println(getMaxTotal(a));
		System.out.println(maxValue(a, 0));

	}

	/**
	 * Method ONE
	 */
	public static int getMaxTotal(int a[], int i) {

		if (i >= a.length) {
			return 0;
		}

		int one = a[i] + getMaxTotal(a, i + 2);
		int two = getMaxTotal(a, i + 1);

		return Math.max(one, two);

	}

	/**
	 * Method TWO
	 */
	public static int getMaxTotal(int a[]) {

		int nextElement = a[0];
		int justGotChance = a[1];

		for (int i = 2; i < a.length; i++) {
			int tempBigElement = Math.max(nextElement, justGotChance);
			nextElement += a[i];
			justGotChance = nextElement;
			nextElement = tempBigElement;
		}
		return Math.max(nextElement, justGotChance);
	}

	/**
	 * Method THREE
	 */
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
