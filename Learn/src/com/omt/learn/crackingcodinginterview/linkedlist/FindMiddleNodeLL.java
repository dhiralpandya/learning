package com.omt.learn.crackingcodinginterview.linkedlist;

import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList;
import com.omt.learn.crackingcodinginterview.linkedlist.util.LinkedList.Node;

public class FindMiddleNodeLL {

	public static void main(String[] args) {

		Node n = createLinkedListData(11).head();

		Node p1 = n.getNext();
		Node p2 = p1;
		int index = 0;

		while (p1 != null) {

			p1 = p1.getNext();
			index++;
			if (index % 2 == 0) {
				p2 = p2.getNext();
			}

		}

		System.out.println("Middle Node is :" + p2.getData());

	}

	public static LinkedList createLinkedListData(int dataCount) {

		LinkedList ll = new LinkedList();

		for (int count = 1; count <= dataCount; count++) {
			ll.add(new LinkedList.Node(Integer.toString(count)));
		}

		return ll;

	}

}
