package com.practice.datastructre.array.rotation;

import java.util.Scanner;
/**
 * @see <a href="https://www.geeksforgeeks.org/quickly-find-multiple-left-rotations-of-an-array/">PrintMultipleLeftRotationOfArray</a>
 * @author Vipin Suman
 * */
public class PrintMultipleLeftRotationOfArray {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)){
			int testCases = scanner.nextInt();
			while (testCases --> 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for(int i = 0;i<length;i++)
					array[i]  = scanner.nextInt();
				int rotation = scanner.nextInt();
				rotation %= length;
				for(int i = rotation;i<rotation+length;i++)
					System.out.print(array[i % length]+" ");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
