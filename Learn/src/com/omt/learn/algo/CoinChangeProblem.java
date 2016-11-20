package com.omt.learn.algo;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.omt.learn.algo.util.matrix.MatrixUtil;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// int[] a = { 1, 2, 3 };
		// int total = 4;
		int[] a = { 5, 6 }; // 4
		int total = 30;
		// int[] a = { 2, 5, 3, 6 };
		// int total = 10;
		findNumberOfCount(a, total, 0, "").forEach(s -> {
			System.out.println(s);
		});

		System.out.println(findNumberOfCountDynamicProgramming(a, total));

		// Scanner sn = new Scanner(System.in);
		// String s[] = sn.nextLine().split("\\s+");
		// int total = Integer.parseInt(s[0]);
		// int totalCoins = Integer.parseInt(s[1]);
		// System.out.println(total);
		// System.out.println(totalCoins);

		// String a[] = sn.nextLine().split("\\s+");
		//
		// int coins[] = new int[totalCoins];
		// int j = 0;
		// for (String as : a) {
		// // System.out.println(as);
		// coins[j] = Integer.parseInt(as);
		// j++;
		// }
		// System.out.println(findNumberOfCount(coins, total, 0, "").size());
	}

	public static Set<String> findNumberOfCount(int coins[], int requiredTotal, int currentTotal, String s) {
		Set<String> set = new TreeSet<>();
		if (currentTotal > requiredTotal) {

			return set;
		}

		if (currentTotal == requiredTotal) {
			char c[] = s.toCharArray();
			Arrays.sort(c);
			set.add(new String(c));
			return set;
		}

		int count = 0;

		for (int index = 0; index < coins.length; index++) {
			char c[] = (s + coins[index]).toCharArray();
			Arrays.sort(c);
			if (set.contains(new String(c))) {
				continue;
			}
			set.addAll(findNumberOfCount(coins, requiredTotal, currentTotal + coins[index], s + coins[index]));
		}

		return set;

	}

	public static int findNumberOfCountDynamicProgramming(int coins[], int requiredTotal) {

		/* 1. Sort Coins */
		/*
		 * 2. Coins at Zero : coins[0] if j % coins[0] == 0 then set ONE
		 * 
		 * NOTE : Here J is from 0 to requiredTotal
		 */
		/*
		 * 3. Coins at other place : if j - coins[i] == 0 then 1+ [i-1][j] NOTE
		 * : Here J is from 0 to requiredTotal
		 */
		/*
		 * 
		 * NOTE : Here J is from 0 to requiredTotal : <br> IMP 4. Coins at other
		 * place : if j - coins[0] > 0 then check / if([i][j - coins[i]] ==0) {
		 * Here if there is no solution of remaning value then take above count
		 * [i][j] = [i-1][j] } else {
		 * 
		 * [i][j] = 1+MAX{[i-1][j],[i][j - coins[i]]}
		 * 
		 * }
		 * 
		 */
		/*
		 * if j - coins[i] < 0 then set above value [i][j] = [i-1][j]
		 */

		Arrays.sort(coins);

		int[][] m = new int[coins.length][requiredTotal + 1];

		for (int i = 1; i < requiredTotal + 1; i++) {
			if (i % coins[0] == 0) {
				m[0][i] = 1;
			}
		}

		for (int i = 0; i < coins.length; i++) {
			m[i][0] = 1;
		}

		for (int i = 1; i < coins.length; i++) {
			for (int j = 1; j < requiredTotal + 1; j++) {
				if (coins[i] > j) {
					m[i][j] = m[i - 1][j];
				} else {
					m[i][j] = m[i - 1][j] + m[i][j - coins[i]];
				}
			}
		}
		MatrixUtil.printMatrix(m);
		return m[coins.length - 1][requiredTotal];
	}

}
