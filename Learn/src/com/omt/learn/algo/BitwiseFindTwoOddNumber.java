package com.omt.learn.algo;

public class BitwiseFindTwoOddNumber {

	public static void main(String[] args) {

		int a[] = { 4, 2, 6, 3, 4, 5, 6, 5, 2, 7 };

		int xor = xorOfTwoOddNumber(a);
		int position = findFirstOneAtPosition(xor);
		printThoseTwoNumbers(a, position);

	}

	public static int xorOfTwoOddNumber(int a[]) {

		int xor = a[0];

		for (int i = 1; i < a.length; i++) {
			xor ^= a[i];
		}

		return xor;

	}

	public static int findFirstOneAtPosition(int xor) {

		int position = 0;

		while ((xor & 1) != 1) {
			xor = xor >> 1;
			position++;
		}

		return position;

	}

	public static void printThoseTwoNumbers(int a[], int positionOfOne) {

		Integer xor0 = null;
		Integer xor1 = null;

		for (int i = 0; i < a.length; i++) {

			if (((a[i] >> positionOfOne) & 1) == 1) {
				if (xor1 == null) {
					xor1 = a[i];
				} else {
					xor1 ^= a[i];
				}
			} else {
				if (xor0 == null) {
					xor0 = a[i];
				} else {
					xor0 ^= a[i];
				}
			}

		}

		System.out.println("First number is :" + xor0);
		System.out.println("Second number is :" + xor1);

	}

}
