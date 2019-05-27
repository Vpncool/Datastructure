package com.elegant.testing.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestException {

	ExceptionTest test = new ExceptionTest();

	@Test(expected = ArithmeticException.class)
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage");
		test.printMessage();
	}

	@Test
	public void testMessage() {
		System.out.println("inside test message");
		assertEquals("Hi! Hello World", test.message());
	}
}
