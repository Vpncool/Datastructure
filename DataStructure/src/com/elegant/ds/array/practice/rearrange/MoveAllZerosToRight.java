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
 * @see <a href="https://www.geeksforgeeks.org/move-zeroes-end-array/">Push All
 *      zeros to Right</a>
 * @author Vipin Suman
 */
public class MoveAllZerosToRight {

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
				array[count++] = array[i];
			}
		}

		// Now all non-zero elements have been shifted to
		// front and 'count' is set as index of first 0.
		// Make all elements 0 from count to end.
		while (count < length) {
			array[count++] = 0;
		}
	}
}
