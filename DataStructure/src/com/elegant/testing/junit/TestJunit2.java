package com.elegant.testing.junit;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestJunit2 extends TestCase {

	protected double fvalue1;
	protected double fvalue2;

	@Before
	public void setUp() {
		fvalue1 = 2.0;
		fvalue2 = 3.0;
	}

	@Test
	public void testAdd() {
		// count the number of test cases
		System.out.println("No of test cases : " + this.countTestCases());

		// test getName
		System.out.println("Test Name : " + this.getName());

		// test setName
		this.setName("testNewAdd");
		System.out.println("Set Name : " + this.getName());
	}

	public void tearDown() {

	}
}
