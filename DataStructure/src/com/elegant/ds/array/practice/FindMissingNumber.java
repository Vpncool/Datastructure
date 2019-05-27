package com.elegant.ds.array.practice;

import java.util.Scanner;

/**
 * Find the Missing Number You are given a list of n-1 integers and these
 * integers are in the range of 1 to n. There are no duplicates in list. One of
 * the integers is missing in the list. Write an efficient code to find the
 * missing integer.
 */
public class FindMissingNumber {

	public static void main(String[] args) {
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
		findMissingNo(array);
	}

	private static void findMissingNo(int[] array) {
		System.out.println();
		int sum = (array.length + 1) * (array.length + 2) / 2;
		for (int i = 0; i < array.length; i++) {
			sum -= array[i];
		}
		System.out.println("Missing Number is : " + sum);
	}
}
