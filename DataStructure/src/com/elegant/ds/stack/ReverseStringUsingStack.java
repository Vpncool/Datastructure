package com.elegant.ds.stack;

import java.util.Scanner;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		System.out.println("Enter the word : ");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		StringBuffer stringBuffer = new StringBuffer(word);
		reverse(stringBuffer);
		System.out.println("Reverse String is : " + stringBuffer);
	}

	private static void reverse(StringBuffer stringBuffer) {
		int length = stringBuffer.length();
		ReverseStack reverseStack = new ReverseStack(length);

		int i = 0;
		for (i = 0; i < length; i++)
			reverseStack.push(stringBuffer.charAt(i));

		for (i = 0; i < length; i++) {
			char ch = reverseStack.pop();
			stringBuffer.setCharAt(i, ch);
		}

	}

}

class ReverseStack {

	int size = 0;
	char[] stackArray = null;
	int top = -1;

	public ReverseStack() {

	}

	public ReverseStack(int size) {
		stackArray = new char[size];
	}

	public void push(char item) {
		if (top >= size) {
			System.out.println("Stack is overflow");
			return;
		}
		stackArray[++top] = item;
		size++;
	}

	public char pop() {
		if (top < 0) {
			System.out.println("Stack is underflow");
			return 0;
		}
		char x = stackArray[top--];
		return x;
	}

	public boolean isEmpty() {
		return top < 0;
	}
}
