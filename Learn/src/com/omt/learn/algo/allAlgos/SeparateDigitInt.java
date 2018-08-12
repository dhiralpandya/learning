package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.List;

public class SeparateDigitInt {

	public static void main(String[] args) {

		for (int i : separateDigit(1203)) {
			System.out.println(i);
		}

	}

	public static List<Integer> separateDigit(int input) {
		List<Integer> list = new ArrayList<>();

		if (input > 9) {
			int digit = input / 10;
			list.addAll(separateDigit(digit));
			int carry = input % 10;
			list.addAll(separateDigit(carry));
		} else {
			list.add(input);
		}

		return list;
	}

}
