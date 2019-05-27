package com.practice.datastructre.array;

public class ArrayRotation {

	public static void rotate(int[] array, int rotation) throws Exception {
		if (array == null)
			throw new NullPointerException("can't rotate");
		if (rotation <= 0)
			throw new Exception("Can't rotate");
		int lenght = array.length;
		rotation %= lenght;

		// Reversal Algorithm
		reverse(array, 0, rotation - 1);
		reverse(array, rotation, lenght - 1);
		reverse(array, 0, lenght - 1);
	}

	public static void reverse(int[] array, int low, int high) {
		while (low < high) {
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			low++;
			high--;
		}
	}
}
