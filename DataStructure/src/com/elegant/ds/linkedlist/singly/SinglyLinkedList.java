package com.elegant.ds.linkedlist.singly;

import java.util.Scanner;

class Node {

	Node link = null;
	int data = 0;

	public Node() {
		link = null;
		data = 0;
	}

	public Node(int data, Node link) {
		this.data = data;
		this.link = null;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [link=" + link + ", data=" + data + "]";
	}
}

class SinglyLinkedListImpl {

	Node start = null;
	Node end = null;
	int size = 0;

	public SinglyLinkedListImpl() {
		start = null;
		end = null;
		size = 0;
	}

	public void insertAtStart(int data) {

		Node nptr = new Node(data, null);
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLink(start);
			start = nptr;
		}
		size++;
		display();
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}

		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}

		Node startPtr = start;
		System.out.print(startPtr.getData() + "->");
		startPtr = startPtr.getLink();
		while (startPtr.getLink() != null) {
			System.out.print(startPtr.getData() + "->");
			startPtr = startPtr.getLink();
		}
		System.out.println(startPtr.getData());
	}

	public void insertAtEnd(int data) {

		Node nptr = new Node(data, null);
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
		size++;
		display();
	}

	public void insertAtPosition(int position, int data) {

		if (position == 1) {
			insertAtStart(data);
			return;
		}

		if (position == getSize()) {
			insertAtEnd(data);
			return;
		}

		Node nptr = new Node(data, null);
		Node startPtr = start;
		position = position - 1;

		for (int i = 1; i < size; i++) {

			if (i == position) {
				Node temp = startPtr.getLink();
				nptr.setLink(temp);
				startPtr.setLink(nptr);
				size++;
				display();
				break;
			}
			startPtr = startPtr.getLink();
		}
	}

	public void delete(int position) {

		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}

		if (position == 1) {
			start = start.getLink();
			size--;
			display();
			return;
		}

		if (position == getSize()) {
			Node startPtr = start;
			Node endPtr = start;
			while (startPtr != end) {
				endPtr = startPtr;
				startPtr = startPtr.getLink();
			}
			endPtr.setLink(null);
			end = endPtr;
			size--;
			display();
			return;
		}

		Node startPtr = start;
		position = position - 1;
		for (int i = 1; i < getSize(); i++) {
			if (i == position) {
				Node temp = startPtr.getLink();
				temp = temp.getLink();
				startPtr.setLink(temp);
				size--;
				display();
				return;
			}
			startPtr = startPtr.getLink();
		}
	}

	public boolean isEmpty() {
		return start == null;
	}

	public int getSize() {
		return size;
	}

	public void replace(int position, int data) {

		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}

		if (position == 1) {
			start.setData(data);
			display();
			return;
		}

		if (position == getSize()) {
			end.setData(data);
			display();
			return;
		}

		Node startPtr = start;
		position = position - 1;
		startPtr = startPtr.getLink();
		for (int i = 1; i < getSize(); i++) {
			if (i == position) {
				startPtr.setData(data);
				display();
				return;
			}
			startPtr = startPtr.getLink();
		}
	}

	public void getElement(int position) {
		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}
		if (position == 1) {
			System.out.println(start.getData() + " present at " + position + " position");
			return;
		}

		if (position == getSize()) {
			System.out.println(end.getData() + " present at " + position + " position");
			return;
		}

		Node startPtr = start;
		position = position - 1;
		startPtr = startPtr.getLink();
		for (int i = 1; i < getSize(); i++) {
			if (i == position) {
				System.out.println(startPtr.getData() + " present at " + (position + 1) + " position");
				break;
			}
			startPtr = startPtr.getLink();
		}
	}

	public void positionOfElement(int data) {
		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}
		if (start.getData() == data) {
			System.out.println(data + " position is 1");
			return;
		}
		if (end.getData() == data) {
			System.out.println(data + " position is " + getSize());
			return;
		}
		Node startPtr = start;
		startPtr = startPtr.getLink();
		int index = 1;
		boolean isFound = false;
		while (startPtr != end) {
			++index;
			if (startPtr.getData() == data) {
				System.out.println(data + " position is " + index);
				isFound = true;
				break;
			}
			startPtr = startPtr.getLink();
		}
		if (!isFound) {
			System.out.println(data + " not present in the list");
		}
	}

	public void deleteNode(int data) {

		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}
		if (start.getData() == data && start.getLink() == null) {
			start = null;
			end = null;
			size--;
			return;
		}
		if (start.getData() == data && start.getLink() != null) {

			start = start.getLink();
			size--;
			display();
			return;
		}

		Node startPtr = start;
		Node prevPtr = start;
		boolean isNode = false;
		while (startPtr.getLink() != null) {
			prevPtr = startPtr;
			startPtr = startPtr.getLink();
			if (startPtr.getData() == data) {
				Node temp = startPtr.getLink();
				prevPtr.setLink(temp);
				isNode = true;
				size--;
				break;
			}
		}
		if (!isNode) {
			System.out.println("There is no Node present with " + data);
			return;
		}
		display();
	}

	public void recursiveSearch(Node start, int data, int count) {
		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}
		if (start.getData() == data) {
			System.out.println(data + " found at " + (++count) + " position");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(data + " not in the list");
			return;
		}
		recursiveSearch(start.getLink(), data, ++count);
	}

	public void swapNode(int firstData, int secondData) {
		if (isEmpty()) {
			System.out.println("Empty!");
			return;
		}

		if (firstData == secondData) {
			System.out.println("Can't be swap for same data");
			return;
		}

		Node firstDataLink = start;
		Node tempFirstDataLink = start;
		while (firstDataLink.getData() != firstData && firstDataLink.getLink() != null) {
			tempFirstDataLink = firstDataLink;
			firstDataLink = firstDataLink.getLink();
		}

		Node seconDataLink = start;
		Node tempSecondDataLink = start;
		while (seconDataLink.getData() != secondData && seconDataLink.getLink() != null) {
			tempSecondDataLink = seconDataLink;
			seconDataLink = seconDataLink.getLink();
		}

		Node temp1 = firstDataLink.getLink();
		Node temp2 = seconDataLink.getLink();
		firstDataLink.setLink(temp2);
		seconDataLink.setLink(temp1);
		tempFirstDataLink.setLink(seconDataLink);
		tempSecondDataLink.setLink(firstDataLink);
		display();
	}
}

