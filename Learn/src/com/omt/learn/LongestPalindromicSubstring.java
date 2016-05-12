package com.omt.learn;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "askjabcxcbakoie";
		// String s = "banana";
		System.out.println(pelindromSubstring(s));
	}

	public static String pelindromSubstring(String s) {
		String ss = "";
		char c[] = s.toCharArray();
		int length = s.length();
		boolean matrix[][] = new boolean[length][length];
		int longestStringFound = 0;
		int longest_i = 0;
		int longest_j = 0;

		for (int l = 1; l <= length; l++) {

			for (int i = 0; i < length; i++) {
				int j = i + l - 1;

				if (j < length) {

					if (l == 1) {
						matrix[i][j] = true;
						longestStringFound = l;
						longest_i = i;
						longest_j = j;
					} else {

						if ((c[i] == c[j])) {
							if (l == 2) {
								matrix[i][j] = true;
								longestStringFound = l;
								longest_i = i;
								longest_j = j;
							} else if (matrix[i + 1][j - 1]) {
								matrix[i][j] = true;
								longestStringFound = l;
								longest_i = i;
								longest_j = j;
							}
						}

					}

				}

			}

		}

		// System.out.println("Length :" + longestStringFound);
		// System.out.println("i:" + longest_i + " j" + longest_j);
		ss = s.substring(longest_i, longest_j + 1);

		return ss;

	}

}
