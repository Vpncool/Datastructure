package com.elegant.testing.junit;

public class MessageUtil {

	private String message = "";

	public MessageUtil() {

	}

	public MessageUtil(String message) {
		this.message = message;
	}

	public String printMessage() {
		System.out.println("Message is " + message);
		return message;
	}
}
