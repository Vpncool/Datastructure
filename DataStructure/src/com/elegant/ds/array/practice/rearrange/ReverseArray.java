package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/">Reverse the Array</a>
 * @author Vipin Suman
 * */

public class ReverseArray {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				reverse(array);
				System.out.println(Arrays.toString(array));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void reverse(int[] array) {
		int start = 0;
		int end = array.length-1;
		while (start <end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

}
