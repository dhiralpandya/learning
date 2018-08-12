package com.omt.learn.algo.allAlgos;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		long total = Long.parseLong(scn.nextLine());

		for (int i = 0; i < total; i++) {
			for (int space = 0; space < total - 1 - i; space++) {
				System.out.print(" ");
			}

			for (int h = 0; h <= i; h++) {
				System.out.print("#");
			}
			System.out.println();
		}

	}

}
