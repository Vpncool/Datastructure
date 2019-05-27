package com.elegant.ds.array.practice;

import java.util.Scanner;

public class FindMissingNumberUsingXOR {
	public static void main(String[] l) {
		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements of array :");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.print("Array is : ");
		for (int element : array) {
			System.out.print(element + " ");
		}

		getMissingNumber(array);
	}

	private static void getMissingNumber(int[] array) {
		System.out.println();
		int x1 = array[0];
		int x2 = 1;
		for (int i = 1; i < array.length; i++) {
			x1 = x1 ^ array[i];
			System.out.println("X1 is : "+x1);
		}
		for (int i = 2; i <= (array.length + 1); i++) {
			x2 = x2 ^ i;
			System.out.println("x2 is : "+x2);
		}
		System.out.println("Missing number is : " + (x1 ^ x2));
	}
}
