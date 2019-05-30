package com.practice.datastructre.array.sort.MergeSort;

import java.util.Arrays;
import java.util.Scanner;
/**
 * <p>Both the array should be sorted
 * @author Vipin Suman
 * */
public class MergeTwoSortedArray {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			while (testCases-- > 0) {
				int length1 = scanner.nextInt();
				int[] firstArray = new int[length1];
				for (int i = 0; i < length1; i++)
					firstArray[i] = scanner.nextInt();
				int length2 = scanner.nextInt();
				int[] secondArray = new int[length2];
				for (int i = 0; i < length2; i++)
					secondArray[i] = scanner.nextInt();

				int[] mergedArray = new int[length1 + length2];
				mergeAndSortTwoArray(mergedArray, firstArray, secondArray);
				System.out.println(Arrays.toString(mergedArray));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mergeAndSortTwoArray(int[] mergedArray, int[] firstArray, int[] secondArray) {

		int left = firstArray.length;
		int right = secondArray.length;
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left && j < right) {
			if (firstArray[i] <= secondArray[j]) {
				mergedArray[k] = firstArray[i];
				i++;
			} else {
				mergedArray[k] = secondArray[j];
				j++;
			}
			k++;
		}

		while (i < left) {
			mergedArray[k] = firstArray[i];
			i++;
			k++;
		}
		
		while(j < right){
			mergedArray[k] = secondArray[j];
			j++;
			k++;
		}
	}

}
