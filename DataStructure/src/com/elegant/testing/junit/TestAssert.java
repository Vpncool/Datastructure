package com.elegant.testing.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAssert {

	@Test
	public void testAdd() {
		int number = 6;
		String temp = null;
		String test = "Hello World";

		// check equality
		assertEquals("Hello World", test);

		// check for false condition
		assertFalse(number > 6);

		// check for not null value
		assertNotNull(temp);
	}
}
