package com.elegant.ds.linkedlist.practice;

public class DetectAndRemoveLoop {

	static LinkedNode head;

	static class LinkedNode {

		int data;
		LinkedNode next;

		LinkedNode() {

		}

		LinkedNode(int data) {
			this.data = data;
			next = null;
		}
	}

	private void detectAndRemoveLoop(LinkedNode node) {
		if (node == null || node.next == null)
			return;

		LinkedNode slow = node;
		LinkedNode fast = node;

		slow = slow.next;
		fast = fast.next.next;

		while (fast != null || fast.next != null) {
			if (slow == fast)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}

		/* if loop exist */
		if (slow == fast) {
			slow = node;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}

	private void printList(LinkedNode node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {

		DetectAndRemoveLoop list = new DetectAndRemoveLoop();
		list.head = new LinkedNode(50);
		list.head.next = new LinkedNode(40);
		list.head.next.next = new LinkedNode(30);
		list.head.next.next.next = new LinkedNode(20);
		list.head.next.next.next.next = new LinkedNode(10);

		// creating loop for testing
		head.next.next.next.next.next = head.next.next;

		list.detectAndRemoveLoop(head);
		list.printList(head);
	}

}
