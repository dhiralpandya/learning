package com.omt.learn.algo.allAlgos;

import java.util.Map;
import java.util.TreeMap;

public class ReplaceKeyWithValueString {

	public static void main(String[] args) {

		String s = "Hi %NAME%, " + "This is the great mail example, " + "You got 10% discount on %ITEM%, "
				+ "Thanks for shopping with %COMPANY%,";

		// Here we have to replace three keys (%NAME% , %COMPANY% amd %ITEM%
		// with some values.)
		// NOTE : DO NOT USE replace function of string to do this.

		Map<String, String> map = new TreeMap<>();
		map.put("NAME", "Dhiral Pandya");
		map.put("ITEM", "Computer");
		map.put("COMPANY", "omtlab");

		System.out.println(replaceKeyWithValues(map, s));

	}

	public static String replaceKeyWithValues(Map<String, String> keyValue, String s) {
		StringBuilder sb = new StringBuilder();

		int index = 0;
		boolean start = false;

		StringBuilder word = new StringBuilder();
		while (index < s.length()) {

			if (s.charAt(index) == '%') {
				if (start) {

					if (keyValue.containsKey(word.toString())) {
						start = false;
						sb.append(keyValue.get(word.toString()));
					} else {
						sb.append("%" + word.toString());
					}
					word.setLength(0);
				} else {
					start = true;
				}
			} else {
				if (start) {
					word.append(s.charAt(index));
				} else {
					sb.append(s.charAt(index));
				}
			}
			index++;
		}

		return sb.toString();
	}

}
