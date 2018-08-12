package com.omt.learn.algo.allAlgos;

public class ReverseStringDifferentWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("dhiral"));

		// Node

	}

	public static String reverseString(String s) {
		int length = s.length();
		s = (s + s).substring(length / 2, (length * 2) - (length / 2));

		return s;

	}

}
