package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Number of positive and negative numbers need not be equal. If there are more
 * positive numbers they appear at the end of the array. If there are more
 * negative numbers, they too appear in the end of the array.
 * <p>
 * Input: arr[] = {1, 2, 3, -4, -1, 4}
 * <p>
 * Output: arr[] = {-4, 1, -1, 2, 3, 4}
 * <p>
 * Input: arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * <p>
 * output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/">Re
 *      Arrange The Array with Alternate Negative and Positive Number</a>
 * @author Vipin Suman
 */
public class AlternateNegativePositiveNumber {

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

		// shift all negative numbers in to left side
		int i = -1;
		for (int j = 0; j < length; j++) {
			if (array[j] < 0) {
				++i;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		// Here we got 'i' index means upto i there is only negative number
		// Now all positive numbers are at end and negative numbers at
		// the beginning of array. Initialize indexes for starting point
		// of positive and negative numbers to be swapped

		int positiveIndex = i + 1;
		int negativeIndex = 0;

		while (positiveIndex < length && negativeIndex < positiveIndex && array[negativeIndex] < 0) {
			int temp = array[negativeIndex];
			array[negativeIndex] = array[positiveIndex];
			array[positiveIndex] = temp;
			positiveIndex++;
			negativeIndex += 2;
		}
	}

}
