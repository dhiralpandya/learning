package com.omt.learn.algo.allAlgos;

public class IsSomeOneWonTicTacToe {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X', 'X', 'X' }, { 'O', 'X', 'O' }, { 'X', 'O', 'O' } };
		System.out.println(isSomeoneWonGame(board));
		// test win col
		board = new char[][] { { 'X', 'O', 'X' }, { 'X', 'X', 'O' }, { 'X', 'O', 'O' } };
		System.out.println(isSomeoneWonGame(board));
		// test win diag
		board = new char[][] { { 'X', 'O', 'O' }, { 'O', 'X', 'O' }, { 'X', 'O', 'X' } };
		System.out.println(isSomeoneWonGame(board));
		// test no win
		board = new char[][] { { 'X', 'O', 'X' }, { 'O', 'O', 'X' }, { 'X', 'X', 'O' } };
		System.out.println(isSomeoneWonGame(board));
		// test win col O
		board = new char[][] { { 'X', 'O', 'O' }, { 'O', 'X', 'O' }, { 'X', 'O', 'O' } };
		System.out.println(isSomeoneWonGame(board));
	}

	public static boolean isSomeoneWonGame(char[][] game) {

		int top = 1;
		int bottom = 1;
		int left = 1;
		int right = 1;
		int topLeft = 1;
		int topRight = 1;

		for (int i = 1; i < 3; i++) {
			if (game[0][i] == game[0][i - 1]) {
				top++;
			}
			if (game[i][0] == game[i - 1][0]) {
				left++;
			}
			if (game[2][i] == game[2][i - 1]) {
				bottom++;
			}

			if (game[i][2] == game[i - 1][2]) {
				right++;
			}
			if (game[i][i] == game[i - 1][i - 1]) {
				topLeft++;
			}

			if (game[i][2 - i] == game[i - 1][2 - i + 1]) {
				topRight++;
			}

			if (topLeft == 3 || topRight == 3 || top == 3 || left == 3 || right == 3 || bottom == 3) {
				return true;
			}

		}

		return false;
	}

}
