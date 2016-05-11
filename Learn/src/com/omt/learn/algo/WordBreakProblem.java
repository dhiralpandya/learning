package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WordBreakProblem {

	public static final Set<String> dictionary = new TreeSet<String>() {
		{
			add("a");
			add("i");
			add("am");
			add("ace");
			add("you");
			add("code");
			add("love");
			add("to");
		}
	};

	public static void main(String[] args) {

		// String word = "iamace";
		String word = "ilovetocode";
		for (String s : getWords(word)) {
			System.out.println(s);
		}

	}

	public static List<String> getWords(String word) {

		List<String> words = new ArrayList<>();
		int size = word.length();
		char cs[] = word.toCharArray();

		boolean[][] matrix = new boolean[size][size];
		Integer[][] flags = new Integer[size][size];

		// int l = 0;
		for (int l = 1; l <= size; l++) {
			// l++;
			for (int j = 0; j < size; j++) {

				if ((l + j) <= size) {
					for (int k = j; k < l + j; k++) {

						if (j == k && l == 1) {
							if (dictionary.contains(String.valueOf(cs[j]))) {
								matrix[j][k] = true;
								flags[j][k] = j;

							}
						} else {
							if (k - j == 0) {

								String entireWord = word.substring(k, l + j);
								if (dictionary.contains(entireWord)) {
									matrix[j][l + j - 1] = true;
									flags[j][l + j - 1] = l + j - 1;
									break;
								}
							} else if (matrix[j][k - 1] && matrix[k][l + j - 1]) {
								matrix[j][l + j - 1] = true;
								flags[j][l + j - 1] = k - 1;

								break;
							}
						}

					}
				}

			}
		}
		printMatrix(matrix);
		printMatrix(flags);

		int pointer = 0;
		int i = 0;

		while (i < size) {
			;
			Integer point = flags[i][size - 1];
			if (point != null) {

				words.add(word.substring(i, point + 1));

			}
			i++;
		}

		return words;
	}

	public static void printMatrix(boolean[][] i) {
		for (boolean[] p : i) {
			for (boolean px : p) {

				System.out.print((px ? "T" : "F") + " ");

			}
			System.out.println("");
		}
	}

	public static void printMatrix(Integer[][] i) {
		for (Integer[] p : i) {
			for (Integer px : p) {
				if (px != null && px < 9) {
					System.out.print(px + "  ");
				} else {
					if (px == null) {
						System.out.print("NA" + " ");
					} else {
						System.out.print(px + " ");
					}
				}
			}
			System.out.println();
		}
	}
}
