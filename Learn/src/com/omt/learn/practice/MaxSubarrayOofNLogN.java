package com.omt.learn.practice;

public class MaxSubarrayOofNLogN {

	public static void main(String[] args) {
		int a[] = { -1, 2, -3, 4 };
		int b[] = { -10, -4, -5, -6 };
		int leetcodeInput[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println(divideAndConquer(a));
		System.out.println(divideAndConquer(b));
		System.out.println(divideAndConquer(leetcodeInput));
	}

	public static int divideAndConquer(int a[]) {
		return divide(a, 0, a.length - 1);
	}

	public static int divide(int a[], int left, int right) {

		if (left == right) {
			return a[left];
		}
		int mid = (left + right) / 2;
		return Math.max((Math.max(divide(a, left, mid), divide(a, mid + 1, right))),
				sumOfLeftAndRightAll(a, left, right));

	}

	public static int sumOfLeftAndRightAll(int a[], int left, int right) {
		int maxNow = 0;
		int maxFinally = Integer.MIN_VALUE;

		for (int i = left; i <= right; i++) {
			maxNow += a[i];
			if (maxFinally < maxNow) {
				maxFinally = maxNow;
			}
			if (maxNow < 0) {
				maxNow = 0;
			}
		}

		return maxFinally;
	}

}
