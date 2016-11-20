package com.omt.learn.crackingcodinginterview.linkedlist.util;

public class LinkedListUtil {

	public static LinkedList createLinkedListData(int dataCount) {

		LinkedList ll = new LinkedList();

		for (int count = 1; count <= dataCount; count++) {
			ll.add(new LinkedList.Node(Integer.toString(count)));
		}

		return ll;

	}

	public static void printLinkedListValues(LinkedList l) {
		LinkedList.Node n = l.head();

		while (n != null) {
			System.out.println(n.getData());
			n = n.getNext();
		}
	}

}
