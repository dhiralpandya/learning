package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringDecoder {

	public static void main(final String[] args) {

		final Map<String, String> codes = new HashMap<>();
		codes.put("0", "+");
		codes.put("1", "A");
		codes.put("2", "B");
		codes.put("3", "C");
		codes.put("4", "D");
		codes.put("5", "E");
		codes.put("6", "F");
		codes.put("7", "G");
		codes.put("8", "H");
		codes.put("9", "I");
		codes.put("10", "J");
		codes.put("11", "K");
		codes.put("12", "L");
		codes.put("13", "M");
		codes.put("14", "N");
		codes.put("15", "O");
		codes.put("16", "P");
		codes.put("17", "Q");
		codes.put("18", "R");
		codes.put("19", "S");
		codes.put("20", "T");
		codes.put("21", "U");
		codes.put("22", "V");
		codes.put("23", "W");
		codes.put("24", "X");
		codes.put("25", "Y");
		codes.put("26", "Z");

		System.out.println(decode("193827919485797749837291", codes));
	}

	private static List<StringBuilder> decode(final String string, final Map<String, String> codes) {
		List<StringBuilder> result = new ArrayList<StringBuilder>();
		final Map<StringBuilder, Integer> indexMap = new HashMap<>();
		char currentChar, nextChar = 0;
		for (int i = 0; i < string.length(); i++) {
			currentChar = string.charAt(i);
			if (i < string.length() - 1) {
				nextChar = string.charAt(i + 1);
			} else {
				nextChar = 0;
			}

			if (currentChar == '1' || (currentChar == '2' && nextChar >= '0' && nextChar <= '6')) {
				final String code1 = codes.get("" + currentChar);
				final String code2 = codes.get("" + currentChar + nextChar);
				result = addToResult(code1, code2, i, result, indexMap);
			} else {
				final String code = codes.get("" + currentChar);
				result = addToResult(code, result, i, indexMap);
			}

		}
		return result;

	}

	private static List<StringBuilder> addToResult(final String code1, final String code2, final int index,
			final List<StringBuilder> result, final Map<StringBuilder, Integer> indexMap) {
		final List<StringBuilder> resultStringbuilder = new ArrayList<StringBuilder>();
		if (result.isEmpty()) {
			final StringBuilder decodeString1 = new StringBuilder(code1);
			final StringBuilder decodeString2 = new StringBuilder(code2);
			resultStringbuilder.add(decodeString1);
			resultStringbuilder.add(decodeString2);
			indexMap.put(decodeString1, index);
			indexMap.put(decodeString2, index + 1);

		} else {
			for (final StringBuilder decodedString : result) {
				final int indexForDeocdedString = indexMap.get(decodedString);
				if (indexForDeocdedString < index) {
					final StringBuilder newDecodedString = new StringBuilder(decodedString).append(code1);
					resultStringbuilder.add(newDecodedString);
					indexMap.put(newDecodedString, index);
					final StringBuilder newDecodedString2 = new StringBuilder(decodedString).append(code2);
					resultStringbuilder.add(newDecodedString2);
					indexMap.put(newDecodedString2, index + 1);
				} else {
					resultStringbuilder.add(decodedString);
				}
			}
		}
		return resultStringbuilder;
	}

	private static List<StringBuilder> addToResult(final String code, final List<StringBuilder> result, final int index,
			final Map<StringBuilder, Integer> indexMap) {
		final List<StringBuilder> resultStringbuilder = new ArrayList<StringBuilder>();
		if (result.isEmpty()) {
			resultStringbuilder.add(new StringBuilder(code));
		} else {
			for (final StringBuilder decodedString : result) {
				final int indexForDeocdedString = indexMap.get(decodedString);
				if (indexForDeocdedString < index) {
					final StringBuilder newDecodedString = new StringBuilder(decodedString).append(code);
					resultStringbuilder.add(newDecodedString);
					indexMap.put(newDecodedString, index);
				} else {
					resultStringbuilder.add(decodedString);
				}
			}
		}
		return resultStringbuilder;
	}

}