package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @see <a href="https://www.geeksforgeeks.org/rearrange-array-arri/">Re Arrange The array Using Swaping The Elements</a>
 * @author Vipin Suman
 * */
public class ReArrangeArrayUsingHashing {

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
		HashSet<Integer> set = new HashSet<>();
		for (int i : array)
			set.add(i);
		for (int i = 0; i < array.length; i++) {
			if (set.contains(i))
				array[i] = i;
			else
				array[i] = -1;
		}
	}

}
