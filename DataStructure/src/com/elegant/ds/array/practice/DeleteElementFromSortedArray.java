package com.elegant.ds.array.practice;

import java.util.Scanner;

public class DeleteElementFromSortedArray {

	public static void main(String[] args) {
		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the element in sorted order : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		System.out.println("Before deletion : ");
		for (int item : array) {
			System.out.print(item + " ");
		}

		System.out.println("\nEnter the element want to delete : ");
		int element = scanner.nextInt();
		size = deleteElement(array, element);
		if(size == -1){
			System.out.println("Element not found ");
			return;
		}
		System.out.println("After deletion : ");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static int deleteElement(int[] array, int element) {

		int position = findPosition(array, element, 0, array.length);
		if (position == -1) {
			return -1;
		}

		for (int i = position; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		return array.length - 1;
	}

	private static int findPosition(int[] array, int element, int low, int high) {
		if (low > high) {
			return -1;
		}

		int middle = (high + low) / 2;

		if (array[middle] == element) {
			return middle;
		}

		if (array[middle] > element) {
			high = middle;
		}

		if (array[middle] < element) {
			low = middle;
		}
		return findPosition(array, element, low, high);
	}

}
