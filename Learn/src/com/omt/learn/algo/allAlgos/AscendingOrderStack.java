package com.omt.learn.algo.allAlgos;

import java.util.Stack;

public class AscendingOrderStack {

	public static void main(String[] args) {

		int a[] = { 2, 1, 3, 5, 4 };

		Stack<Integer> stack = new Stack<>();

		for (int i = a.length - 1; i >= 0; i--) {
			stack.push(a[i]);
		}

		stack = ascendingStack(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	public static Stack<Integer> ascendingStack(Stack<Integer> stack) {

		Stack<Integer> result = new Stack<>();

		while (!stack.isEmpty()) {

			int tmp = stack.pop();

			while (!result.isEmpty() && result.peek() > tmp) {
				stack.push(result.pop());
			}

			result.push(tmp);

		}

		return result;
	}

}