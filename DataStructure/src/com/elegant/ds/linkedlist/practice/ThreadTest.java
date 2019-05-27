package com.elegant.ds.linkedlist.practice;

public class ThreadTest {

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			
			System.out.println("hi");
		}
		System.out.println("Total Time taken : " + (System.currentTimeMillis() - start));
	}
}
