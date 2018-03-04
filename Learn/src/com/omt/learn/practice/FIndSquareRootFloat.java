package com.omt.learn.practice;

public class FIndSquareRootFloat {

	public static void main(String s[]) {
		System.out.println("Square Root of 277 :");
		System.out.println(squareRoot(277));
		System.out.println("Square Root of 277 (Math.sqrt):");
		System.out.println(Math.sqrt(277));

		System.out.println("Square Root of 5 :");
		System.out.println(squareRoot(5));
		System.out.println("Square Root of 5 (Math.sqrt):");
		System.out.println(Math.sqrt(5));

		System.out.println("Square Root of 7 :");
		System.out.println(squareRoot(7));
		System.out.println("Square Root of 7 (Math.sqrt):");
		System.out.println(Math.sqrt(7));

		System.out.println("Square Root of 49 :");
		System.out.println(squareRoot(49));
		System.out.println("Square Root of 49 (Math.sqrt):");
		System.out.println(Math.sqrt(49));

		System.out.println("Square Root of 25 :");
		System.out.println(squareRoot(25));
		System.out.println("Square Root of 25 (Math.sqrt):");
		System.out.println(Math.sqrt(25));

		System.out.println("Square Root of 81 :");
		System.out.println(squareRoot(81));
		System.out.println("Square Root of 25 (Math.sqrt):");
		System.out.println(Math.sqrt(81));

		System.out.println("Square Root of 277.787 :");
		System.out.println(squareRoot(277.787));
		System.out.println("Square Root of 277.787 (Math.sqrt):");
		System.out.println(Math.sqrt(277.787));

	}

	public static double squareRoot(double number) {

		double round = 1000000000000.0d;
		double start = 0;
		double end = number;
		double ans = 0.0;

		while (start < end) {
			double mid = (start + end) / 2;
			double midXmid = (mid * mid);
			if (midXmid == number) {
				return Math.round(mid * round) / round;
			} else if (midXmid < number) {
				ans = mid;
				start = mid + 0.00000000000001;
			} else {
				end = mid - 0.00000000000001;
			}
		}
		return Math.round(ans * round) / round;
	}

}
