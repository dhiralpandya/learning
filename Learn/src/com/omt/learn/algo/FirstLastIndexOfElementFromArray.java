package com.omt.learn.algo;

public class FirstLastIndexOfElementFromArray {

	public static void main(String[] args) {

		int a[] = { 1, 4, 5, 7, 8, 8, 8, 9, 10 };

		// int startEnd[] = getStartEndIndexOfTarget(a, 8);
		// System.out.println("Start :" + startEnd[0] + " and End :" +
		// startEnd[1]);
	}

	public static int[] getStartEndIndexOfTarget(int a[], int target) {

		int start = 0;
		int end = a.length - 1;

		int result[] = new int[2];
		result[0] = -1;
		result[1] = -1;

		while (end > start) {

			int middle = start + (end - start) / 2; // this is to avoid
													// overflow.
			if (a[middle] < target) {
				start = middle + 1;
			} else if (a[middle] > target) {
				end = middle - 1;
			} else {
				result[0] = middle;
				end = middle - 1;
			}

		}

		if (result[0] > -1) {
			start = result[0];
			end = a.length - 1;
			while (end > start) {

				int middle = start + (end - start) / 2; // this is to avoid
														// overflow.
				if (a[middle] < target) {
					start = middle + 1;
				} else if (a[middle] > target) {
					end = middle - 1;
				} else {
					result[1] = middle;
					start = middle + 1;
				}

			}
		}

		return result;
	}

}
