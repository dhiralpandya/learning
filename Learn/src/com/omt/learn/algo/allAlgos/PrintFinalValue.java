package com.omt.learn.algo.allAlgos;

import java.util.Scanner;

public class PrintFinalValue {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		String lineOne[] = sn.nextLine().split("\\s+");

		long[] input = new long[Integer.parseInt(lineOne[0])];

		long max = 0;

		int qSize = Integer.parseInt(lineOne[1]);
		for (int i = 0; i < qSize; i++) {
			String s[] = sn.nextLine().split("\\s+");
			long add = Long.parseLong(s[2]);
			int from = Integer.parseInt(s[0]) - 1;
			int to = Integer.parseInt(s[1]);

			for (int j = from; j < to; j++) {
				input[j] += add;
				if (max < input[j]) {
					max = input[j];
				}
			}
		}

		System.out.println(max);

	}

}
