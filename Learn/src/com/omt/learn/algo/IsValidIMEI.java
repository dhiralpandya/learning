package com.omt.learn.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IsValidIMEI {

	public static void main(String[] args) {
		String imei = "354386767822443";
		// for (String imei : imeis()) {
		// if (isValidIMEI(imei)) {
		// System.out.println(imei);
		// }

		// System.out.println(isValidIMEI("352044076515222"));

		generateValidIMEIs(100);
		// }
	}

	public static void generateValidIMEIs(int count) {

		Random random = new Random();
		for (int index = 0; index < count; index++) {
			String imei = String.valueOf(random.nextLong()).replace("-", "").substring(0, 14);
			// System.out.println(imei);
			char[] ch = imei.toCharArray();
			int total = 0;

			for (int i = 0; i < imei.length(); i++) {

				if (i % 2 == 0) {
					total += Integer.parseInt(ch[i] + "");
				} else {
					char[] ch2 = String.valueOf((Integer.parseInt(ch[i] + "") * 2)).toCharArray();
					for (char c : ch2) {
						total += Integer.parseInt(c + "");
					}
				}

			}

			// System.out.println(total);
			char[] chT = String.valueOf(total).toCharArray();
			int lastI = Integer.parseInt(chT[chT.length - 1] + "");
			// System.out.println("Last T:" + lastI);

			// imei += imei + new String((10 - lastI));
			if (lastI > 0) {
				System.out.println(imei + (10 - lastI));
			} else {
				System.out.println(imei + "0");
			}
		}

	}

	public static boolean isValidIMEI(String imei) {
		char[] ch = imei.toCharArray();
		int total = 0;

		for (int i = 0; i < imei.length(); i++) {

			if (i % 2 == 0) {
				total += Integer.parseInt(ch[i] + "");
			} else {
				char[] ch2 = String.valueOf((Integer.parseInt(ch[i] + "") * 2)).toCharArray();
				for (char c : ch2) {
					total += Integer.parseInt(c + "");
				}
			}

		}

		return total % 10 == 0;
	}

	public static List<String> imeis() {

		List<String> imeis = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("out.txt")));

			String line = null;

			while ((line = br.readLine()) != null) {
				imeis.add(line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imeis;

	}

}
