package com.elegant.ds.stack;

import java.util.NoSuchElementException;
import java.util.Scanner;


class Node {
	private int data = 0;
	private Node link = null;

	public Node() {

	}

	public Node(int data, Node link) {
		this.data = data;
		this.link = link;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}

}

class LinkedStack {

	private Node top = null;
	private int size = 0;

	public LinkedStack() {
		top = null;
		size = 0;
	}

	public void push(int item) {
		Node nptr = new Node(item, null);
		if (isEmpty()) {
			top = nptr;
		} else {
			nptr.setLink(top);
			top = nptr;
		}
		size++;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int pop() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");

		Node ptr = top;
		top = ptr.getLink();
		size--;
		return ptr.getData();

	}

	public int peek() {

		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return top.getData();
	}

	public int size() {
		return size;
	}

	public int deleteMiddle() {
		return 0;
	}
}

public class LinkedStackTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedStack linkedStack = new LinkedStack();
		boolean yes = true;
		do {
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Check Empty");
			System.out.println("5. Size");
			System.out.println("6. Delete Middle Element");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the element :- ");
				linkedStack.push(scanner.nextInt());
				break;

			case 2:
				try {
					System.out.println("Popped Element = " + linkedStack.pop());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Peek Element = " + linkedStack.peek());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				System.out.println(linkedStack.isEmpty());
				break;

			case 5:
				System.out.println(linkedStack.size());
				break;

			case 6:
				try {
					System.out.println(linkedStack.deleteMiddle());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			default:
				break;
			}
		} while (yes);
	}
}
