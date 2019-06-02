package com.practice.datastructre.array.rotation;

import java.util.Scanner;

/**
 * An Array arr={7, 7, 8, 8, 9, 1, 1, 4, 2, 2} has numbers appearing twice or
 * once. Duplicates appear side by side everytime. Might be few numbers can be
 * occur one time and just assume this is a right rotating array (just say an
 * array can rotate k times towards right). Aim is to identify numbers that
 * occured once in array.
 * 
 * <p>
 * Input: {7, 7, 8, 8, 9, 1, 1, 4, 2, 2}
 * <p>
 * Outut: 9 4
 * 
 * @see <a href =
 *      "https://www.geeksforgeeks.org/amazon-interview-experience/">Find Number
 *      That Repeat Once In Right Rotating Array</a>
 * @author Vipin Suman
 */

public class FindNumberRepeatOnce {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				singleOccurance(array, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void singleOccurance(int[] array, int length) {
		// // int a[]={7, 8, 8, 9, 1, 1, 4, 2, 2, 7} for this case
		int i = 0;
		if (array[i] == array[length - 1]) {
			i = 1;
			length -= 1;
		}
		int b = 0;
		for (; i < length; i++) {
			b = i + 1;
			if(b == length)
				break;
			if(array[i] == array[b])
				i++;
			else
				System.out.println(array[i]);
		}
		if(i < length)
			System.out.println(array[i]);
	}

}
