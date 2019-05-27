package com.elegant.ds.array.practice;

import java.util.Scanner;

public class HasArrayTwoCandidate {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("insert element in array : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		sortArray(array);
		System.out.println("Enter the element to find the pair of it's sum");
		int element = scanner.nextInt();
		findCandidate(array, element);
	}

	private static void sortArray(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		doQuickSort(array, 0, array.length - 1);
	}

	private static void doQuickSort(int[] array, int low, int high) {
		int i = low;
		int j = high;

		int pivot = array[low + (high - low) / 2];

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
		}
		if (low < j) {
			doQuickSort(array, low, j);
		}

		if (i < high) {
			doQuickSort(array, i, high);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void findCandidate(int[] array, int element) {
		int left = 0;
		int right = array.length - 1;
		boolean found = false;
		while (left < right) {

			if (array[left] + array[right] == element) {
				System.out.println("Pair is : " + array[left] + "," + array[right]);
				found = true;
			}

			if (array[left] + array[right] < element) {
				left++;
			} else {
				right--;
			}
		}
		if (!found) {
			System.out.println("No such pair exist");
		}
	}

}
