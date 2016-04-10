package com.omt.learn.algo;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int matrixOfN = Integer.parseInt(scn.nextLine());
		/// String[] lines = new String[matrixOfN];

		long left = 0;
		long right = 0;
		int last = matrixOfN - 1;

		for (int i = 0; i < matrixOfN; i++) {
			String[] ary = scn.nextLine().split("\\s");
			left += Long.parseLong(ary[i]);
			right += Long.parseLong(ary[last - i]);
		}

		System.out.println(Math.abs(left - right));

	}

}
