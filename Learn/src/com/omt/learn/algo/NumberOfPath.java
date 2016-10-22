package com.omt.learn.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class NumberOfPath {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;

		int _a_rows = 0;
		int _a_cols = 0;
		_a_rows = Integer.parseInt(in.nextLine().trim());
		_a_cols = Integer.parseInt(in.nextLine().trim());

		int[][] _a = new int[_a_rows][_a_cols];
		for (int _a_i = 0; _a_i < _a_rows; _a_i++) {
			for (int _a_j = 0; _a_j < _a_cols; _a_j++) {
				_a[_a_i][_a_j] = in.nextInt();

			}
		}

		if (in.hasNextLine()) {
			in.nextLine();
		}

		res = numberOfPaths(_a);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();

	}

	static int numberOfPaths(int[][] a) {

		int m = a.length;
		int n = a[0].length;

		return numberOfPaths(a, 0, 0, m, n);
	}

	static int numberOfPaths(int[][] a, int i, int j, int m, int n) {

		if (i < m && j < n) {

			if (a[i][j] == 1) {
				return 1 + numberOfPaths(a, i, j + 1, m, n) + numberOfPaths(a, i + 1, j, m, n);
			} else {
				return 0;
			}
		}
		return 0;

	}

}
