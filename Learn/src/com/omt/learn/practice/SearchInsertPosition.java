package com.omt.learn.practice;

public class SearchInsertPosition {

	public static void main(String[] args) {

		int a[] = { 1, 2, 4, 6, 7, 8, 9, 11, 12 };
		int target = 0;

		System.out.println(indexToInsert(a, target));

	}

	public static int indexToInsert(int a[], int target) {
		int temp = -1;

		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target < a[mid]) {
				temp = mid;
				end = mid - 1;
			} else if (target > a[mid]) {
				temp = mid;
				start = mid + 1;
			} else {
				return mid;
			}
		}

		if (target > a[temp]) {
			temp += 1;
		}

		return temp;
	}

}
