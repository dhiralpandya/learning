package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * zzsd
zasd
qazyc
dzaq
yczaq
czq
czqa
caq

 */

public class CustomSortingUsingJavaClasses {

	public static void main(String args[]) {

		Map<Character, Integer> characterIndexMap = new TreeMap<Character, Integer>() {
			{
				put('z', 0);
				put('q', 1);
				put('a', 2);
				put('s', 3);
				put('d', 4);
				put('y', 5);
				put('c', 6);
			}
		};

		List<String> listOfStringsToSort = new ArrayList<String>() {
			{
				add("zasd");
				add("qazyc");
				add("yczaq");
				add("caq");
				add("czq");
				add("dzaq");
				add("czqa");
				add("zzsd");
			}
		};

		sortList(characterIndexMap, listOfStringsToSort);

		for (String string : listOfStringsToSort) {
			System.out.println(string);
		}

	}

	public static void sortList(Map<Character, Integer> characterIndexMap, List<String> listOfStringsToSort) {

		Collections.sort(listOfStringsToSort, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				int min = Math.min(o1.length(), o2.length());

				int index = 0;
				while (index < min) {

					if (o1.charAt(index) != o2.charAt(index)) {
						return characterIndexMap.get(o1.charAt(index)) - characterIndexMap.get(o2.charAt(index));
					}

					index++;
				}

				return o1.length() - o2.length();
			};

		});

	}

}
