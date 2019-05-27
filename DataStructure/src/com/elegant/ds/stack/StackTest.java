package com.elegant.ds.stack;

import java.util.Scanner;

public class StackTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Size of Stack ");
		int size = scanner.nextInt();
		Stack stack = new Stack(size);
		boolean yes = true;
		do {
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Disply");
			System.out.println("4. Check Full");
			System.out.println("5. Check Empty");
			System.out.println("6. Delete Middle");
			System.out.println("7. Peek");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				stack.push(scanner.nextInt());
				break;

			case 2:
				stack.pop();
				break;

			case 3:
				stack.display();
				break;

			case 4:
				System.out.println(stack.isFull());
				break;

			case 5:
				System.out.println(stack.isEmpty());
				break;

			case 6:
				stack.deleteMiddle();
				break;

			case 7:
				stack.peek();
				break;

			default:
				break;
			}
		} while (yes);
	}
}

class Stack {

	int top = 0;
	int size = 0;
	int[] stackArray = null;

	public Stack() {
		top = 0;
		size = 0;
	}

	public Stack(int size) {
		top = -1;
		this.size = size;
		stackArray = new int[size];
	}

	public void push(int data) {
		if (top + 1 >= size) {
			System.out.println("Stack is Full");
			display();
			return;
		}
		stackArray[++top] = data;
		display();
	}

	public void pop() {
		if (top <= -1) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Poped element is " + stackArray[top]);
		top--;
		display();
	}

	public void display() {
		if (top <= -1) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.print("Items in Stack is : ");
		for (int i = 0; i <= top; i++) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}

	public boolean isFull() {
		if (top + 1 >= size) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (top <= -1) {
			return true;
		}
		return false;
	}

	public void deleteMiddle() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Deleted element is : " + stackArray[top / 2]);
		int temp = top / 2;
		for (int i = temp + 1; i <= top; i++) {
			int data = stackArray[i];
			stackArray[i - 1] = data;
		}
		top--;
		display();
	}
	
	public void peek() {
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println(stackArray[top]);
	}
}