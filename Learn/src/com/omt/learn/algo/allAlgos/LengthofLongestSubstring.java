package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
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

		System.out.println(getLenghtOfSubString("zabasocac"));
		System.out.println(lengthOfLongestSubstring("zabasocac"));
		System.out.println(getLenghtOfSubStringWithList("zabasocac"));

	}

	public static int getLenghtOfSubString(String s) {
		Queue<Character> queue = new LinkedList<Character>();

		int max = 0;

		for (Character c : s.toCharArray()) {

			while (queue.contains(c)) {
				queue.poll();
			}
			queue.add(c);

			max = Math.max(max, queue.size());
		}

		return max;
	}

	public static int getLenghtOfSubStringWithList(String s) {
		Queue<Character> queue = new LinkedList<Character>();

		int max = 0;
		Map<Integer, List<LinkedList<Character>>> lengthStringList = new TreeMap<Integer, List<LinkedList<Character>>>();
		for (Character c : s.toCharArray()) {

			while (queue.contains(c)) {
				queue.poll();
			}
			queue.add(c);

			if (max < queue.size()) {

				max = Math.max(max, queue.size());

				if (lengthStringList.containsKey(max)) {
					lengthStringList.get(max).add(new LinkedList<>(queue));
				} else {
					ArrayList<LinkedList<Character>> list = new ArrayList<>();
					list.add(new LinkedList<>(queue));
					lengthStringList.put(max, list);
				}
			}
		}

		for (LinkedList<Character> ll : lengthStringList.get(max)) {
			StringBuilder sb = new StringBuilder();
			for (Character c : ll) {
				sb.append(c);
			}

			System.out.println(sb.toString());
		}

		return max;
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

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
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
