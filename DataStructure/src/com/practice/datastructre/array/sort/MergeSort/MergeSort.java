package com.practice.datastructre.array.sort.MergeSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href = 'https://www.geeksforgeeks.org/merge-sort/'>Merge Sort Of
 *      Array</a>
 */
public class MergeSort {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int lenght = scanner.nextInt();
				int[] array = new int[lenght];
				for (int i = 0; i < lenght; i++)
					array[i] = scanner.nextInt();
				divideArray(array, 0, lenght - 1);
				System.out.println(Arrays.toString(array));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void divideArray(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			divideArray(array, left, mid);
			divideArray(array, mid + 1, right);
			mergeArray(array, left, mid, right);
		}
	}

	public static void mergeArray(int[] array, int left, int mid, int right) {
		int length1 = mid - left + 1;
		int length2 = right - mid;
		
		int[] leftArray = new int[length1];
		int[] rightArray = new int[length2];
		
		for(int i = 0;i<length1;i++) // copy element in right array
			leftArray[i] = array[left+i];
		
		for(int j = 0;j<length2;j++) // copy elements in left array
			rightArray[j] = array[mid+1+j];
		
		int i = 0;
		int j = 0;
		int k = left;
		while(i < length1 && j < length2){
			if(leftArray[i] <= rightArray[j]){
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i < length1){
			array[k] = leftArray[i];
			i++;  
			k++;
		}
		
		while(j < length2){
			array[k] = rightArray[j];
			k++;
			j++;
		}
		
	}

}
