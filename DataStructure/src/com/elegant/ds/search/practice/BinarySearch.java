package com.elegant.ds.search.practice;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] l) {
		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements of array in soring order :");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.print("Array is : ");
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
		System.out.println("Enter the element want to search : ");
		int element = scanner.nextInt();
		binarySearchElement(array, element, 0, array.length);
	}

	private static void binarySearchElement(int[] array, int element, int low, int high) {
		if (high < low) {
			System.out.println(-1);
			return;
		}
		int mid = (high + low) / 2;

		if (element == array[mid]) {
			System.out.println(element + " found at index number " + mid);
			return;
		}

		if (element < array[mid]) {
			high = mid;
		}

		if (element > array[mid]) {
			low = mid;
		}
		binarySearchElement(array, element, low, high);
	}

}
