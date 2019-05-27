package com.elegant.hackerrank.basic;

import java.util.Scanner;

public class StdInStdOut {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int integer1 = scanner.nextInt();
		double double1 = scanner.nextDouble();
		scanner.nextLine();
		String string1 = scanner.nextLine();
		System.out.println("String :" + string1);
		System.out.println("Double :" + double1);
		System.out.println("Integer :" + integer1);
	}

}
