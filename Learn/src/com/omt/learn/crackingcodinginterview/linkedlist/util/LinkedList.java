package com.omt.learn.crackingcodinginterview.linkedlist.util;

public class LinkedList {

	private Node head = null;
	private Node tail = null;

	public LinkedList() {
		head = new Node("HEAD");
		tail = head;
	}

	public void add(Node n) {
		tail.next = n;
		tail = n;
	}

	public Node head() {
		return head;
	}

	public static class Node {

		private String data = null;
		private Node next = null;

		public Node(String data) {
			this.data = data;
		}

		public Node() {

		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

	}

}
