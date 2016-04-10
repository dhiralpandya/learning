package com.omt.learn.javarelated;

public class ThreadJoinChildMain {

	public static void main(String... args) throws InterruptedException {

		Thread.currentThread().setName("MAIN THREAD");

		MyThread t = new ThreadJoinChildMain().new MyThread();
		t.start();

		Thread.sleep(10000);

		t.join();// Main THread will wait for t to finish

		Thread.sleep(2000);
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread ");
		}

	}

	class MyThread extends Thread {

		private Thread mainThread;

		public MyThread() {
			super("CHILD THREAD");
		}

		@Override
		public synchronized void start() {
			mainThread = Thread.currentThread();
			super.start();

		}

		@Override
		public void run() {

			try {
				mainThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("Chile Thread : " + mainThread.getName());
			}

		}

	}

}
