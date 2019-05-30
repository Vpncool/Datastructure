package com.practice.datastructre.array.rotation;

import java.util.Scanner;

import com.practice.datastructre.array.rotation.Reversal.ArrayRotation;
/**
 * @see < a href='https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/>Count Array Rotation To Sort Array</a>'
 * @author Vipin Suman
 * */

public class CountArrayRotationToSortArray {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)){
			int testCase = scanner.nextInt();
			while(testCase --> 0){
				int lenght = scanner.nextInt();
				int[] array = new int[lenght];
				for(int i = 0; i< lenght;i++)
					array[i] = scanner.nextInt();
				int numberORotation = scanner.nextInt();
				ArrayRotation.rotate(array, numberORotation);
				int rotation = countNumberOfRotation(array,0,lenght-1);
				System.out.println(rotation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int countNumberOfRotation(int[] array, int low, int high) {
		
		if(high < low)
			return 0;
		if(high == low)
			return low;
		int mid = (low+high)/2;
		if(mid > low && array[mid] < array[mid - 1])
			return mid;
		if(mid < high && array[mid] > array[mid+1])
			return mid+1;
		if(array[high] > array[mid])
			return countNumberOfRotation(array, low, mid-1);
		return countNumberOfRotation(array, mid+1, high);
	}

}
