package com.omt.learn.algo;

public class FindMissingNumberInAP {

	public static void main(String args[]) {

		int a[] = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };

		System.out.println(findMissingNumberInAP(a, a.length));

	}

	public static int findMissingNumberInAP(int a[], int size) {

		int diff = Math.min((a[1] - a[0]), (a[2] - a[1]));
		int missing = -1;

		int start = 0;
		int end = size - 1;

		while (start <= end) {
			int middle = (start + end) / 2;
			int whatIsThereAtMiddle = a[middle];
			int whatShouldBeThereAtMiddle = a[0] + middle * diff;// IMP line
			if (whatIsThereAtMiddle == whatShouldBeThereAtMiddle) {
				start = middle + 1;
			} else {
				missing = whatShouldBeThereAtMiddle;
				end = middle - 1;
			}
		}

		return missing;

	}

}
