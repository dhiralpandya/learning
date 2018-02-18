package com.omt.learn.algo.util.linkedlist;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public static ListNode createListNode(String data) {
		String[] array = data.split("->");
		ListNode listNode = null;
		for (String digit : array) {
			if (listNode == null) {
				listNode = new ListNode(Integer.parseInt(digit.trim()));
			} else {

				ListNode lastOne = listNode;
				while (lastOne.next != null) {
					lastOne = lastOne.next;
				}

				lastOne.next = new ListNode(Integer.parseInt(digit.trim()));
			}
		}
		return listNode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode node = this;
		while (node != null) {
			builder.append(node.val + "->");
			node = node.next;
		}
		return builder.toString();
	}

}
