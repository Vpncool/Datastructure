package com.elegant.ds.array.practice;

import java.util.Scanner;

public class InsertElementInsortedArray {

	public static void main(String[] args) {

		int[] array = new int[20];
		array[0] = 1;
		array[1] = 11;
		array[2] = 15;
		array[3] = 32;
		array[4] = 67;
		array[5] = 84;
		array[6] = 89;

		int noOfElement = 7;
		System.out.println("Before Insertion : ");
		for (int i = 0; i < noOfElement; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\nEnter the element to be insert : ");
		@SuppressWarnings("resource")
		int element = (new Scanner(System.in)).nextInt();
		noOfElement = insertElement(array, array.length, noOfElement, element);

		System.out.println("\nAfter insertion : ");
		for (int i = 0; i < noOfElement; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static int insertElement(int[] array, int capacity, int noOfElement, int element) {
		if (noOfElement >= capacity) {
			return capacity;
		}
		int i = 0;
		for (i = noOfElement - 1; (i >= 0 && array[i] > element); i--) {
			array[i + 1] = array[i];
		}
		array[i + 1] = element;
		return noOfElement + 1;
	}

}
