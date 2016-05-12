package com.omt.learn.algo;

import java.util.HashMap;
import java.util.Map;

public class ChangingTheCoin {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		int a[] = { 2, 3, 5, 6, 7 };
		int currentTotal = 11;

		minCoinNeeded(a, currentTotal, map);

		System.out.println("Min coins needed :" + map.get(currentTotal));
		System.out.println("Min coins needed :" + minCoinNeeded(a, currentTotal));
	}

	public static int minCoinNeeded(int a[], int total) {

		int totals[] = new int[total + 1];
		int flags[] = new int[total + 1];

		for (int i = 0; i < totals.length; i++) {
			totals[i] = Integer.MAX_VALUE;
			flags[i] = 0;
		}

		for (int i = 0; i < a.length; i++) {
			int coin = a[i];
			for (int j = coin; j < totals.length; j++) {
				int lastConinValue = j - coin;
				if (lastConinValue == 0) {
					totals[j] = 1;
					flags[j] = i;
				} else if (lastConinValue > 0) {
					if (totals[lastConinValue] != Integer.MAX_VALUE) {
						totals[j] = Math.min(1 + totals[lastConinValue], totals[j]);
						if (totals[j] == (1 + totals[lastConinValue])) {
							flags[j] = i;
						}
					}
				}
			}
		}

		System.out.println("Below conins used :");

		int i = total;
		while (i > 0) {
			System.out.println(a[flags[i]]);
			i = i - a[flags[i]];
		}

		return totals[total];

	}

	public static int minCoinNeeded(int a[], int total, Map<Integer, Integer> cache) {

		if (total == 0) {
			return 0;
		}

		if (cache.containsKey(total)) {
			return cache.get(total);
		}

		int min = Integer.MAX_VALUE - 1;

		for (int i = 0; i < a.length; i++) {

			if (total < a[i]) {
				continue;
			}

			min = minCoinNeeded(a, total - a[i], cache);
		}

		cache.put(total, ++min);
		return min;
	}

}
