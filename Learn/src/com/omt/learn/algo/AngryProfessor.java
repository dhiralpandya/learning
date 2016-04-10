package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		long n = Long.parseLong(sn.nextLine());
		List<String> yesNo = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] line1 = sn.nextLine().split("\\s");
			long as = Long.parseLong(line1[1]);

			String[] line2 = sn.nextLine().split("\\s");
			int came = 0;
			for (String s : line2) {
				long number = Long.parseLong(s);
				if (number <= 0) {
					came++;
				}
			}

			if (came >= as) {
				yesNo.add("NO");
			} else {
				yesNo.add("YES");
			}

		}

		for (String s : yesNo) {
			System.out.println(s);
		}

	}

}
