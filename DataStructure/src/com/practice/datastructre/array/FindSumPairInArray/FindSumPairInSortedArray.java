package com.practice.datastructre.array.FindSumPairInArray;

import java.util.Scanner;
/**
 * This is the programme to find the pair which is
 * is the sum of a given number of X 
 * If there is sum present in the sorted array than 
 * we will print that pair.
 * If there is no pair in given array than there wil no output will come
 * @see <a href = "https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/">FindSumPairInSortedArray</>
 * */
public class FindSumPairInSortedArray {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			while (testCases-- > 0) {
				int size = scanner.nextInt();
				int[] array = new int[size];
				for (int i = 0; i < size; i++)
					array[i] = scanner.nextInt();
				int searchKey = scanner.nextInt();
				hasArrayTwoCandidate(array, size, searchKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void hasArrayTwoCandidate(int[] array, int size, int searchKey) {
		int left = 0;
		int right = size - 1;
		while(left < right){
			if(array[left] + array[right] == searchKey){
				System.out.println("["+array[left]+" , "+array[right]+"]");
				left++;
				right--;
			}
			if(array[right] + array[left] < searchKey)
				left++;
			if(array[left]+array[right] > searchKey)
				right--;
		}
	}

}
