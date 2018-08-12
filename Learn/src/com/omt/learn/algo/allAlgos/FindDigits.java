package com.omt.learn.algo.allAlgos;

import java.util.Scanner;

public class FindDigits {

	public static void main(String args[]) {

		Scanner sn = new Scanner(System.in);

		int t = sn.nextInt();

		long numbers[] = new long[t];

		for (int count = 0; count < t; count++) {

			long n = sn.nextLong();
			String s = n + "";
			long c = 0;
			for (int i = 0; i < s.length(); i++) {
				long no = Long.parseLong(s.charAt(i) + "");
				if (no == 1) {
					c++;
				} else if ((no > 1) && (n % no == 0)) {
					c++;
				}
			}

			numbers[count] = c;

		}

		for (long l : numbers) {
			System.out.println(l);
		}

	}

}
