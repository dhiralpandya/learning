package com.omt.learn.algo.allAlgos;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

	public static void main(String[] args) {

		// for (String s : permutation("abc".toCharArray(), 0)) {
		// System.out.println(s);
		// }

		perm1("abc");

	}

	public static void perm1(String s) {
		perm1("", s);
	}

	private static void perm1(String prefix, String s) {
		int N = s.length();
		if (N == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < N; i++) {
				System.out.println(
						"perm1(" + prefix + s.charAt(i) + "," + s.substring(0, i) + s.substring(i + 1, N) + ")");
				perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N));
			}
		}

	}

	private static Set<String> permutation(char[] input, int count) {
		Set<String> set = new HashSet<>();

		if (count == input.length) {

			return set;
		}

		char c = input[count];
		StringBuilder sbil = new StringBuilder();

		for (int k = 0; k < input.length; k++) {
			if (count != k) {
				sbil.append(input[k]);
			}
		}

		String op = sbil.toString();

		int size = op.length();

		for (int i = 0; i <= size; i++) {

			StringBuilder sb = new StringBuilder();
			int index = 0;
			for (char t : op.toCharArray()) {
				if (index == i) {
					sb.append(c);
				}
				sb.append(t);
				index++;

			}

			if (sb.length() == size) {
				sb.append(c);
			}

			set.add(sb.toString());
		}

		set.addAll(permutation(input, count + 1));

		return set;

	}

}
