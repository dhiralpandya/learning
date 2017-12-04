package com.omt.learn.algo;

import java.util.Calendar;

class ListNode{
	
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

public class AddTwoNumbers {
	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		int sum = l1.val+l2.val;
		int remaining = sum > 9?1:0;
		sum = sum%10;
		ListNode listNode = new ListNode(sum);
		ListNode firstNode = listNode;
		while(l1.next != null || l2.next != null) {
			sum = 0;
			
			if(l1.next != null) {
				l1 = l1.next;
				sum = l1.val;
			}
			if(l2.next != null) {
				l2 = l2.next;
				sum+= l2.val;
			}
			sum += remaining;
			remaining = sum > 9?1:0;
			sum = sum%10;
			listNode.next = new ListNode(sum);
			listNode = listNode.next;
		}
		
		
		if(remaining > 0) {
			listNode.next = new ListNode(remaining);
		}
		
		return firstNode;
	}

	
	public static void main(String...strings) {
		ListNode l1 = createListNode("2->4->3");
		ListNode l2 = createListNode("5->6->4");
		ListNode sum = addTwoNumbers(l1, l2);
		System.out.println("");
		System.out.print(sum.val);
		while(sum.next != null) {
			System.out.print("->"+sum.next.val);
			sum = sum.next;
		}
		
	}
	
	private  static ListNode createListNode(String data) {
		String[] array = data.split("->");
		ListNode listNode = null;
		for(String digit : array) {
			if(listNode == null) {
				listNode = new ListNode(Integer.parseInt(digit.trim()));
			} else {
				
				ListNode lastOne = listNode;
				while(lastOne.next != null) {
					lastOne = lastOne.next;
				}
				
				lastOne.next  = new ListNode(Integer.parseInt(digit.trim()));
			}
		}
		return listNode;
	}
}
