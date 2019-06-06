package com.elegant.ds.array.practice.rearrange;

import java.util.Arrays;
import java.util.Scanner;

public class RearrangeSmallestLargestOrder {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCase = scanner.nextInt();
			while (testCase-- > 0) {
				int length = scanner.nextInt();
				int[] array = new int[length];
				for (int i = 0; i < length; i++)
					array[i] = scanner.nextInt();
				int[] aux = rearrange(array, length);
				System.out.println(Arrays.toString(aux));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int[] rearrange(int[] array, int length) {
		sort(array, 0, length - 1);
		int[] aux = new int[length];

		int i = 0;
		int j = length - 1;

		int k = 0;
		while (i < j) {
			aux[k++] = array[i];
			i++;
			aux[k++] = array[j];
			j--;
		}
		if (length % 2 != 0)
			aux[k] = array[length / 2];
		return aux;
	}

	private static void sort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(array, low, mid);
			sort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int len1 = mid + 1 - left;
		int len2 = right - mid;

		int[] leftArr = new int[len1];
		int[] rightArr = new int[len2];

		for (int i = 0; i < len1; i++) {
			leftArr[i] = array[left + i];
		}

		for (int i = 0; i < len2; i++) {
			rightArr[i] = array[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < len1 && j < len2) {
			if (leftArr[i] <= rightArr[j]) {
				array[k] = leftArr[j];
				i++;
			} else {
				array[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < len1) {
			array[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < len2) {
			array[k] = rightArr[j];
			j++;
			k++;
		}
	}

}
