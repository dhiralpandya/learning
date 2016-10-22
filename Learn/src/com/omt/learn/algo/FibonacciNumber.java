package com.omt.learn.algo;

public class FibonacciNumber {

	public static void main(String[] args) {

		System.out.println("Fibonacci Numbers :");

		int i = 0;
		while (i < 13) {
			System.out.print(F(i) + " ");
			i++;
		}

	}

	public static int F(int n) {

		if (n <= 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		}

		return F(n - 1) + F(n - 2);

	}

}
