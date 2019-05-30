package com.practice.datastructre.array.rotation;

import java.util.Scanner;

import com.practice.datastructre.array.rotation.Reversal.ArrayRotation;

/**
 * @see <a href=
 *      "https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/">MinimumElementInSortedRotatedArray</a>
 * @author Vipin Suman
 */
public class MinimumElementInSortedRotatedArray {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			while (testCases-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				int rotation = scanner.nextInt();
				ArrayRotation.rotate(array, rotation);
				int findMin = binarySearch(array, 0, length - 1);
				System.out.println(findMin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int binarySearch(int[] array, int low, int high) {
		if(high < low)
			return array[0];
		if(high == low)
			return array[low];
		int mid = (low+high)/2;
		if(mid > low && array[mid] < array[mid -1])
			return array[mid];
		if(mid < high && array[mid] > array[mid+1])
			return array[mid+1];
		if(array[mid] > array[high])
			return binarySearch(array, mid+1, high);
		return binarySearch(array, low, mid-1);
	}

}
