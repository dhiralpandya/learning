package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceList {

	public static void main(String[] args) {
		int[] i = { 16, 3, 5, 19, 10, 14, 12, 0, 15 };
		List<Integer> l = longestSubSList(i);
		System.out.print("[ ");
		for (int n : l) {
			System.out.print(n + " ");
		}
		System.out.print("]");
	}

	public static List<Integer> longestSubSList(int[] array) {

		List<List<Integer>> listOfAllCombination = new ArrayList<>();

		for (int i : array) {

			boolean isListFound = false;
			List<List<Integer>> tempListOfList = new ArrayList<>();
			for (List<Integer> compare : listOfAllCombination) {
				if (compare.get(compare.size() - 1) < i) {
					List<Integer> selectedList = new ArrayList<>();
					selectedList.addAll(compare);
					selectedList.add(i);
					tempListOfList.add(selectedList);
					isListFound = true;
				}
			}
			listOfAllCombination.addAll(tempListOfList);
			if (!isListFound) {
				List<Integer> selectedList = new ArrayList<>();
				selectedList.add(i);
				listOfAllCombination.add(selectedList);
			}

		}

		List<Integer> selectedList = listOfAllCombination.get(0);

		for (List checkSize : listOfAllCombination) {
			if (checkSize.size() > selectedList.size()) {
				selectedList = checkSize;
			}
		}

		return selectedList;
	}

}
