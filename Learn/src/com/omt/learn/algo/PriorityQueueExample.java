package com.omt.learn.algo;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {

		int[] a = { 3, 5, 2, 7, 9, 3, 7, 2, 1, 4, 6 };
		printFromPriorityQueue(a);

	}

	public static void printFromPriorityQueue(int[] a) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i : a) {
			pq.add(i);
		}

		while (pq.size() > 0) {
			System.out.print(pq.poll() + " ");
		}

	}

}
