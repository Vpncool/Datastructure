package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://www.geeksforgeeks.org/rearrange-array-arri/">Re Arrange
 *      The array Using Swaping The Elements</a>
 * @author Vipin Suman
 */

public class ReArrangeArrayBySwapping {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				rearrange(array);
				System.out.println(Arrays.toString(array));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void rearrange(int[] array) {
		boolean[] flag = new boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			while (true) {
				if (array[i] >= 0 && array[i] != i) {
					// swap i and arr[i] assume index
					int temp = array[i];
					array[i] = array[temp];
					array[temp] = temp;
					flag[i] = true;
				}
				if (array[i] == -1 || array[i] == i)
					break;
			}
		}
	}

}
