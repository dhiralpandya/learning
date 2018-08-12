package com.omt.learn.algo.allAlgos;

import java.util.Arrays;

public class NIntegersAmazon {

	public static void main(String[] args) {

		int i = 1;
		int a[] = { 2, 2, 3, 3, 5 };
		int a2[] = { 2, 2, 3, 3, 5 };
		calculateDuplicate(a, 5);
		for (int n : a) {
			System.out.println((i) + " : " + Math.abs(n));
			i++;
		}

		System.out.println(a.toString());
		System.out.println(a2.toString());

	}

	public static void calculateDuplicate(int[] a, int n) {

		Arrays.sort(a);

		int currentPosition = 0;
		int validPosition = 0;
		while (currentPosition < n) {

			if (a[currentPosition] <= 0) {
				currentPosition++;
				continue;
			}

			validPosition = a[currentPosition] - 1;
			if (a[validPosition] > 0) {
				a[currentPosition] = a[validPosition];
				a[validPosition] = -1;
			} else {
				a[currentPosition] = 0;
				a[validPosition]--;
				currentPosition++;
			}

		}

	}

}
