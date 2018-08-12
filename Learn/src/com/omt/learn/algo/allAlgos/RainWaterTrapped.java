package com.omt.learn.algo.allAlgos;

public class RainWaterTrapped {

	public static void main(String[] args) {

		int a[] = { 2, 3, 5, 1, 4, 7, 10, 8, 11, 12, 1, 5, 7, 9, 2 };
		System.out.println("Total Water Trapped is :" + totalWaterTrapped(a));

		int a1[] = { 7, 1, 4, 0, 2, 8, 6, 3, 5 };
		System.out.println("Total Water Trapped is :" + totalWaterTrapped(a1));
	}

	public static int totalWaterTrapped(int a[]) {
		int sum = 0;

		int p1 = 0;
		int p2 = a.length - 1;

		int maxLeft = a[p1];
		int maxRight = a[p2];
		int minRightNow = Math.min(maxLeft, maxRight);
		boolean moveLeftPointer = maxLeft <= maxRight; // Here we are moving min value pointer.

		while (p1 != p2) {

			if (moveLeftPointer) {
				p1++;
				if (a[p1] > minRightNow) {
					maxLeft = a[p1];
					minRightNow = Math.min(maxLeft, maxRight);
				} else {
					sum += minRightNow - a[p1];
				}
			} else {
				p2--;
				if (a[p2] > minRightNow) {
					maxRight = a[p2];
					minRightNow = Math.min(maxLeft, maxRight);
				} else {
					sum += minRightNow - a[p2];
				}
			}

			moveLeftPointer = maxLeft <= maxRight; // Moving pointer which has min value.

		}

		return sum;
	}

}

// Get more details about this solution in below videos
// https://www.youtube.com/watch?v=pq7Xon_VXeU&t=445s