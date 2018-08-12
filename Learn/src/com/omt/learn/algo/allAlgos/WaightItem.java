package com.omt.learn.algo.allAlgos;

import java.util.HashMap;
import java.util.Map;

public class WaightItem {

	public static void main(String[] args) {

		// Input One
		// int wt[] = { 2, 2, 4, 5 };
		// int val[] = { 2, 4, 6, 9 };
		// int maxWeight = 8;
		// Input two
		int wt[] = { 1, 3, 4, 5 };
		int val[] = { 1, 4, 5, 7 };
		int maxWeight = 7;

		int totalItems = wt.length;

		System.out.println("Max value within weight :" + getMax(wt, val, totalItems, maxWeight, 0, maxWeight));
		System.out.println("Max value within weight using Map Cache :"
				+ getMax(wt, val, totalItems, maxWeight, 0, maxWeight, new HashMap<>()));
		System.out.println("Max value within weight using Dynamic Programming :"
				+ getMaxDynamicProgramming(wt, val, maxWeight, totalItems));

	}

	public static int getMax(int wt[], int val[], int totalItems, int totalWeight, int currentItem,
			int remainingWeight) {

		if (currentItem >= totalItems || remainingWeight <= 0) {
			return 0;
		}

		if (wt[currentItem] > remainingWeight) {
			return getMax(wt, val, totalItems, totalWeight, currentItem + 1, remainingWeight);
		}

		int withCurrentItem = val[currentItem]
				+ getMax(wt, val, totalItems, totalWeight, currentItem + 1, remainingWeight - wt[currentItem]);
		int whatifNotSelectCurrentItem = getMax(wt, val, totalItems, totalWeight, currentItem + 1, remainingWeight);

		return Math.max(withCurrentItem, whatifNotSelectCurrentItem);

	}

	public static int getMax(int wt[], int val[], int totalItems, int totalWeight, int currentItem, int remainingWeight,
			Map<String, Integer> cache) {
		if (currentItem >= totalItems || remainingWeight <= 0) {
			return 0;
		}

		String mapKey = remainingWeight + "|" + (totalItems - currentItem - 1);
		if (cache.containsKey(mapKey)) {
			return cache.get(cache);
		}

		if (wt[currentItem] > remainingWeight) {
			return getMax(wt, val, totalItems, totalWeight, currentItem + 1, remainingWeight);
		}

		int withCurrentItem = val[currentItem]
				+ getMax(wt, val, totalItems, totalWeight, currentItem + 1, remainingWeight - wt[currentItem]);
		int whatifNotSelectCurrentItem = getMax(wt, val, totalItems, totalWeight, currentItem + 1, remainingWeight);

		int maxValue = Math.max(withCurrentItem, whatifNotSelectCurrentItem);

		cache.put(mapKey, maxValue);

		return maxValue;

	}

	public static int getMaxDynamicProgramming(int wt[], int val[], int totalWeight, int totalItems) {

		int[][] matrix = new int[totalItems][totalWeight + 1];

		for (int i = 0; i < totalItems; i++) {
			int weight = wt[i];
			int value = val[i];

			for (int j = 1; j < totalWeight + 1; j++) {

				int ifWeNotSelectThisItemThenValue = 0;
				if (i > 0) {
					ifWeNotSelectThisItemThenValue = matrix[i - 1][j];
				}

				int remainingWeight = j - weight;
				int includingCurrentItemValue = 0;

				if (remainingWeight >= 0) {
					includingCurrentItemValue = value;
					if (i > 0) {
						includingCurrentItemValue += matrix[i - 1][remainingWeight];
					}
				}

				matrix[i][j] = Math.max(ifWeNotSelectThisItemThenValue, includingCurrentItemValue);

			}
		}

		printMatrix(matrix);
		return matrix[totalItems - 1][totalWeight];
	}

	public static void printMatrix(int[][] i) {
		for (int[] p : i) {
			for (int px : p) {
				if (px > 9) {
					System.out.print(px + " ");
				} else {
					System.out.print(px + "  ");
				}
			}
			System.out.println();
		}
	}
}
