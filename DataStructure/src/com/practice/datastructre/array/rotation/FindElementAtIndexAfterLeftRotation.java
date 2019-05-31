package com.practice.datastructre.array.rotation;

import java.util.Scanner;

/**
 * @see <a href="https://www.geeksforgeeks.org/find-element-given-index-number-rotations/">FindElementAtIndexAfterLeftRotation</a>
 * @author Vipin Suman
 * */

public class FindElementAtIndexAfterLeftRotation {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			int testCase = scanner.nextInt();
			while(testCase --> 0){
				int length = scanner.nextInt();
				int[] array = new int[length];
				for(int i = 0;i<length;i++)
					array[i] = scanner.nextInt();
				int rotation = scanner.nextInt();
				int index = scanner.nextInt();
				int element = findElement(array,length,rotation,index);
				System.out.println(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int findElement(int[] array, int length, int rotation, int index) {
		return array[(index+rotation)%length];
	}

}
