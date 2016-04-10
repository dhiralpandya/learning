package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine());
		// System.out.println(t);

		List<String> list = Arrays.asList(scanner.nextLine().split("\\s"));
		Collections.sort(list);
		List<Integer> intList = new LinkedList<>();
		List<Integer> zero = new ArrayList();
		zero.add(0);

		for (String s : list) {
			intList.add(Integer.parseInt(s));
		}

		// System.out.println(t);
		while (intList.size() > 1) {
			int count = 0;
			int currentSize = intList.size();
			System.out.println(currentSize);
			int first = intList.get(count);
			while (count < currentSize) {
				// System.out.println("intList.get(count) - first :" +
				// (intList.get(count) - first));
				int sub = (intList.get(count) - first);
				intList.remove(count);
				intList.add(count, sub);
				// System.out.println(intList.toString());
				count++;
			}
			intList.removeAll(zero);
			// System.out.println(intList.toString());
		}
		if (intList.size() != 0) {
			System.out.println(intList.size());
		}
	}
	// 4 5 6 3 4 1 3 7 5
	// 1 3 3 4 4 5 5 6 7
	// 2 2 3 3 4 4 5 6
	// 1 1 2 2 3 4
	//
}
