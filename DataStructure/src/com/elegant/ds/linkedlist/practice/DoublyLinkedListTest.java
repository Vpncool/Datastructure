package com.elegant.ds.linkedlist.practice;

import java.util.NoSuchElementException;
import java.util.Scanner;

class DoubleLinkedListNode<T> {

	private T data = null;
	private DoubleLinkedListNode<T> next = null;
	private DoubleLinkedListNode<T> prev = null;

	public DoubleLinkedListNode() {
	}

	public DoubleLinkedListNode(T data, DoubleLinkedListNode<T> next, DoubleLinkedListNode<T> prev) {
		this.next = next;
		this.prev = prev;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoubleLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleLinkedListNode<T> next) {
		this.next = next;
	}

	public DoubleLinkedListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkedListNode<T> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "DoubleLinkedListNode [data=" + data + "]";
	}
}

class DoubleLinkedList<T> {

	DoubleLinkedListNode<T> start = null;
	DoubleLinkedListNode<T> end = null;

	public DoubleLinkedList() {
		start = null;
		end = null;
	}

	public void insertAtStart(T data) {
		DoubleLinkedListNode<T> nptr = new DoubleLinkedListNode<T>(data, null, null);
		if (empty()) {
			start = nptr;
			end = start;
		} else {
			start.setPrev(nptr);
			nptr.setNext(start);
			start = nptr;
		}
		display();
	}

	public void insertAtEnd(T data) {
		DoubleLinkedListNode<T> nptr = new DoubleLinkedListNode<T>(data, null, null);
		if (empty()) {
			start = nptr;
			end = start;
		} else {
			nptr.setPrev(end);
			end.setNext(nptr);
			end = nptr;
		}
		display();
	}

	public void insertAtPosition(int position, T data) {
		if (empty())
			throw new NoSuchElementException("List is Empty!");
		if (position == 1) {
			insertAtStart(data);
			return;
		}
		if (position == size()) {
			insertAtEnd(data);
			return;
		}
		DoubleLinkedListNode<T> nptr = new DoubleLinkedListNode<T>(data, null, null);
		DoubleLinkedListNode<T> startPtr = start;
		position -= 1;
		for (int i = 1; i < size(); i++) {
			if (position == i) {
				DoubleLinkedListNode<T> temp = startPtr.getNext();
				startPtr.setNext(nptr);
				nptr.setPrev(startPtr);
				nptr.setNext(temp);
				temp.setPrev(nptr);
				break;
			}
			startPtr = startPtr.getNext();
		}
		display();
	}

	public void delete(int position) {
		if (empty())
			throw new NoSuchElementException("List is Empty!");
		if (position == 1) {
			DoubleLinkedListNode<T> nptr = start.getNext();
			nptr.setPrev(null);
			start = nptr;
			display();
			return;
		}

		if (position == size()) {
			DoubleLinkedListNode<T> startPtr = start;
			DoubleLinkedListNode<T> endPtr = start;
			while (startPtr.getNext() != null) {
				endPtr = startPtr;
				startPtr = startPtr.getNext();
			}
			endPtr.setNext(null);
			end = endPtr;
			display();
			return;
		}

		DoubleLinkedListNode<T> startPtr = start;
		position -= 1;
		for (int i = 1; i < size(); i++) {
			if (i == position) {
				DoubleLinkedListNode<T> tempPtr = startPtr.getNext();
				tempPtr = tempPtr.getNext();
				startPtr.setNext(tempPtr);
				tempPtr.setPrev(startPtr);
				break;
			}
			startPtr = startPtr.getNext();
		}
		display();
	}

	public int recursiveSearchElement(DoubleLinkedListNode<T> startPtr, T data, int position) {
		if (startPtr.getData().equals(data))
			return position;
		if (startPtr.getNext() == null)
			throw new NoSuchElementException(data + " Not in the list");
		return recursiveSearchElement(startPtr.getNext(), data, ++position);
	}

