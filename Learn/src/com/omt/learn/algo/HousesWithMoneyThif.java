package com.omt.learn.algo;

public class HousesWithMoneyThif {

	public static void main(String[] args) {
		int a[] = { 100, 4, 1, 6, 1, 8, 8, 98 };//
		// int a[] = { 8, 5, 10, 40, 50, 35 };
		System.out.println(getMaxTotal(a));

	}

	public static int getMaxTotal(int a[], int i) {

		if (i >= a.length) {
			return 0;
		}

		int one = a[i] + getMaxTotal(a, i + 2);
		int two = getMaxTotal(a, i + 1);

		return Math.max(one, two);

	}

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

}
