package com.elegant.ds.stack;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Infix to Postfix conversion of an expression
 *  Example like an expression is given as :- (a+b*(c+d)+e)
 *  then the Postfix conversion of that expression is :-  abcd+*+e+
 *  In this class I have created a Stack using linkedList 
 */

public class InfixToPostfixTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the expression : ");
		String expression = scanner.nextLine();
		String afterConversion = infixtoPostfixConversion(expression);
		System.out.println("Conversion of " + expression + " to Postfix is : " + afterConversion);
	}

	private static String infixtoPostfixConversion(String expression) {

		String resultExpression = new String();
		InfixPostfixLinkedStack stack = new InfixPostfixLinkedStack();
		for (int i = 0; i < expression.length(); i++) {
			char op = expression.charAt(i);

			// If the scanned operator is an operand, add it to output.
			if (Character.isLetterOrDigit(op))
				resultExpression += op;

			// if the scanned character is an '(', push into the stack.
			else if (op == '(')
				stack.push(op);

			// if the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered
			else if (op == ')') {

				while (!stack.isEmpty() && stack.peek() != '(')
					resultExpression += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			} else {
				// an operator is encountered
				while (!stack.isEmpty() && precedenceOfOperator(op) <= precedenceOfOperator(stack.peek()))
					resultExpression += stack.pop();
				stack.push(op);
			}
		}

		while (!stack.isEmpty())
			resultExpression += stack.pop();
		return resultExpression;
	}

	public static int precedenceOfOperator(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;

		case '/':
		case '*':
			return 2;

		case '^':
			return 3;

		default:
			return -1;
		}
	}
}

class InfixPostfixLinkedStack {

	LinkedListNode top = null;

	public InfixPostfixLinkedStack() {
		top = null;
	}

	public void push(char data) {
		LinkedListNode nptr = new LinkedListNode(data, null);
		if (isEmpty())
			top = nptr;
		else {
			nptr.setLink(top);
			top = nptr;
		}
	}

	public char pop() {
		if (isEmpty())
			throw new NoSuchElementException("No operand in the stack");
		LinkedListNode ptr = top;
		top = ptr.getLink();
		return ptr.getData();
	}

	public char peek() {
		if (isEmpty())
			throw new NoSuchElementException("No operand in the stack");
		return top.getData();
	}

	public boolean isEmpty() {
		return top == null;
	}

}

class LinkedListNode {

	private LinkedListNode link = null;
	private char data = 0;

	public LinkedListNode() {

	}

	public LinkedListNode(char data, LinkedListNode link) {
		this.data = data;
		this.link = link;
	}

	public LinkedListNode getLink() {
		return link;
	}

	public void setLink(LinkedListNode link) {
		this.link = link;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}
}