package com.elegant.ds.array.practice;

import java.util.Scanner;

public class DeleteElementInUnsortedArray {

	public static void main(String[] args) {
		System.out.println("enter the size of the array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("enter the elements");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Before deletion : ");
		for (int item : array) {
			System.out.print(item + " ");
		}

		System.out.println("\nEnter item to be delete from array : ");
		int itemToDelete = scanner.nextInt();

		size = deleteItem(array, itemToDelete);
		System.out.println("After deletion");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static int deleteItem(int[] array, int itemToDelete) {

		boolean found = false;
		int position = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == itemToDelete) {
				position = i;
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Item Not Found");
			return array.length;
		}
		for (int i = position; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		return array.length - 1;
	}
}
