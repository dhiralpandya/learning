package com.omt.learn.practice;

public class MaxSubarrayOofN {

	public static void main(String[] args) {

		int a[] = { -1, 2, -3, 4 };
		int b[] = { -10, -4, -5, -6 };
		int leetcodeInput[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println(maxSubarray(a));
		System.out.println(maxSubarray(b));
		System.out.println(maxSubarray(leetcodeInput));

	}

	public static int maxSubarray(int a[]) {

		int maxSumNow = 0;
		int maxSumFinally = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			maxSumNow += a[i];
			if (maxSumFinally < maxSumNow) {
				maxSumFinally = maxSumNow;
			}

			if (maxSumNow < 0) {
				maxSumNow = 0;
			}
		}

		return maxSumFinally;
	}

}
