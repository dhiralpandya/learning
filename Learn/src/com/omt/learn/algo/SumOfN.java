package com.omt.learn.algo;

public class SumOfN {

	public static void main(String args[]) {

		int N = 10;// Some Number n Here we will take 10
		int n = N - 1; // Why N-1 because in Question it saying For 0 to n-1

		// Here is a Arithmetic Progression
		/*
		 * Sum of N number 1+2+3....+n n(n+1)/2
		 */

		long sum = n * (n + 1) / 2;
		System.out.println("Sum From :" + 0 + " to " + n + " is " + sum);

	}

}
