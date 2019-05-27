package com.elegant.hackerrank.basic;

import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number ");
		int n = scanner.nextInt();
		String ans = "";
		if ((n % 2 == 1 || (n % 2 == 0 && (n >= 6 && n <= 20))) && (n <= 100)) {
			ans = "Weired";
		} else {
			if (n > 100) {
				ans = "out of the range n should be in the range of 1<=n<=100";
			} else {
				ans = "Not Weired";
			}
		}
		System.out.println(ans);
	}

}
