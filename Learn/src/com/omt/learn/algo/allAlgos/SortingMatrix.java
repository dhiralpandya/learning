package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingMatrix {

	public static void main(String[] args) {
		// int array[][] = { { 1, 3, 5 }, { 3, 2, 4 } };
		// int array[][] = { { 12, 33, 54 }, { 23, 27, 14 } };
		int array[][] = { { 1, 2, 3 }, { 3, 4, 5 } };

		array = sort2DMatrix(array);

		for (int[] i : array) {
			for (int a : i) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}

	public static int[][] sort2DMatrix(int[][] array) {
		List<Integer> list = new ArrayList<>();

		int totalNumberOfArrays = array.length;

		for (int count = 0; count < totalNumberOfArrays; count++) {
			for (int index = 0; index < array[count].length; index++) {
				list.add(array[count][index]);
			}
		}

		Collections.sort(list);

		int[][] result = new int[2][list.size() / 2];

		int currentCount = 0;
		for (int count = 0; count < list.size();) {
			result[0][currentCount] = list.get(count++);
			result[1][currentCount++] = list.get(count++);
		}

		return result;
	}

}
