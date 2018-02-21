package com.omt.learn.practice;

public class PlusOneArrayInput {

	public static void main(String[] args) {

		int a[] = { 9 };
		int b[] = { 9, 9 };
		int c[] = { 1, 9 };
		int d[] = { 1, 8, 6 };

		System.out.println(arrayToString(returnArrayFromNumber(a)));
		System.out.println(arrayToString(returnArrayFromNumber(b)));
		System.out.println(arrayToString(returnArrayFromNumber(c)));
		System.out.println(arrayToString(returnArrayFromNumber(d)));

	}

	public static int[] returnArrayFromNumber(int[] number) {

		int carry = 0;
		for (int i = number.length - 1; i >= 0; i--) {
			int sum = carry + number[i];
			if (i == number.length - 1) {
				sum++;
			}
			number[i] = sum % 10;
			carry = (sum > 9) ? (sum / 10) : 0;
		}

		if (carry != 0) {
			int[] result = new int[number.length + 1];
			int i = 0;
			result[i++] = carry;

			for (int j : number) {
				result[i++] = j;
			}

			return result;

		}

		return number;
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
