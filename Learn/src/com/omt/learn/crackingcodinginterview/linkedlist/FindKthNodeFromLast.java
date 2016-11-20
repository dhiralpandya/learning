package com.omt.learn.crackingcodinginterview.linkedlist;

import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList;
import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList.Node;
import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedListUtil;

public class FindKthNodeFromLast {

	public static void main(String[] args) {
		LinkedList l = LinkedListUtil.createLinkedListData(10);
		System.out.println(printKthNodeRecursiveWay(l.head(), 3));
	}

	public static Node kthNodeFromLast(Node head, int k) {

		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return null;
			}

			p1 = p1.getNext();
		}

		while (p1 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}

		return p2;
	}

	public static int printKthNodeRecursiveWay(Node head, int k) {

		if (head.getNext() == null) {
			return 0;
		}

		int index = printKthNodeRecursiveWay(head.getNext(), k) + 1;

		if (index == k) {
			System.out.println(head.getData());
		}

		return index;
	}
}
