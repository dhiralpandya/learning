package com.omt.learn.algo.allAlgos;

public class SortedTwoArrayMerge {

	public static void main(String[] args) {

		int a[] = { 3, 5, 7, 8, 8, 9, 10 };
		int b[] = { 3, 4, 6, 7, 11 };

		int result[] = mergeTwoSortedArrays(a, b);

		for (int i : result) {
			System.out.print(i + " ");
		}

	}

	public static int[] mergeTwoSortedArrays(int a[], int b[]) {
		int[] r = new int[a.length + b.length];

		int p1 = 0;
		int p2 = 0;
		int index = 0;

		while (p1 < a.length && p2 < b.length) {
			if (a[p1] < b[p2]) {
				r[index] = a[p1];
				p1++;
			} else {
				r[index] = b[p2];
				p2++;
			}
			index++;
		}

		while (p1 < a.length) {
			r[index++] = a[p1++];
		}
		while (p2 < b.length) {
			r[index++] = b[p2++];
		}
		return r;
	}

}
