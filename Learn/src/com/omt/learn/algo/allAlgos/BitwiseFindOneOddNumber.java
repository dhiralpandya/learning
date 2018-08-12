package com.omt.learn.algo.allAlgos;

public class BitwiseFindOneOddNumber {

	public static void main(String[] args) {

		int a[] = { 4, 2, 6, 3, 4, 5, 6, 5, 2 };

		System.out.println(" Number is : " + oddNumberIs(a));

	}

	public static int oddNumberIs(int a[]) {

		int xor = a[0];

		for (int i = 1; i < a.length; i++) {
			xor ^= a[i];
		}

		return xor;

	}

}
