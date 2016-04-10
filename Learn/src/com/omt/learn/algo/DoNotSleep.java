package com.omt.learn.algo;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class DoNotSleep {

	public static void main(String args[]) throws AWTException, InterruptedException {

		Robot r = new Robot();

		int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
		int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
		int addX = 20;
		int addY = 20;
		while (true) {

			r.mouseMove(x + addX, y + addY);
			Thread.sleep(5000);
			addX *= (-1);
			addY *= (-1);
		}

	}

}
