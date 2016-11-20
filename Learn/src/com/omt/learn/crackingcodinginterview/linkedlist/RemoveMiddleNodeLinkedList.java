package com.omt.learn.crackingcodinginterview.linkedlist;

import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList;
import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList.Node;
import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedListUtil;

public class RemoveMiddleNodeLinkedList {

	public static void main(String[] args) {

		LinkedList l = LinkedListUtil.createLinkedListData(11);

		LinkedListUtil.printLinkedListValues(l);

		removeMiddleNode(l);

		LinkedListUtil.printLinkedListValues(l);

	}

	public static void removeMiddleNode(LinkedList l) {

		Node head = l.head().getNext();
		Node p1 = head.getNext();
		Node p2 = head;
		int next = 0;
		while (p1 != null) {
			p1 = p1.getNext();
			next++;
			if (next % 2 == 0) {
				p2 = p2.getNext();
			}
		}

		System.out.println("Got Middle Node :" + p2.getData());

		Node temp = p2.getNext();
		p2.setData(temp.getData());
		p2.setNext(temp.getNext());

	}

}
