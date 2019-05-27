package com.elegant.ds.array.practice;

import java.util.Scanner;

public class HasArrayTwoCandidateUsingHashMap {

	private static final int MAX = 100000;

	public static void main(String[] args) {
		System.out.println("Enter the size of array : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the element in array : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Enter the element to find the pair of it's sum : ");
		int element = scanner.nextInt();
		findPairs(array, element);
	}

	private static void findPairs(int[] array, int element) {

		boolean[] binMap = new boolean[MAX];

		for (int i = 0; i < array.length; i++) {
			int temp = element - array[i];

			if (temp >= 0 && binMap[temp]) {
				System.out.println("Pairs are : " + temp + "," + array[i]);
			}
			binMap[array[i]] = true;
		}
	}

}
