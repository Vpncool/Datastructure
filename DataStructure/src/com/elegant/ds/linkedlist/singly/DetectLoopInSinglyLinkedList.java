package com.elegant.ds.linkedlist.singly;

public class DetectLoopInSinglyLinkedList {

	LLNode head = null;

	class LLNode {
		int data;
		LLNode next;

		LLNode(int data) {
			this.data = data;
			next = null;
		}
	}

	public void push(int data) {

		LLNode newNode = new LLNode(data);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {

	}

}
