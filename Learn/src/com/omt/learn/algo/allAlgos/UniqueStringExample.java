package com.omt.learn.algo.allAlgos;

public class UniqueStringExample {

	/**
	 * Check String contains unique character or not, Assume that all character
	 * are ASCII
	 *
	 * @param args
	 */
	public static void main(String args[]) {

		System.out.println(isStringHasAllUniqueChar("abccc"));

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isStringHasAllUniqueChar(String s) {
		// Again we are assuming that String has only ASCII characters
		if (s.length() > 256) {
			return false;
		}

		boolean[] b = new boolean[256];
		char[] chArray = s.toCharArray();

		for (int count = 0; count < chArray.length; count++) {

			int i = chArray[count];
			if (b[i]) {
				return false;
			}

			b[i] = true;
		}
		return true;
	}

}
