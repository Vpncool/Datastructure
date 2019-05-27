package com.elegant.testing.junit;

public class ExceptionTest {

	private String message = "Hello World";

	public void printMessage() {
		System.out.println(message);
		int a = 1 / 0;
	}

	public String message() {
		return "Hi! " + message;
	}
}
