package com.omt.learn.algo;

public class ReverseString {

	public static void main(String args[]) {
		char s[] = "omtLab".toCharArray();
		String r = new String(reverse(0, s));
		System.out.println(r);
	}

	public static char[] reverse(int i, char source[]) {

		if (source.length / 2 == i) {
			return source;
		}

		char t = source[i];
		source[i] = source[source.length - 1 - i];
		source[source.length - 1 - i] = t;

		i++;
		return reverse(i, source);

	}

}
