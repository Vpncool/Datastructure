package com.practice.datastructre.array;

import java.util.Scanner;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt(); // No of test cases
			while (testCase-- > 0) { 
				int size = scanner.nextInt(); // Size of array
				int[] array = new int[size];  // Create array with size 
				for (int i = 0; i < size; i++) {
					array[i] = scanner.nextInt(); // initialize array
				}
				int rotation = scanner.nextInt(); // no of rotation
				ArrayRotation.rotate(array, rotation); // Rotate array by reversal algo
				int key = scanner.nextInt(); // Key to find
				int index = search(array, 0, size - 1, key); // perform search and get index
				System.out.println(index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int search(int[] array, int low, int high, int key) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (array[mid] == key)
			return mid;
		if (array[low] <= array[mid]) {
			if (array[low] <= key && array[mid] >= key)
				return search(array, low, mid - 1, key);
			return search(array, mid + 1, high, key);
		}
		if (array[mid] <= key && array[high] >= key)
			return search(array, mid + 1, high, key);
		return search(array, low, mid - 1, key);
	}

}
