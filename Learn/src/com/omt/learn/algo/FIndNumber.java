package com.omt.learn.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class FIndNumber {

	public static void main(String args[]) throws FileNotFoundException, IOException {
		String s = "This 78493 is 22 and 66 and ldjfkl 78493434";
		Pattern p = Pattern.compile("-?\\d{15}");
		Matcher m = p.matcher(readMail());
		while (m.find()) {
			System.out.println(m.group());
		}
	}

	private static String readMail() throws FileNotFoundException, IOException {

		StringWriter sw = new StringWriter();
		IOUtils.copy(new FileInputStream("mail.txt"), sw);

		return sw.toString();

	}
}
