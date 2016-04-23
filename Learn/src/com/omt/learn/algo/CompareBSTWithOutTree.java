package com.omt.learn.algo;

import java.util.Arrays;

public class CompareBSTWithOutTree {

	public static void main(String[] args) {

		int a1[] = { 2, 1, 3 };
		int a2[] = { 2, 3, 1 };
		System.out.println("Is Both Tree Are Same :" + isBothAreSameArray(a1, a2));

	}

	public static boolean isBothAreSameArray(int a1[], int a2[]) {

		if (a1.length != a2.length) {
			return false;
		}

		Arrays.sort(a1);
		Arrays.sort(a2);

		int n = a1.length / 2;
		int i2 = n;

		for (int i = 0; i < n; i++, i2++) {

			if (a1[i] != a2[i]) {
				return false;
			}

			if (a1[i2] != a2[i2]) {
				return false;
			}

		}

		return true;
	}

}
