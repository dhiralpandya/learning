package com.omt.learn.practice;

public class PlusOne {

	public static void main(String[] args) {

		int a = 9;
		int b = 99;
		int c = 19;
		int d = 186;

		System.out.println(arrayToString(returnArrayFromNumber(a)));
		System.out.println(arrayToString(returnArrayFromNumber(b)));
		System.out.println(arrayToString(returnArrayFromNumber(c)));
		System.out.println(arrayToString(returnArrayFromNumber(d)));

	}

	public static int[] returnArrayFromNumber(int number) {
		number += 1;
		int a[] = new int[(int) Math.log10(number) + 1];

		for (int i = a.length - 1; i >= 0; i--) {
			a[i] = number % 10;
			number /= 10;
		}

		return a;
	}

	public static String arrayToString(int a[]) {
		String s = "[";

		for (int i : a) {
			s += "" + i + ",";
		}
		s = s.substring(0, s.length() - 1);
		return s += "]";
	}

}
