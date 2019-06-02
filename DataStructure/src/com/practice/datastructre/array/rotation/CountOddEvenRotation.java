package com.practice.datastructre.array.rotation;

import java.util.Scanner;

public class CountOddEvenRotation {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				int evenRotation = countEvenOddRotation(array,length);
				System.out.println("Even Rotation: "+evenRotation);
				System.out.println("Odd Rotation: "+(length - evenRotation));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int countEvenOddRotation(int[] array, int length) {
		int evenRotation = 0;
		for (int i = 0; i < array.length; i++) 
			evenRotation += array[i]% 2== 0 ? 1 : 0;
		return evenRotation;
	}
}
