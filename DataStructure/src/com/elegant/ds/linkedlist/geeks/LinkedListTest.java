package com.elegant.ds.linkedlist.geeks;

import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.crypto.Data;

class Node<T> {

	Node<T> next = null;
	T data;

	Node(T data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList<T> {

	Node<T> head = null;
	Node<T> last = null;

	public LinkedList() {
		head = null;
		last = null;
	}

	public void insertAtFirst(T data) {
		Node<T> nptr = new Node<T>(data);
		if (head == null) {
			head = nptr;
			last = head;
		} else {
			nptr.next = head;
			head = nptr;
		}
		display(head);
	}

	public void insertAtLast(T data) {
		Node<T> nptr = new Node<T>(data);
		if (empty()) {
			head = nptr;
			last = nptr;
		} else {
			last.next = nptr;
			last = nptr;
		}
		display(head);
	}

	public void insertAtPosition(int position, T data) {
		if (empty()) {
			insertAtFirst(data);
			return;
		}

		Node<T> headPtr = head;
		position -= 1;
		for (int i = 1; i < size(); i++) {
			if (position == i) {
				Node<T> nptr = new Node<T>(data);
				Node<T> temp = headPtr.next;
				headPtr.next = nptr;
				nptr.next = temp;
				break;
			}
			headPtr = headPtr.next;
		}
		display(head);
	}

	public void delete(int position) {
		if (empty())
			throw new NoSuchElementException("List is Empty!");

		if (position == 1) {
			if (head.next == null) {
				head = null;
			} else {
				Node<T> temp = head.next;
				head = temp;
			}
			display(head);
			return;
		}

		if (position == size()) {
			Node<T> headPtr = head;
			Node<T> lastPtr = headPtr;
			while (headPtr.next != null) {
				lastPtr = headPtr;
				headPtr = headPtr.next;
			}
			lastPtr.next = null;
			last = lastPtr;
			display(head);
			return;
		}

		Node<T> startPtr = head;
		position -= 1;
		for (int i = 1; i < size(); i++) {
			if (i == position) {
				Node<T> temp = startPtr.next;
				temp = temp.next;
				startPtr.next = temp;
			}
			startPtr = startPtr.next;
		}
		display(head);
	}

	public void display(Node<T> link) {
		if (link != null) {
			System.out.print(link.data + " ");
			display(link.next);
		}
	}

	public int size() {
		if (empty())
			throw new NoSuchElementException("List is Empty");

		Node<T> headPtr = head;
		int count = 1;
		while (headPtr.next != null) {
			count++;
			headPtr = headPtr.next;
		}
		return count;
	}

	public void replace(int position, T data) {
		if (empty())
			throw new NoSuchElementException("List is Empty!");

		Node<T> startPtr = head;
		for (int i = 1; i < size(); i++) {
			if (i == position) {
				startPtr.data = data;
				break;
			}
			startPtr = startPtr.next;
		}
		display(head);
	}

	public T elementByPosition(int position, Node<T> link, int count) {
		if (count == position) {
			return link.data;
		}
		return elementByPosition(position, link.next, ++count);
	}

	public int searchElement(T data, Node<T> link, int position) {
		if (empty())
			throw new NoSuchElementException("List is Empty!");

		if (link.data == data)
			return position;

		return searchElement(data, link.next, ++position);
	}

	public Node<T> getLinkByData(T data, Node<T> link) {
		if (link == null)
			return link;

		if (link.data == data)
			return link;

		return getLinkByData(data, link.next);
	}

	public void swapData(T firstData, T secondData) {
		if (empty())
			throw new NoSuchElementException("List is Empty!");

		Node<T> firstDataLink = getLinkByData(firstData, head);
		Node<T> secondDataLink = getLinkByData(secondData, head);
		if (firstDataLink == null || secondDataLink == null) {
			throw new NoSuchElementException("Eithe " + firstData + " or " + secondData + " not in the list");
		}
		firstDataLink.data = secondData;
		secondDataLink.data = firstData;
		display(head);
	}

	public void swapNode(T firstData, T secondData) {

		if (empty())
			throw new NoSuchElementException("List is Empty!");

		if (firstData == secondData)
			throw new NoSuchElementException("Can't swap for identical data");

		boolean foundFirstData = false;
		boolean foundSecondData = false;

		Node<T> firstDataPtr = head;
		Node<T> prevFirstDataPtr = head;
		while (firstDataPtr.next != null && !(firstDataPtr.data == firstData)) {
			prevFirstDataPtr = firstDataPtr;
			firstDataPtr = firstDataPtr.next;
		}
		if (firstDataPtr.data == firstData)
			foundFirstData = true;

		Node<T> secondDataPtr = head;
		Node<T> prevSecondDataPtr = head;
		while (secondDataPtr.next != null && !(secondDataPtr.data == secondData)) {
			prevSecondDataPtr = secondDataPtr;
			secondDataPtr = secondDataPtr.next;
		}
		if (secondDataPtr.data == secondData)
			foundSecondData = true;

		if (foundFirstData && foundSecondData) {

			// if data belongs to start or last node
			if (firstDataPtr == head)
				head = secondDataPtr;
			else if (secondDataPtr == head)
				head = firstDataPtr;

			if (firstDataPtr == last)
				last = secondDataPtr;
			else if (secondDataPtr == last)
				last = firstDataPtr;

			Node<T> nextFirstDataPtr = firstDataPtr.next;
			Node<T> nextSecondDataPtr = secondDataPtr.next;

			prevFirstDataPtr.next = secondDataPtr;
			secondDataPtr.next = nextFirstDataPtr;

			prevSecondDataPtr.next = firstDataPtr;
			firstDataPtr.next = nextSecondDataPtr;

			// if items belongs to adjacent node
			if (prevSecondDataPtr == firstDataPtr)
				secondDataPtr.next = firstDataPtr;
			else if (prevFirstDataPtr == secondDataPtr)
				firstDataPtr.next = secondDataPtr;

			display(head);

		} else
			throw new NoSuchElementException("Either " + firstData + " or " + secondData + " not in the list!");
	}

	public Node<T> reverse(Node<T> link) {
		if (link == null)
			return null;

		if (link.next == null)
			return link;

		Node<T> secondElement = link.next;
		link.next = null;
		Node<T> reverseRest = reverse(secondElement);
		secondElement.next = link;
		return reverseRest;
	}

	public void setHeadandLastLink() {
		Node<T> temp = head;
		head = last;
		last = temp;
		display(head);
	}

	public T middle() {
		if (empty())
			throw new NoSuchElementException("List is empty!");

		Node<T> slowPtr = head;
		Node<T> fastPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr.data;
	}

	public int getOccurence(T data, int occurence, Node<T> link) {

		if (empty())
			throw new NoSuchElementException("List is Empty!");

		if (link == null)
			return occurence;

		if (link.data == data) {
			++occurence;
		}

		return getOccurence(data, occurence, link.next);
	}

	public boolean empty() {
		return head == null;
	}

}

public class LinkedListTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Welcome to Singly Linked List");
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		boolean yes = true;
		do {
			System.out.println("\n1. Insert at Begining");
			System.out.println("2. Insert at End");
			System.out.println("3. Insert at any position");
			System.out.println("4. Delete at Position");
			System.out.println("5. Get Size");
			System.out.println("6. Display");
			System.out.println("7. Empty Status ");
			System.out.println("8. Replace data at given position");
			System.out.println("9. Get Element by Position");
			System.out.println("10. Search Element Recursively");
			System.out.println("11. Swap only data not node");
			System.out.println("12. Swap node for given data");
			System.out.println("13. Reverse the list");
			System.out.println("14. Find Middle Element");
			System.out.println("15. Count Occurence of a Number");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				try {
					linkedList.insertAtFirst(scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					linkedList.insertAtLast(scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Enter position");
					int position = scanner.nextInt();
					if (position < 1 || position > linkedList.size()) {
						System.out.println("Invalid Position!");
						break;
					}
					linkedList.insertAtPosition(position, scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					int position = scanner.nextInt();
					if (position < 1 || position > linkedList.size()) {
						System.out.println("Invalid position !");
						break;
					}
					linkedList.delete(position);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println(linkedList.size());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				try {
					linkedList.display(linkedList.head);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 7:
				try {
					System.out.println(linkedList.empty());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 8:
				try {
					System.out.println("Enter position : ");
					int position = scanner.nextInt();
					if (position < 1 || position > linkedList.size()) {
						System.out.println("Invalid Position!");
						break;
					}
					linkedList.replace(position, scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 9:
				try {
					System.out.println("Enter Position : ");
					int position = scanner.nextInt();
					if (position < 1 || position > linkedList.size()) {
						System.out.println("Invalid Position !");
						break;
					}
					System.out.println(linkedList.elementByPosition(position, linkedList.head, 1));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 10:
				try {
					System.out.println("Enter the item to Find it's position : ");
					int data = scanner.nextInt();
					System.out.println(linkedList.searchElement(data, linkedList.head, 1));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 11:
				try {
					System.out.println("Enter the items to swap");
					int firstData = scanner.nextInt();
					int secondData = scanner.nextInt();
					linkedList.swapData(firstData, secondData);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 12:
				try {
					System.out.println("Enter the Data to swap Node");
					int firstData = scanner.nextInt();
					int secondData = scanner.nextInt();
					linkedList.swapNode(firstData, secondData);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 13:
				try {
					linkedList.reverse(linkedList.head);
					linkedList.setHeadandLastLink();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 14:
				try {
					System.out.println("Middle Element is : " + linkedList.middle());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 15:
				try {
					System.out.println("Enter the item to get Occurence");
					int data = scanner.nextInt();
					System.out.println("Occurence is : " + linkedList.getOccurence(data, 0, linkedList.head));
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
