package com.omt.learn.algo;

public class ThreadSyncBlock {

	private ThreadSyncBlock instanceVariable = null;
	private static ThreadSyncBlock staticVariable = new ThreadSyncBlock();

	public void instanceMethod() {

		synchronized (instanceVariable) {
			System.out.println("Testing");
		}

	}

	public static void staticMethod() {

	}

	public static void main(String args[]) {
		ThreadSyncBlock obj = new ThreadSyncBlock();
		obj.instanceMethod();
	}

}
