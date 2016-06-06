package com.omt.learn.algo;

import java.util.PriorityQueue;

public class JoinTheRope {

	public static void main(String[] args) {
		int a[] = { 2, 34, 6, 3, 12, 87, 78, 5, 33, 42, 6, 1, 3, 2, 4, 6, 8, 2, 1 };
		joinRope(a);
	}

	public static void joinRope(int a[]) {

		PriorityQueue<Integer> p = new PriorityQueue<>();

		for (int i : a) {
			p.add(i);
		}

		while (p.size() > 1) {
			p.add(p.poll() + p.poll());
		}

		System.out.println(p.poll());

	}

}
