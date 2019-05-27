package com.elegant.ds.stack;

import java.util.Scanner;

public class TwoStacksInArrayTest {
	@SuppressWarnings("resource")
	public static void main(String[] l) {
		System.out.println("Enter the size of array ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		TwoStackImplementation stack = new TwoStackImplementation(size);
		boolean yes = true;
		do {
			System.out.println("1. Push the item in First Stack");
			System.out.println("2. Push the item in Second stack");
			System.out.println("3. Pop the item from First Stack");
			System.out.println("4. Pop the item from Second stack");
			System.out.println("5. Display the items of First stack");
			System.out.println("6. Disaply the item of Second stack");
			System.out.println("7. Peek item of First Stack");
			System.out.println("8. Peek Item of Second Stack");
			System.out.println("9. Delete the middle item of First Stack");
			System.out.println("10. Delete the middle item of Second Stack");
			System.out.println("11. Resize the stack size");
			System.out.println("12. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter the item to push");
					stack.pushIntoFirstStack(scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					System.out.println("Enter the item to push");
					stack.pushIntoSecondStack(scanner.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					stack.popFromFirstStack();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					stack.popFromSecondStack();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {
					stack.displayFirstStack();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				try {
					stack.displaySecondStack();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 7:
				try {
					stack.peekOne();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 8:
				try {
					stack.peekTwo();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 9:
				try {
					stack.deleteMiddleItemOfFirstStack();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 10:
				try {
					stack.deleteMiddleItemOfSecondStack();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 11:
				System.out.println("Enter the size of Stack");
				stack = new TwoStackImplementation(scanner.nextInt());
				break;
				
			case 12:
				yes = false;
				break;

			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (yes);
	}
}

class TwoStackImplementation {

	int[] stackArray = null;
	int topOne = 0;
	int topTwo = 0;

	public TwoStackImplementation() {

	}

	public TwoStackImplementation(int size) {
		stackArray = new int[size];
		topOne = -1;
		topTwo = size;
	}

	public void pushIntoFirstStack(int item) {
		if (isFull()) {
			throw new IllegalArgumentException("Stack is Overflow!");
		}
		stackArray[++topOne] = item;
	}

	public void pushIntoSecondStack(int item) {
		if (isFull()) {
			throw new IllegalArgumentException("Stack is Overflow!");
		}
		stackArray[--topTwo] = item;
	}

	public void popFromFirstStack() {
		if (topOne == -1) {
			throw new IllegalArgumentException("First stack is Underflow!");
		}
		System.out.println("Poped Element is : " + stackArray[topOne]);
		topOne--;
	}

	public void popFromSecondStack() {
		if (topTwo == stackArray.length) {
			throw new IllegalArgumentException("Second stack is Underflow!");
		}
		System.out.println("Top Two is : " + topTwo);
		System.out.println("Poped Element is : " + stackArray[topTwo]);
		topTwo++;
	}

	public void displayFirstStack() {
		if (topOne == -1) {
			throw new IllegalArgumentException("First stack is Underflow!");
		}
		System.out.println("Items of First Stack are : ");
		for (int i = 0; i <= topOne; i++) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}

	public void displaySecondStack() {
		if (topTwo == stackArray.length) {
			throw new IllegalArgumentException("Second stack is Underflow!");
		}
		System.out.println("Items of Second stack are : ");
		for (int i = stackArray.length - 1; i >= topTwo; i--) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}

	public void peekOne() {
		if (topOne == -1) {
			throw new IllegalArgumentException("First stack is Underflow!");
		}
		System.out.println("Peek item is " + stackArray[topOne]);
	}

	public void peekTwo() {
		if (topTwo == stackArray.length) {
			throw new IllegalArgumentException("Second stack is Underflow!");
		}
		System.out.println("Peek item is " + stackArray[topTwo]);
	}

	public void deleteMiddleItemOfFirstStack() {
		if (topOne == -1) {
			throw new IllegalArgumentException("First stack is Underflow!");
		}
		int middleIndex = topOne / 2;
		for (int i = middleIndex; i < topOne; i++) {
			stackArray[i] = stackArray[i + 1];
		}
		topOne--;
		displayFirstStack();
	}

	public void deleteMiddleItemOfSecondStack() {
		if (topTwo == stackArray.length) {
			throw new IllegalArgumentException("Second stack is underflow!");
		}
		int middleIndex = (stackArray.length - 1 + topTwo) / 2;
		for (int i = middleIndex; i > topTwo; i--) {
			stackArray[i] = stackArray[i - 1];
		}
		topTwo++;
		displaySecondStack();
	}

	public boolean isFull() {
		return topOne == stackArray.length - 1 || topTwo == 0 || topOne + 1 == topTwo;
	}

	public boolean isEmpty() {
		return topOne == -1 && topTwo == stackArray.length;
	}

}
