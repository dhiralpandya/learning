package com.omt.learn.practice;

import com.omt.learn.algo.util.linkedlist.ListNode;

public class ReverseLinkedList {

	public static void main(String args[]) {

		ListNode ln = ListNode.createListNode("2->4->3->10->7");
		ln = reverse(ln);
		System.out.println(ln.toString());

	}

	public static ListNode reverse(ListNode root) {

		if (root.next == null) {
			return root;
		}

		ListNode last = reverse(root.next);
		root.next.next = root;
		root.next = null;
		return last;

	}

}
