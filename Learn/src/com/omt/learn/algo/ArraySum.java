package com.omt.learn.algo;

import java.util.Scanner;

public class ArraySum {

	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);

		String total = reader.nextLine();
		String s = reader.nextLine();
		String[] ary = s.split("\\s");
		long add = 0;
		for (String i : ary) {
			add += Integer.parseInt(i);
		}
		System.out.println(add);
	}

}
