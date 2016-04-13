package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.List;

public class PotsOfGold {

	public static void main(String args[]) {
		int[] i = { 8, 10, 15, 8000, 7 };
		// int[] i = { 5, 25, 4, 8, 32, 6 };
		System.out.println("Coins Collected By A: " + startGame('a', i, 0, i.length - 1, new ArrayList<>()));

	}

	private static List<Integer> startGame(char startWith, int[] coins, int start, int end, List coinsCollectedByA) {

		if (start >= end) {
			if (startWith == 'a') {
				coinsCollectedByA.add(coins[end]);
			}
			return coinsCollectedByA;
		}

		int coinCollected = ((coins[start] + coins[end - 1]) > (coins[start + 1] + coins[end])) ? coins[start]
				: coins[end];

		if (((coins[start] + coins[end - 1]) > (coins[start + 1] + coins[end]))) {
			start++;
		} else {
			end--;
		}

		if (startWith == 'a') {
			coinsCollectedByA.add(coinCollected);
			startWith = 'b';
		} else {
			startWith = 'a';
		}

		return startGame(startWith, coins, start, end, coinsCollectedByA);
	}

}