public class SinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedListImpl listImpl = new SinglyLinkedListImpl();
		boolean yes = true;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Singly Linked List Operations : ");
			System.out.println("1. insert at Start");
			System.out.println("2. insert at End");
			System.out.println("3. insert at Position");
			System.out.println("4. Delete at position ");
			System.out.println("5. Check Empty");
			System.out.println("6. Size ");
			System.out.println("7. Display");
			System.out.println("8. Replace data at given postion");
			System.out.println("9. Get Element by position ");
			System.out.println("10. Get Element's Position");
			System.out.println("11. Delete a node by given Data");
			System.out.println("12. Search Element recursively ");
			System.out.println("13. Swap Nodes for Given Data");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				listImpl.insertAtStart(scanner.nextInt());
				break;

			case 2:
				listImpl.insertAtEnd(scanner.nextInt());
				break;

			case 3:
				int position = scanner.nextInt();
				if (position < 1 || position > listImpl.getSize()) {
					System.out.println("invalid Position!");
					break;
				}
				listImpl.insertAtPosition(position, scanner.nextInt());
				break;

			case 4:
				position = scanner.nextInt();
				if (position < 1 || position > listImpl.getSize()) {
					System.out.println("Invalid Position!");
					break;
				}
				listImpl.delete(position);
				break;

			case 5:
				System.out.println(listImpl.isEmpty());
				break;

			case 6:
				System.out.println(listImpl.getSize());
				break;

			case 7:
				listImpl.display();
				break;

			case 8:
				position = scanner.nextInt();
				if (position < 1 || position > listImpl.getSize()) {
					System.out.println("Invalid Position");
					break;
				}
				listImpl.replace(position, scanner.nextInt());
				break;
			case 9:
				position = scanner.nextInt();
				if (position < 1 || position > listImpl.getSize()) {
					System.out.println("Invalid Position");
					break;
				}
				listImpl.getElement(position);
				break;

			case 10:
				listImpl.positionOfElement(scanner.nextInt());
				break;

			case 11:
				listImpl.deleteNode(scanner.nextInt());
				break;

			case 12:
				listImpl.recursiveSearch(listImpl.start, scanner.nextInt(), 0);
				break;

			case 13:
				System.out.println("Conditions : ");
				System.out.println("a. x and y may or may not be adjacent.");
				System.out.println("b. Either x or y may not be a head node");
				System.out.println("c. Either x or y may not be last node");
				listImpl.swapNode(scanner.nextInt(), scanner.nextInt());
				break;

			default:
				break;
			}
		} while (yes);
	}
}
