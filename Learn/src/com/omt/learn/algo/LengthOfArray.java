package com.omt.learn.algo;

import java.util.Set;
import java.util.TreeSet;

public class LengthOfArray {

	public static void main(String args[]) {

		int[][] arrayOfArray = { { 2, 10, 15, 24, 26 }, { 0, 9, 12, 20 }, { 4, 18, 22, 30 } };
		int[] selectedArray = calculateMinDistance(arrayOfArray);

		System.out.print("[ ");
		for (int i : selectedArray) {
			System.out.print(i + " ");
		}
		System.out.println("]");

	}

	private static int[] calculateMinDistance(int[][] arrays) {

		Integer arrayOfSet[] = combineSortedArray(arrays);

		int minRangeFoundForSelectedArray = arrayOfSet[arrayOfSet.length - 1] - arrayOfSet[0];
		int arrayLength = arrays.length;
		int selectedArray[] = new int[arrayLength];
		int validCount = (arrayLength) * (arrayLength + 1) / 2;

		int count = 0;
		while ((count + arrayLength) < arrayOfSet.length) {

			int[] tempArray = new int[arrayLength];
			for (int i = 0; i < arrayLength; i++) {
				tempArray[i] = arrayOfSet[i + count];
			}
			if (((tempArray[arrayLength - 1] - tempArray[0]) <= minRangeFoundForSelectedArray)
					&& isCoverAllArrayCount(tempArray, arrays) == validCount) {
				selectedArray = tempArray;
				minRangeFoundForSelectedArray = tempArray[arrayLength - 1] - tempArray[0];
			}
			count++;
		}

		return selectedArray;
	}

	private static int isCoverAllArrayCount(int[] selectedArray, int[][] arrays) {
		int count = 0;

		for (int i = 0; i < arrays.length; i++) {
			int[] singleArray = arrays[i];
			loopJ: for (int j : singleArray) {
				for (int selectedInt : selectedArray) {
					if (j == selectedInt) {
						count += i + 1;
						break loopJ;
					}
				}
			}
		}

		return count;
	}

	private static Integer[] combineSortedArray(int arrays[][]) {
		Set<Integer> set = new TreeSet<Integer>();

		for (int[] a : arrays) {
			for (int number : a) {
				set.add(number);
			}
		}

		Integer arrayOfSet[] = set.toArray(new Integer[set.size()]);
		return arrayOfSet;
	}

}
