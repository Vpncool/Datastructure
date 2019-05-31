package com.practice.datastructre.array.rotation;

import java.util.Scanner;

/**
 * @see <a href =
 *      "https://www.geeksforgeeks.org/find-a-rotation-with-maximum-hamming-distance/">MaximumHammingDistanceInArray</a>
 * @author Vipin Suman
 */
public class MaximumHammingDistanceInArray {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			while (testCases-- > 0) {
				int lenght = scanner.nextInt();
				int[] array = new int[lenght];
				for (int i = 0; i < lenght; i++)
					array[i] = scanner.nextInt();
				int maxHam = getMaxHammingDistance(array);
				System.out.println(maxHam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int getMaxHammingDistance(int[] array) {
		int length = array.length;
		int[] copyArray = new int[2 * length];
		for (int i = 0; i < length; i++) {
			copyArray[i] = array[i];
			copyArray[i + length] = array[i];
		}
		
		int maxHam = 0;
		for (int i = 1; i < length; i++) {
			int currHam = 0;
			for (int j =i, k = 0; j < (i + length); j++, k++) {
				if (copyArray[j] != array[k])
					currHam++;
				if (currHam == length)
					return length;
				maxHam = maxHam > currHam ? maxHam : currHam;
			}
		}
		return maxHam;
	}

}
