package com.elegant.testing.junit;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class JunitTestSuite {

	public static void main(String[] args) {
		TestSuite testSuite = new TestSuite(TestJunit2.class,TestAssert.class,TestMessageUtil.class);
		TestResult result = new TestResult();
		testSuite.run(result);
		System.out.println("No of test cases : "+result.runCount());
	}

}
