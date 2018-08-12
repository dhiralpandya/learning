package com.omt.learn.algo.allAlgos;

public class HouseAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 8, 5, 10, 40, 50, 35 };
		System.out.println(max(a, 0));
	}

	public static int max(int a[], int i) {
		if (i >= a.length) {
			return 0;
		}
		int f = a[i] + max(a, i + 2);
		int s = a[i] + max(a, i + 3);
		int t = max(a, i + 1);

		return Math.max(Math.max(f, s), t);
	}

}
