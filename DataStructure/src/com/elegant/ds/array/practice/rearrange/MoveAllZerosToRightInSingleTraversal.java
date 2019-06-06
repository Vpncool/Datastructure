package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * Input : arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
 * <p>
 * Output : arr[] = {1, 2, 4, 3, 5, 0, 0};
 * <p>
 * Input : arr[] = {1, 2, 0, 0, 0, 3, 6};
 * <p>
 * Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
 * 
 * @see <a href="https://www.geeksforgeeks.org/move-zeroes-end-array-set-2-using-single-traversal/">Push All
 *      zeros to Right in Single Traversal</a>
 * @author Vipin Suman
 */

public class MoveAllZerosToRightInSingleTraversal {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				rearrange(array, length);
				System.out.println(Arrays.toString(array));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void rearrange(int[] array, int length) {
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] != 0) {
				swap(array, count++, i);
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
