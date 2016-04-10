package com.omt.learn.algo;

import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		long total = Long.parseLong(scn.nextLine());
		String[] line = scn.nextLine().trim().split("\\s");

		double m = 0;
		double z = 0;
		double p = 0;

		for (String i : line) {
			double d = Double.parseDouble(i);
			if (d == 0) {
				z++;
			} else if (d < 0) {
				m++;
			} else if (d > 0) {
				p++;
			}

		}

		System.out.println(p / total);
		System.out.println(m / total);
		System.out.println(z / total);

	}

	private void codeOne() {
		Scanner scn = new Scanner(System.in);

		long total = Integer.parseInt(scn.nextLine());
		String line = scn.nextLine().trim().replace("\\s", "") + " ";
		double minusCount = line.split("-").length - 1;
		double zeroCount = line.split("0").length - 1;
		double plusCount = total - zeroCount - minusCount;

		// System.out.println(minusCount);
		// System.out.println(plusCount);
		// System.out.println(zeroCount);

		System.out.println(plusCount / total);
		System.out.println(minusCount / total);
		System.out.println(zeroCount / total);

	}
}
// -1 -1 0 0 1 0