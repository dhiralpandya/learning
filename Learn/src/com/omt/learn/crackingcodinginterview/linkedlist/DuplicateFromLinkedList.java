package com.omt.learn.crackingcodinginterview.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList;
import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList.Node;
import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedListUtil;

public class DuplicateFromLinkedList {

	public static void main(String[] args) {

		LinkedList l1 = LinkedListUtil.createLinkedListData(10);
		LinkedList l2 = LinkedListUtil.createLinkedListData(15);

		l1.add(l2.head());

		System.out.println("----Before Remove Duplicate----");
		LinkedListUtil.printLinkedListValues(l1);
		System.out.println("-----------");

		removeDuplicateFromLinkedListUseBuffer(l1);

		System.out.println("----After Remove Duplicate----");
		LinkedListUtil.printLinkedListValues(l1);
		System.out.println("-----------");
	}

	public static void removeDuplicateFromLinkedList(LinkedList l) {

		Node current = l.head();

		while (current != null) {
			Node runner = current;
			while (runner.getNext() != null) {
				if (runner.getNext().getData().equals(current.getData())) {
					runner.setNext(runner.getNext().getNext());
				} else {
					runner = runner.getNext();
				}
			}
			current = current.getNext();
		}

	}

	public static void removeDuplicateFromLinkedListUseBuffer(LinkedList l) {
		Set<String> set = new HashSet<>();
		Node pre = l.head();
		set.add(pre.getData());

		Node n = pre.getNext();

		while (n != null) {
			if (set.contains(n.getData())) {
				pre.setNext(n.getNext());
			} else {
				set.add(n.getData());
				pre = n;
			}
			n = n.getNext();
		}

	}

}
