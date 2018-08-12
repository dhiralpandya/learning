package com.omt.learn.algo.allAlgos;

import java.util.Scanner;

public class SherlockSquares {

	public static void main(String[] args) {
		double d = 5.5;

		Scanner sn = new Scanner(System.in);

		int t = Integer.parseInt(sn.nextLine());

		int[] reqults = new int[t];

		for (int count = 0; count < t; count++) {
			String[] numbers = sn.nextLine().split("\\s");
			int sqCount = 0;

			for (int index = Integer.parseInt(numbers[0]); index <= Integer.parseInt(numbers[1]); index++) {
				if (Math.sqrt(index) % 1 == 0) {
					sqCount++;
				}
			}

			reqults[count] = sqCount;

		}

		for (int i : reqults) {
			System.out.println(i);
		}

	}

}
