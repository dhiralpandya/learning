package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextHigherNumber {

	public static void main(String[] args) {

		System.out.println("Next Highter Number from 1234 is :" + getNextHigherNumber(1234));
		System.out.println("Next Highter Number from 4132 is :" + getNextHigherNumber(4132));
		System.out.println("Next Highter Number from 4321 is :" + getNextHigherNumber(4321));
		System.out.println("Next Highter Number from 32876 is :" + getNextHigherNumber(32876));
		System.out.println("Next Highter Number from 32841 is :" + getNextHigherNumber(32841));
	}

	public static int getNextHigherNumber(int number) {
		int n = 0;
		int d1Index = -1;
		int d2Index = -1;
		int count = 0;

		List<Integer> numbers = getNumbers(number);

		for (int i = numbers.size() - 1; i > count; i--) {
			if (d1Index < 0) {
				if (numbers.get(i - 1) < numbers.get(i)) {
					d1Index = i - 1;
					count = d1Index;
					i = numbers.size();
				}
			} else if (d1Index == i) {
				break;
			} else if (numbers.get(i) > numbers.get(d1Index)) {
				d2Index = i;
				int d1 = numbers.get(d1Index);
				int d2 = numbers.get(d2Index);

				numbers.remove(d1Index);
				numbers.add(d1Index, d2);
				numbers.remove(d2Index);
				numbers.add(d2Index, d1);

				break;
			}
		}

		if (d1Index > -1 && d2Index > -1) {

			int a[] = new int[numbers.size() - 1 - d1Index];
			int j = 0;
			for (int i = d1Index + 1; i < numbers.size(); i++) {
				a[j++] = numbers.get(i);
			}

			Arrays.sort(a);

			String ns = "";
			for (int i = 0; i < d1Index + 1; i++) {
				ns += numbers.get(i);
			}
			for (int i : a) {
				ns += i;
			}

			n = Integer.parseInt(ns);
		}

		return n;

	}

	public static List<Integer> getNumbers(int number) {

		List<Integer> l = new ArrayList<>();
		if (number > 9) {
			int result = number / 10;
			int carry = number % 10;
			l.addAll(getNumbers(result));
			l.addAll(getNumbers(carry));

		} else {
			l.add(number);
		}
		return l;
	}

}
