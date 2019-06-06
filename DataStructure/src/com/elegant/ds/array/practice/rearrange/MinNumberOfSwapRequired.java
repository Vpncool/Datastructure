package com.elegant.ds.array.practice.rearrange;

import java.util.Scanner;

/**
 * <p>
 * Input: arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
 * <p>
 * Output: 2
 * <p>
 * Input: arr[] = {2, 1, 5, 6, 3}, k = 3
 * <p>
 * Output: 1
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/">Min
 *      Number of Swap required to Bring Element less than or equal together</a>
 * @author Vipin Suman
 */

public class MinNumberOfSwapRequired {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				int number = scanner.nextInt();
				int count = countNumberOfSwap(array, length, number);
				System.out.println(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int countNumberOfSwap(int[] array, int length, int number) {
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] <= number)
				++count;
		}

		// Find unwanted elements in current
		// window of size 'count'
		int bad = 0;
		for (int i = 0; i < count; i++) {
			if (array[i] > number)
				++bad;
		}

		// Initialize answer with 'bad' value of
		// current window

		int ans = bad;
		for (int i = 0, j = count; j < length; i++, j++) {

			if (array[i] > number)
				--bad;

			if (array[j] > number)
				++bad;

			ans = ans > bad ? bad : ans;
		}
		return ans;
	}

}
