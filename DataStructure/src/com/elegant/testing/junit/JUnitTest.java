package com.elegant.testing.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTest {

	@Test
	public void testAdd() {
		String str = "hello how are you";
		assertEquals("hello how are you", str);
	}
	
	/*@Test
	public void testEqual(){
		String str = "Hello Vipin Suman";
		assertEquals("Hello vipin", str);
	}*/
}
