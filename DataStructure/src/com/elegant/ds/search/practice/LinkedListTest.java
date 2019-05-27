package com.elegant.ds.search.practice;

import java.util.Scanner;

class Node<T> {

	Node<T> next = null;
	T data = null;

	// Default constructor
	Node() {

	}

	Node(T data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList<T> {

	LinkedList() {

	}

	Node<T> head = null;
	Node<T> tail = null;

	public void insertAtStart(T data) {
		Node<T> node = new Node<T>(data);
		if (empty()) {
			head = node;
			tail = head;
		} else {
			node.next = head;
			head = node;
		}
		display();
	}

	public void insertAtEnd(T data) {
		if (empty())
			insertAtStart(data);
		else {
			Node<T> node = new Node<T>(data);
			tail.next = node;
			tail = node;
			display();
		}
	}

	public void insertAtPosition(Integer position, T data) {
		if (empty() || position < 1 || position > size())
			throw new IllegalArgumentException("Invalid Position!");

		Node<T> headPtr = head;
		Node<T> prevPtr = head;
		for (Integer i = 1; i <= size(); i++) {
			if (i == position) {
				Node<T> node = new Node<T>(data);
				node.next = headPtr;
				if (prevPtr != headPtr) {
					prevPtr.next = node;
				} else {
					head = node;
				}
				break;
			}
			prevPtr = headPtr;
			headPtr = headPtr.next;
		}
		display();

	}

	public void delete(Integer position) {
		if (empty() || position < 1 || position > size())
			throw new IllegalArgumentException("Invalid Position");

		Node<T> headPtr = head;
		Node<T> prevPtr = head;

		for (Integer i = 1; i <= size(); i++) {
			if (i == position) {
				if (headPtr != prevPtr) {
					if (headPtr.next == null) {
						prevPtr.next = null;
						tail = prevPtr;
					} else
						prevPtr.next = headPtr.next;
				} else
					head = head.next;
				break;
			}
			prevPtr = headPtr;
			headPtr = headPtr.next;
		}
		display();
	}

	public void deleteByItem(T item) {
		if (empty())
			throw new IllegalArgumentException("List is empty!");
		Node<T> headPtr = head;
		Node<T> prevPtr = head;
		while (headPtr != null && !(headPtr.data == item)) {
			prevPtr = headPtr;
			headPtr = headPtr.next;
		}
		if (headPtr == null)
			throw new IllegalArgumentException(item + " invalid operation");
		if (headPtr == prevPtr)
			head = head.next;
		else
			prevPtr.next = headPtr.next;

		if (headPtr == tail)
			tail = prevPtr;

		display();
	}

	public void replace(Integer position, T item) {
		if (empty() || position < 1 || position > size())
			throw new IllegalArgumentException("Invalid Position");

		Node<T> headPtr = head;
		for (Integer i = 1; i <= size(); i++) {
			if (position == i) {
				headPtr.data = item;
				break;
			}
			headPtr = headPtr.next;
		}
		display();
	}

	public T getItemByPosition(Integer position) {
		if (empty() || position < 1 || position > size())
			throw new IllegalArgumentException("Invalid Position!!");
		return getItemByPosition(position, 1, head);
	}

	private T getItemByPosition(Integer position, Integer count, Node<T> node) {
		return position == count ? node.data : getItemByPosition(position, ++count, node.next);
	}

	public boolean searchRecursivly(Integer item) {
		if (empty())
			throw new IllegalArgumentException("List is Empty!");
		return searchRecursivly(item, head);
	}

	private boolean searchRecursivly(Integer item, Node<T> node) {
		if (node != null)
			return node.data == item ? true : searchRecursivly(item, node.next);
		return false;
	}

	public void swapNode(T dataOne, T dataTwo) {
		if (empty())
			throw new IllegalArgumentException("List is empty!");

		if (dataOne.equals(dataTwo))
			throw new IllegalArgumentException("Both the inputs are same. Couldn't swap");

		Node<T> dataOnePtr = head;
		Node<T> prevDataOnePtr = head;

		while (dataOnePtr.next != null && !dataOnePtr.data.equals(dataOne)) {
			prevDataOnePtr = dataOnePtr;
			dataOnePtr = dataOnePtr.next;
		}

		Node<T> dataTwoPtr = head;
		Node<T> prevDataTwoPtr = head;

		while (dataTwoPtr.next != null && !dataTwoPtr.data.equals(dataTwo)) {
			prevDataTwoPtr = dataTwoPtr;
			dataTwoPtr = dataTwoPtr.next;
		}

		if (dataOnePtr.data.equals(dataOne) && dataTwoPtr.data.equals(dataTwo)) {

			Node<T> dataOneNextPtr = dataOnePtr.next;
			Node<T> dataTwoNextPtr = dataTwoPtr.next;

			// swapping second data node
			prevDataOnePtr.next = dataTwoPtr;
			dataTwoPtr.next = dataOneNextPtr;

			// swapping first data node
			prevDataTwoPtr.next = dataOnePtr;
			dataOnePtr.next = dataTwoNextPtr;

			// if node belogs to head or/and tail of linked list
			if (dataOnePtr == head)
				head = dataTwoPtr;
			else if (dataTwoPtr == head)
				head = dataOnePtr;

			if (dataOnePtr == tail)
				tail = dataTwoPtr;
			else if (dataTwoPtr == tail)
				tail = dataOnePtr;

			// if nodes belongs to adjacent node
			if (dataOnePtr == prevDataTwoPtr)
				dataTwoPtr.next = dataOnePtr;
			else if (dataTwoPtr == prevDataOnePtr)
				dataOnePtr.next = dataTwoPtr;
			display();
		} else
			throw new IllegalArgumentException("");
	}

	public void reverseRecursively() {
		if (empty())
			throw new IllegalArgumentException("List is empty");
		reverseRecursively(head);
		swapHeadandTailNode();
		display();
	}

	public Node<T> reverseRecursively(Node<T> node) {
		if (node == null || node.next == null)
			return node;
		Node<T> temp = node.next;
		node.next = null;
		Node<T> reverseRest = reverseRecursively(temp);
		temp.next = node;
		return reverseRest;
	}

	public void reverseIteratively() {
		if (empty())
			throw new IllegalArgumentException("List is empty!");
		reverseIteratively(head);
		swapHeadandTailNode();
		display();
	}

	private void reverseIteratively(Node<T> node) {
		Node<T> prev = null;
		Node<T> current = node;
		Node<T> next = null;

		while (current.next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		current.next = prev;
	}

	public Integer countOccurenceRecursively(T item) {
		if (empty())
			throw new IllegalArgumentException("List is empty!");
		return countOccurenceRecursively(item, head, 0);
	}

	private Integer countOccurenceRecursively(T item, Node<T> node, int count) {
		return node != null ? node.data.equals(item) ? countOccurenceRecursively(item, node.next, ++count) : countOccurenceRecursively(item, node.next, count) : count;
	}

	public Integer countOccurenceIteratively(T item) {
		if (empty())
			throw new IllegalArgumentException("List is empty!");

		Node<T> headPtr = head;
		Integer count = 0;
		while (headPtr != null) {
			if (headPtr.data.equals(item))
				++count;
			headPtr = headPtr.next;
		}
		return count;
	}

	private void swapHeadandTailNode() {
		Node<T> temp = head;
		head = tail;
		tail = temp;
	}

	public void display() {
		if (empty())
			throw new IllegalArgumentException("List is Empty!");
		display(head);
	}

	private void display(Node<T> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			display(node.next);
		}
	}

	public Integer size() {
		return empty() ? 0 : size(head, 0);
	}

	private Integer size(Node<T> node, Integer count) {
		return node != null ? size(node.next, ++count) : count;
	}

	public boolean empty() {
		return head == null;
	}

}

public class LinkedListTest {

	public LinkedListTest() {

	}

	public static void main(String[] args) {
		System.out.println("Welcome to singly linked list.");
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		LinkedList<Integer> list = new LinkedList<Integer>();
		do {
			System.out.println("\n0. Exit");
			System.out.println("1. Insert at Start ");
			System.out.println("2. Insert at End ");
			System.out.println("3. Insert at Position ");
			System.out.println("4. Delete at Position");
			System.out.println("5. Size of the list");
			System.out.println("6. Display the list");
			System.out.println("7. Empty status of list (true/false)");
			System.out.println("8. Delete by Item");
			System.out.println("9. Replace data at given position");
			System.out.println("10. Get element by position");
			System.out.println("11. Search element recursively");
			System.out.println("12. Swap node ");
			System.out.println("13. Reverse the list recursively");
			System.out.println("14. Reverse the list Iteratively");
			System.out.println("15. Count the item recursively");
			System.out.println("16. Count the item Iteratively");
			System.out.println("\nYour Choice");
			Integer choice = scanner.nextInt();

			switch (choice) {

			case 0:
				exit = true;
				System.out.println("You are exiting from here...");
				break;

			case 1:
				try {
					System.out.println("Insert the item ");
					Integer item = scanner.nextInt();
					list.insertAtStart(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2:
				try {
					System.out.println("Insert the item ");
					Integer item = scanner.nextInt();
					list.insertAtEnd(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:
				try {
					System.out.println("Enter the position");
					Integer position = scanner.nextInt();
					System.out.println("Insert the item ");
					Integer item = scanner.nextInt();
					list.insertAtPosition(position, item);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 4:
				try {
					System.out.println("Enter the position");
					Integer position = scanner.nextInt();
					list.delete(position);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 5:
				try {
					System.out.println(list.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 6:
				try {
					list.display();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 7:
				System.out.println(list.empty());
				break;

			case 8:
				try {
					System.out.println("Enter the item to delete");
					Integer item = scanner.nextInt();
					list.deleteByItem(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				try {
					System.out.println("Enter position");
					Integer position = scanner.nextInt();
					System.out.println("Enter the item ");
					Integer item = scanner.nextInt();
					list.replace(position, item);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 10:
				try {
					System.out.println("Enter the position ");
					Integer position = scanner.nextInt();
					System.out.println(list.getItemByPosition(position));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 11:
				try {
					System.out.println("Enter the element");
					Integer item = scanner.nextInt();
					System.out.println(list.searchRecursivly(item));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 12:
				try {
					System.out.println("Enter first node");
					Integer dataOne = scanner.nextInt();
					System.out.println("Enter second node");
					Integer dataTwo = scanner.nextInt();
					list.swapNode(dataOne, dataTwo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 13:
				try {
					list.reverseRecursively();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 14:
				try {
					list.reverseIteratively();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 15:
				try {
					System.out.println("Enter item to get occurrence ");
					Integer item = scanner.nextInt();
					System.out.println(list.countOccurenceRecursively(item));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 16:
				try {
					System.out.println("Enter item to get occurrence ");
					Integer item = scanner.nextInt();
					System.out.println(list.countOccurenceIteratively(item));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 17:
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 18:
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Sorry! This Operation yet to define!");
				break;
			}

		} while (!exit);
		scanner.close();
	}
}