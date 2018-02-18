package com.omt.learn.practice;

public class CountAndSay {

	public static void main(String[] args) {

		int n = 5;

		System.out.println(whatWasYesterday(n));

	}

	public static String whatWasYesterday(int n) {

		String one = "1";
		String two = "11";

		if (n == 2) {
			return two;
		} else if (n == 1) {
			return one;
		}
		String yesterday = two;
		for (int i = 3; i <= n; i++) {
			String todayIamTelling_whatWasThereYesterday = "";
			char yesterDayChars[] = yesterday.toCharArray();
			char preChar = yesterDayChars[0];
			int countOfPreChar = 1;

			for (int index = 1; index < yesterDayChars.length; index++) {
				if (yesterDayChars[index] == preChar) {
					countOfPreChar++;
				} else {
					todayIamTelling_whatWasThereYesterday += countOfPreChar + "" + preChar;
					preChar = yesterDayChars[index];
					countOfPreChar = 1;
				}
			}
			todayIamTelling_whatWasThereYesterday += countOfPreChar + "" + preChar;
			yesterday = todayIamTelling_whatWasThereYesterday;
		}

		return yesterday;
	}

}
