package com.omt.learn.algo.allAlgos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeFormate {

	public static void main(String[] args) throws ParseException {

		Scanner sn = new Scanner(System.in);
		String time = sn.nextLine().replace("AM", " AM").replace("PM", " PM");

		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ss a");
		Date date = parseFormat.parse(time);
		System.out.println(displayFormat.format(date));

	}

}
