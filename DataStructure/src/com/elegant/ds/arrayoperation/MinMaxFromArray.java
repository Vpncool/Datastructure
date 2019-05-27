package com.elegant.ds.arrayoperation;

import java.util.Scanner;

public class MinMaxFromArray {

	public static void main(String[] args) {
		System.out.println("Enter the size of array : ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int sizeOfArray = scanner.nextInt();
		int[] array = new int[sizeOfArray];
		System.out.println("Enter the items in the array : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		findMaxMin(array);
	}

	private static void findMaxMin(int[] array) {
		int max = array[0];
		int min = array[0];
		for (int element : array) {
			max = max > element ? max : element;
			min = min < element ? min : element;
		}
		System.out.println("Maximum : " + max + " Minimum : " + min);
	}
}
