package com.elegant.ds.search.practice;

import java.util.Scanner;

public class InsertElementInSortedArray {

	public static void main(String[] l) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[20];
		arr[0] = 12;
		arr[1] = 16;
		arr[2] = 20;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 70;
		int totalElement = 6;
		int capacity = arr.length;

		System.out.println("before insertion");
		for (int i = 0; i < totalElement; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("enter the element want to insert : ");
		int element = scanner.nextInt();

		totalElement = insertSorted(arr, totalElement, element, capacity);

		System.out.println("After insertion : ");
		for (int i = 0; i < totalElement; i++) {
			System.out.println(arr[i]);
		}
	}

	private static int insertSorted(int[] arr, int totalElement, int element, int capacity) {

		if (totalElement >= capacity) {
			return totalElement;
		}

		int i = 0;

		for (i = totalElement - 1; (arr[i] > element && i >= 0); i--) {
			arr[i + 1] = arr[i];
		}
		arr[i + 1] = element;
		return totalElement + 1;
	}

}
