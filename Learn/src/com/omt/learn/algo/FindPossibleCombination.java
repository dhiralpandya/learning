package com.omt.learn.algo;

public class FindPossibleCombination {

	public static void main(String[] args) {

		int n = 3;

		combinations("", n, 0);

	}

	public static void combinations(String sb, int open, int close) {

		if (open == 0 && close == 0) {
			System.out.println(sb.toString());
		} else {

			if (open > 0) {
				combinations(sb + "[", open - 1, close + 1);
			}

			if (close > 0) {
				combinations(sb + "]", open, close - 1);
			}

		}

	}

}
