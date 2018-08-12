package com.omt.learn.algo.allAlgos;

import java.util.Scanner;

public class Sherlock {

	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		int T = reader.nextInt();
		String[] s = new String[T];

		for (int i = 0; i < T; i++) {
			int N = reader.nextInt();
			String opt = "";

			if (N % 3 == 0) {
				for (int count = 0; count < N / 3; count++) {
					opt += "555";
				}
			} else if ((N - 5) >= 0 && (N - 5) % 3 == 0) {
				for (int count = 0; count < (N - 5) / 3; count++) {
					opt += "555";
				}
				opt += "33333";
			} else if ((N - 10) >= 0 && (N - 10) % 3 == 0) {
				for (int count = 0; count < (N - 10) / 3; count++) {
					opt += "555";
				}
				opt += "3333333333";
			} else {
				opt = "-1";
			}

			s[i] = opt;

		}

		for (String op : s) {
			System.out.println(op);
		}

	}

	private void methodOne() {
		Scanner reader = new Scanner(System.in);
		int T = reader.nextInt();
		String[] s = new String[T];
		boolean flag = false;
		for (int i = 0; i < T; i++) {
			int N = reader.nextInt();
			String opt = "";
			int n5 = N / 3;
			int n3 = N - n5 * 3;
			while (n5 > 0 && n3 > 0 && n3 % 5 != 0) {
				n5--;
				n3 = N - n5 * 3;

			}
			if (n3 % 5 == 0) {
				flag = true;
			}
			if (flag == false) {
				s[i] = "-1";
			} else {
				// int n3 = (int) n3_d;
				while (n5 > 0) {

					opt += "555";
					n5--;
				}
				while (n3 > 0) {

					opt += "3";
					n3--;
				}

				s[i] = opt;

			}
		}

		for (String op : s) {
			System.out.println(op);
		}
	}

}
