package com.elegant.ds.array.sort;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the element : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Before sorting : ");
		for (int item : array) {
			System.out.print(item + " ");
		}
		sort(array);
		System.out.println("\nAfter sorting : ");
		for (int item : array) {
			System.out.print(item + " ");
		}
	}

	private static void sort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		doQuickSort(array, 0, array.length - 1);
	}

	private static void doQuickSort(int[] array, int low, int high) {
		int i = low;
		int j = high;

		int pivot = array[low + (high - low) / 2];
		System.out.println(pivot);

		while (i <= j) {

			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}

			if (low < j) {
				doQuickSort(array, low, j);
			}

			if (high > i) {
				doQuickSort(array, i, high);
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
