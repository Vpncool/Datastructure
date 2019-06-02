package com.practice.datastructre.array.rotation;

import java.util.Scanner;

public class GenerateAllRotationsOfNumber {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int number = scanner.nextInt();
				printAllRotations(number);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printAllRotations(int number) {
		int digits = digits(number);
		int powTen = powerOfTen(digits);
		for (int i = 0; i < digits - 1; i++) {
			int firstDigit = number / powTen;
			int leftRotation = (number * 10) + firstDigit - firstDigit * powTen * 10;
			System.out.println(leftRotation);
			number = leftRotation;
		}
	}

	private static int powerOfTen(int digits) {
		int powTen = 1;
		while (digits > 1) {
			--digits;
			powTen *= 10;
		}
		return powTen;
	}

	private static int digits(int number) {
		int count = 0;
		while (number > 0) {
			++count;
			number /= 10;
		}
		return count;
	}

}
