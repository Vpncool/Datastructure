package com.practice.datastructre.array.rotation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Here I have used KMP Algorithm to find out the string matching or not
 * {@link com.practice.datastructre.string.pattern.PattentSearchingKMP#computeLPSArray(String)}
 * 
 * @see <a href=
 *      "https://www.geeksforgeeks.org/check-strings-rotations-not-set-2/">
 *      Check If Strings are rotation of Each Other Or Not</a>
 * @author Vipin Suman
 */
public class RotatedStringMatchingUsingKMP {

	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int testCase = Integer.parseInt(reader.readLine());
			while (testCase-- > 0) {
				String first = reader.readLine();
				String second = reader.readLine();
				boolean isRotation = checkRotation(first, second);
				System.out.println(isRotation ? 1 : 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean checkRotation(String first, String second) {
		int n = first.length();
		int m = second.length();
		int j = 0;
		int i = 1;
		int lps[] = new int[n];
		while (i < n) {
			if (first.charAt(i) == second.charAt(j)) {
				lps[i++] = ++j;
			} else {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}

		i = 0;
		// match from rotating point
		for (int k = lps[n - 1]; k < m; k++) {
			if (first.charAt(i++) != second.charAt(k))
				return false;
		}
		return true;
	}

}
