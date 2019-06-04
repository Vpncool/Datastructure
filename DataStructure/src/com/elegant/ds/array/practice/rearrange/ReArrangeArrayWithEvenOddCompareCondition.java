package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @see <a href="https://www.geeksforgeeks.org/rearrange-array-arri-arrj-even-arri/">Re Arrange The Array With Even Odd position  Comparison</a>
 * @author Vipin Suman
 * */
public class ReArrangeArrayWithEvenOddCompareCondition {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();

				int[] copy = new int[length];
				for (int i = 0; i < length; i++)
					copy[i] = array[i];
				sort(copy, 0, length - 1);
				rearrange(array, copy);
				System.out.println(Arrays.toString(array));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void rearrange(int[] array, int[] copy) {

		int oddPostion = array.length - array.length / 2;
		int j = oddPostion - 1;
		for (int i = 0; i < array.length; i += 2) {
			array[i] = copy[j];
			j--;
		}
		j = oddPostion;
		for (int i = 1; i < array.length; i += 2) {
			array[i] = copy[j];
			j--;
		}
	}

	private static void sort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(array, low, mid);
			sort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	private static void merge(int[] array, int low, int mid, int high) {
		int length1 = mid - low + 1;
		int length2 = high - mid;

		int[] leftArray = new int[length1];
		int[] rightArray = new int[length2];

		for (int i = 0; i < length1; i++)
			leftArray[i] = array[low + i];

		for (int i = 0; i < length2; i++)
			rightArray[i] = array[mid + 1 + i];

		int i = 0;
		int j = 0;
		int k = low;

		while (i < length1 && j < length2) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < length1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (i < length2) {
			array[k] = rightArray[i];
			j++;
			k++;
		}

	}

}
