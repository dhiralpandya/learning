package com.omt.learn.algo.allAlgos;

public class OptimalGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 3, 9, 1, 2 };
		System.out.println(max(a, 0, a.length - 1));
	}

	public static int max(int a[], int first, int last) {

		if (first >= last) {
			return 0;
		}

		int f = a[first] + max(a, first + 1, last);
		int s = a[last] + max(a, first, last - 1);

		return Math.max(f, s);
	}

}
