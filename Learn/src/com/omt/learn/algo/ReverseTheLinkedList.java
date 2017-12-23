package com.omt.learn.algo;

public class ReverseTheLinkedList {

	public static void main(String args[]) {

		ListNode ln = createListNode("2->4->3->10->7");

		ListNode reversed = reverseTheListByWhileLoop(ln);

		while (reversed != null) {
			System.out.print(reversed.val + "->");
			reversed = reversed.next;
		}

		ln = createListNode("2->4->3->10->7->12->17");
		reversed = reverseTheLinkedListRecursive(ln);
		System.out.println("\n--------------");
		while (reversed != null) {
			System.out.print(reversed.val + "->");
			reversed = reversed.next;
		}
	}

	public static ListNode reverseTheLinkedListRecursive(ListNode head) {
		if (head.next == null) {
			return head;
		}

		ListNode lastNode = reverseTheLinkedListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return lastNode;

	}

	public static ListNode reverseTheListByWhileLoop(ListNode head) {

		ListNode current = head;
		ListNode previous = null;

		while (current != null) {
			ListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;

		}

		return previous;

	}

	private static ListNode createListNode(String data) {
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
}