	public void swapNode(T firstData, T secondData) {
		if (empty())
			throw new NoSuchElementException("List is Empty");

		if (firstData.equals(secondData))
			throw new NoSuchElementException("Can't swap for same data");

		boolean foundFirstData = false;
		boolean foundSecondData = false;

		DoubleLinkedListNode<T> firstDataPtr = start;
		DoubleLinkedListNode<T> tempFirstDataPtr = start;

		while (firstDataPtr.getNext() != null && !firstDataPtr.getData().equals(firstData)) {
			tempFirstDataPtr = firstDataPtr;
			firstDataPtr = firstDataPtr.getNext();
		}

		if (firstDataPtr.getData().equals(firstData))
			foundFirstData = true;

		DoubleLinkedListNode<T> secondDataPtr = start;
		DoubleLinkedListNode<T> tempSecondDataPtr = start;

		while (secondDataPtr.getNext() != null && !secondDataPtr.getData().equals(secondData)) {
			tempSecondDataPtr = secondDataPtr;
			secondDataPtr = secondDataPtr.getNext();
		}

		if (secondDataPtr.getData().equals(secondData))
			foundSecondData = true;

		if (foundFirstData && foundSecondData) {
			if (start.getData().equals(firstDataPtr.getData()))
				start = secondDataPtr;
			else if (start.getData().equals(secondDataPtr.getData()))
				start = firstDataPtr;

			if (end.getData().equals(firstDataPtr.getData()))
				end = secondDataPtr;
			else if (end.getData().equals(secondDataPtr.getData()))
				end = firstDataPtr;

			DoubleLinkedListNode<T> tempFirstDataPtrNext = firstDataPtr.getNext();
			DoubleLinkedListNode<T> tempSecondDataPtrNext = secondDataPtr.getNext();
			tempFirstDataPtr.setNext(secondDataPtr);
			tempSecondDataPtr.setNext(firstDataPtr);
			firstDataPtr.setNext(tempSecondDataPtrNext);
			secondDataPtr.setNext(tempFirstDataPtrNext);
			firstDataPtr.setPrev(tempSecondDataPtr);
			secondDataPtr.setPrev(tempFirstDataPtr);
			if (tempFirstDataPtrNext != null)
				tempFirstDataPtrNext.setPrev(secondDataPtr);

			if (tempSecondDataPtrNext != null)
				tempSecondDataPtrNext.setPrev(firstDataPtr);

			if (firstDataPtr == tempSecondDataPtr) {
				secondDataPtr.setNext(firstDataPtr);
				firstDataPtr.setPrev(secondDataPtr);
			} else if (secondDataPtr == tempFirstDataPtr) {
				firstDataPtr.setNext(secondDataPtr);
				secondDataPtr.setPrev(firstDataPtr);
			}

			display();

		} else
			throw new NoSuchElementException("Either " + firstData + " or " + secondData + " not in the list!");
	}

	public T middle() {
		if (empty())
			throw new NoSuchElementException("List is Empty!");
		DoubleLinkedListNode<T> startPtr = start;
		for (int i = 0; i < size(); i++) {
			if (i == size() / 2)
				return startPtr.getData();
			startPtr = startPtr.getNext();
		}
		return null;
	}

	public void display() {
		if (empty())
			throw new NoSuchElementException("List is Empty!");

		if (start.getNext() == null) {
			System.out.println(start.getData());
			return;
		}

		DoubleLinkedListNode<T> startPtr = start;
		System.out.print(startPtr.getData() + "->");
		startPtr = startPtr.getNext();
		while (startPtr.getNext() != null) {
			System.out.print(startPtr.getData() + "->");
			startPtr = startPtr.getNext();
		}
		System.out.println(startPtr.getData());
	}

	public boolean empty() {
		return start == null;
	}

	public int size() {
		if (empty())
			throw new NoSuchElementException("List is Empty!");
		DoubleLinkedListNode<T> startPtr = start;
		int size = 1;
		while (startPtr.getNext() != null) {
			size++;
			startPtr = startPtr.getNext();
		}
		return size;
	}

}

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		System.out.println("Welcome to Doubly Linked List");
		Scanner scanner = new Scanner(System.in);
		boolean yes = true;
		DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<Integer>();
		try {
			do {
				System.out.println("1. Insert at Start");
				System.out.println("2. Insert at End");
				System.out.println("3. Insert at position");
				System.out.println("4. Delete");
				System.out.println("5. Empty Status");
				System.out.println("6. Display");
				System.out.println("7. Get Size");
				System.out.println("8. Search Element recursively");
				System.out.println("9. Swap Node");
				System.out.println("10. get Middle");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					try {
						linkedList.insertAtStart(scanner.nextInt());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 2:
					try {
						linkedList.insertAtEnd(scanner.nextInt());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:
					try {
						System.out.println("Enter Position");
						int position = scanner.nextInt();
						if (position < 1 || position > linkedList.size()) {
							System.out.println("Invalid Poistion!");
							break;
						}
						linkedList.insertAtPosition(position, scanner.nextInt());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 4:
					try {
						System.out.println("Enter Position");
						int position = scanner.nextInt();
						if (position < 1 || position > linkedList.size()) {
							System.out.println("Invalid Position");
							break;
						}
						linkedList.delete(position);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 5:
					try {
						System.out.println(linkedList.empty());
					} catch (Exception e) {
						e.getMessage();
					}
					break;

				case 6:
					try {
						linkedList.display();
					} catch (Exception e) {

					}
					break;

				case 7:
					try {
						System.out.println(linkedList.size());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 8:
					try {
						System.out.println("Enter Data");
						int data = scanner.nextInt();
						System.out.println(
								"Position is : " + linkedList.recursiveSearchElement(linkedList.start, data, 1));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 9:
					try {
						linkedList.swapNode(scanner.nextInt(), scanner.nextInt());
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
					break;

				case 10:
					try {
						System.out.println(linkedList.middle());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid Choice!");
					break;
				}
			} while (yes);
		} catch (Exception e) {

		} finally {
			scanner.close();
		}
	}
}
