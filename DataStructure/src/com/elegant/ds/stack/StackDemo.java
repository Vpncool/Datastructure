package com.elegant.ds.stack;

import java.util.Scanner;

public class StackDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of stack");
		int size = scanner.nextInt();
		StackDemoTest stack = new StackDemoTest(size);
		boolean yes = true;
		do {
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Check Full");
			System.out.println("4. Check Empty");
			System.out.println("5. Delete Middle");
			System.out.println("6. Peek");
			System.out.println("7. Display");
			System.out.println("8. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				stack.push(scanner.nextInt());
				break;

			case 2:
				stack.pop();
				break;

			case 3:
				System.out.println(stack.isFull());
				break;

			case 4:
				System.out.println(stack.isEmpty());
				break;

			case 5:
				stack.deleteMiddle();
				break;

			case 6:
				stack.peek();
				break;

			case 7:
				stack.display();
				break;
			case 8:
				yes = false;
				break;

			default:
				System.out.println("Invalid Choice!");
				break;
			}
		} while (yes);
	}
}

class StackDemoTest {

	int top = -1;
	int size = 0;
	int[] stackArray = null;

	public StackDemoTest() {

	}

	public StackDemoTest(int size) {
		stackArray = new int[size];
		top = -1;
		this.size = size;
	}

	public void push(int item) {
		if (isFull()) {
			System.out.println("Stack is Full");
			return;
		}
		stackArray[++top] = item;
		display();
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("poped item is " + stackArray[top]);
		--top;
		display();
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Items in stack is :-");
		for (int i = 0; i <= top; i++) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}

	public void deleteMiddle() {
		if (isEmpty()) {
			System.out.println("Stack is Empty ");
			return;
		}
		System.out.println("Deleted Element is : " + stackArray[top / 2]);
		for (int i = top / 2; i < top; i++) {
			stackArray[i] = stackArray[i + 1];
		}
		top--;
		display();
	}

	public void peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}
		System.out.println("Peek item is : " + stackArray[top]);
	}

	public boolean isEmpty() {
		return top <= -1;
	}

	public boolean isFull() {
		return top + 1 >= size;
	}
}
