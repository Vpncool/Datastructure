package com.practice.datastructre.array.rotation;

import java.util.Scanner;

/**
 * @see <a href="https://www.geeksforgeeks.org/queries-left-right-circular-shift-array/">QueryToArray</a>
 * @author Vipin Suman
 * */

public class QueryToArray {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			while (testCases-- > 0) {
				int totalRotation = 0; // includes only left rotation
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				boolean exit = false;
				do {
					System.out.println("Your Choice");
					System.out.println("1. Right Rotation");
					System.out.println("2. Left Rotation");
					System.out.println("3. Sum");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						int rightRotation = scanner.nextInt();
						rightRotation %= length;
						totalRotation = length - rightRotation;
						break;
						
					case 2:
						int leftRotation = scanner.nextInt();
						leftRotation %= length;
						totalRotation += leftRotation;
						break;
						
					case 3:
						int startIndex = scanner.nextInt();
						int endIndex = scanner.nextInt();
						int sum = sum(array, totalRotation,startIndex, endIndex);
						System.out.println(sum);
						break;
					}
				} while (!exit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int sum(int[] array, int totalRotation, int startIndex, int endIndex) {
		int length = array.length;
		totalRotation %= length;
		int sum = 0;
		for(int i = startIndex;i<=endIndex;i++){
			sum += array[(i+totalRotation) % length];
		}
		return sum;
	}

}
