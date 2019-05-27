package com.elegant.ds.array.practice;

public class InserElementInUnsortedArray {

	public static void main(String[] args) {

		int[] array = new int[20];
		array[0] = 12;
		array[1] = 16;
		array[2] = 20;
		array[3] = 40;
		array[4] = 50;
		array[5] = 70;

		int totalFiledItems = 6;
		int insertElement = 27;

		System.out.println("Befor Insertion : ");
		for (int i = 0; i < totalFiledItems; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		totalFiledItems = insertElement(array, totalFiledItems, insertElement);
		
		System.out.println("");

	}

	private static int insertElement(int[] array, int filedElement, int insertElemnt) {

		if (filedElement >= array.length) {
			return filedElement;
		}
		array[filedElement] = insertElemnt;
		return filedElement + 1;
	}

}
