package com.omt.learn.javarelated;

public class ThreadPrio {

	public static void main(String args[]) {
		Thread t1 = new Thread() {

			@Override
			public void run() {
				int i = 0;
				while (i < 9) {
					i++;
					System.out.println("Child Thread");
				}
			}
		};

		// t1.setPriority(10);
		t1.setPriority(782);
		t1.start();
		// t1.interrupt();
		int i = 0;
		while (i < 9) {
			i++;
			System.out.println("Main Thread");
		}

	}

}
