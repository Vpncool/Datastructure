package com.elegant.ds.search.practice;

import java.util.Scanner;

public class DeleteElementInSortedArray {

	public static void main(String[] args) {
		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements of array in soring order :");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.print("Array befor : ");
		for (int element : array) {
			System.out.print(element + " ");
		}

		System.out.println("Enter the element do you want to delete : ");
		int element = scanner.nextInt();

		int n = deleteElement(array, element, array.length);

	}

	private static int deleteElement(int[] array, int element, int length) {

		int position = binarySearch(array, 0, length, element);

		if(position == -1){
			System.out.println("Element not found");
			return length;
		}
		
		// Deleting element 
		
		for(int i = position;i<length;i++){
			
		}
		return length -1;
	}

	private static int binarySearch(int[] array, int low, int high, int element) {

		if (high < low) {
			return -1;
		}

		int mid = (high + low) / 2;

		if (element == array[mid]) {
			return mid;
		}

		if (element < array[mid]) {
			high = mid;
		}

		if (element > array[mid]) {
			low = mid;
		}
		return binarySearch(array, low, high, element);
	}

}
