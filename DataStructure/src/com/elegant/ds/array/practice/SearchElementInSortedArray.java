package com.elegant.ds.array.practice;

import java.util.Scanner;

public class SearchElementInSortedArray {

	public static void main(String[] args) {

		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements in sorted order");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		System.out.println("Array is : ");
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.println("\nEnter the item to search ");
		int search = scanner.nextInt();

		binarySearch(array, 0, array.length, search);

	}

	private static void binarySearch(int[] array, int low, int high, int search) {

		if (low > high) {
			return;
		}

		int middle = (high + low) / 2;

		if (array[middle] == search) {
			System.out.println(search + " found at " + middle + " index");
			return;
		}

		if (array[middle] < search) {
			low = middle;
		}

		if (array[middle] > search) {
			high = middle;
		}

		binarySearch(array, low, high, search);
	}

}
