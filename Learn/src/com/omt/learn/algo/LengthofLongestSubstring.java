package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SubStringData {
	public int start = 0;
	public int end = 0;
}

public class LengthofLongestSubstring {

	public static void main(String[] args) {

		System.out.println("Below are all Largest sub string for 'abzqbnjklmxd'");
		for (String subString : getListOfLongestSubString("abzqbnjklmxd")) {

			System.out.println(subString);
			
		}

		System.out.println("Below are all Largest sub string for 'zabac'");
		for (String subString : getListOfLongestSubString("zabac")) {
			System.out.println(subString);
		}

		System.out.println("Below are all Largest sub string for 'zabasocac'");
		for (String subString : getListOfLongestSubString("zabasocac")) {
			System.out.println(subString);
		}

	}

	public static int getLength(String s) {
		int current = 0;
		int max = 0;
		TreeMap<Character, Integer> chPosition = new TreeMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (chPosition.containsKey(s.charAt(i))) {
				if (max < current) {
					max = current;
				}

				current = i - chPosition.get(s.charAt(i));
				chPosition.put(s.charAt(i), i);
			} else {
				current++;
				chPosition.put(s.charAt(i), i);
			}
		}

		if (max < current) {
			max = current;
		}
		return max;
	}

	public static List<String> getListOfLongestSubString(String s) {
		int current = 0;
		int max = 0;
		TreeMap<Character, Integer> chPosition = new TreeMap<>();
		TreeMap<Integer, List<SubStringData>> lengthAndStringData = new TreeMap<>();
		SubStringData currentData = new SubStringData();
		currentData.start = 0;

		for (int i = 0; i < s.length(); i++) {
			if (chPosition.containsKey(s.charAt(i))) {

				if (lengthAndStringData.containsKey(current)) {
					lengthAndStringData.get(current).add(currentData);
				} else {
					ArrayList<SubStringData> arrayList = new ArrayList<>();
					arrayList.add(currentData);
					lengthAndStringData.put(current, arrayList);
				}

				currentData = new SubStringData();

				if (max < current) {
					max = current;
				}

				currentData.start = chPosition.get(s.charAt(i)) + 1;
				currentData.end = i;
				current = i - chPosition.get(s.charAt(i));
				chPosition.put(s.charAt(i), i);
			} else {

				current++;
				currentData.end = i;
				chPosition.put(s.charAt(i), i);
			}
		}

		if (max < current) {
			max = current;
		}

		if (lengthAndStringData.containsKey(current)) {
			lengthAndStringData.get(current).add(currentData);
		} else {
			ArrayList<SubStringData> arrayList = new ArrayList<>();
			arrayList.add(currentData);
			lengthAndStringData.put(current, arrayList);
		}

		List<String> listOfLargestSubString = new ArrayList<>();
		for (SubStringData data : lengthAndStringData.get(max)) {
			listOfLargestSubString.add(s.substring(data.start, data.end + 1));
		}

		return listOfLargestSubString;
	}

}
