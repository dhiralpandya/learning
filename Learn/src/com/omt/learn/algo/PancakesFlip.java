package com.omt.learn.algo;

import java.io.BufferedReader;
import java.io.FileReader;

public class PancakesFlip {

	public static void main(String[] args) {
		scanFileForInputs();
	}

	private static int flipCake(int T, String inputs, int count) {

		if (!inputs.contains("-")) {
			return count;
		}

		char[] chA = inputs.toCharArray();
		int size = chA.length;

		if (chA[size - 1] == '-') {
			for (char c : chA) {
				char temp = '-';
				if (c == '-') {
					temp = '+';
				}

				inputs = temp + inputs;
			}
		} else {

		}

		return count;
	}

	private static void scanFileForInputs() {

		int Tf = 0;
		String inputsf[] = null;

		try {

			BufferedReader br = new BufferedReader(new FileReader("input.in"));
			String s = null;
			boolean isFirst = true;
			int count = 0;
			while ((s = br.readLine()) != null) {
				if (s.trim().length() == 0) {
					continue;
				}
				if (isFirst) {
					isFirst = false;
					Tf = Integer.parseInt(s);
					inputsf = new String[Tf];
				} else {
					inputsf[count++] = s;
				}
			}

			for (String in : inputsf) {
				System.out.println(in);

				System.out.println(flipCake(Tf, in, 0));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
