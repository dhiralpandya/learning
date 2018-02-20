package com.omt.learn.practice;

public class LenghtOfLastWord {

	public static void main(String[] args) {

		String a = "omt lab";
		String b = "omt om sai ram";
		System.out.println(usingSimpleJavaLib(a));
		System.out.println(usingSimpleJavaLib(b));

		System.out.println(lowerLevelSolution(a));
		System.out.println(lowerLevelSolution(b));

	}

	public static int usingSimpleJavaLib(String s) {
		return s.length() - s.lastIndexOf(' ') - 1;
	}

	public static int lowerLevelSolution(String s) {
		s = s.trim();
		if (s.length() < 3) {
			return s.length();
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++, count++) {
			if (s.charAt(i) == ' ') {
				count = -1;
			}
		}

		return count;
	}

}
