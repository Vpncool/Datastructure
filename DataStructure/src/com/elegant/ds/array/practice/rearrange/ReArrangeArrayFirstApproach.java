package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://www.geeksforgeeks.org/rearrange-array-arri/"> Rearrange
 *      Array a[i] = i</a>
 * @author Vipin Suman
 */
public class ReArrangeArrayFirstApproach {

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
		// [3,2,0,14]
		for (int i = 0; i < array.length; i++) {
			if(array[i] != -1 && array[i] != i){
				int x = array[i];
				while(array[x] != -1 && array[x] != x){
					int y = array[x];
					array[x] = x;
					x = y;
				}
				array[x] = x;
				if(array[i] != i)
					array[i] = i;
			}
		}
	}

}
