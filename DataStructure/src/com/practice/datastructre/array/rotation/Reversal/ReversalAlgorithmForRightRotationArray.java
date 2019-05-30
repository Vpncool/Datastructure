package com.practice.datastructre.array.rotation.Reversal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://www.geeksforgeeks.org/reversal-algorithm-right-rotation-array/">ReversalAlgorithmForRightRotationArray</a>
 * @author Vipin Suman
 * */
public class ReversalAlgorithmForRightRotationArray {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			while (testCases-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				int rotation = scanner.nextInt();
				rotation %= length;
				rightReversal(array,rotation);
				System.out.println(Arrays.toString(array));
			}
		}
	}

	private static void rightReversal(int[] array, int rotation) {
		reverseArray(array, 0 , array.length-1);
		reverseArray(array, 0, rotation-1);
		reverseArray(array, rotation, array.length-1);
	}

	private static void reverseArray(int[] array, int start, int end) {
		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}