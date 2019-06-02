package com.practice.datastructre.string.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @see <a href =
 *      "https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/">Knuss
 *      Morris Pratt Pattern Searching</a>
 * @author Vipin Suman
 *         <p>
 *         Input: AAACAAAA, ABABCAAB
 *         <p>
 *         Output: [0, 1, 2, 0, 1, 2, 3, 3]; [0, 0, 1, 2, 0, 1, 1, 2]
 */

public class PattentSearchingKMP {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int testCase = Integer.parseInt(reader.readLine());
			while (testCase-- > 0) {
				String text = reader.readLine();
				String pattern = reader.readLine();
				int[] lps = computeLPSArray(pattern);
				System.out.println(Arrays.toString(lps));
				patternSearchingUsingKMP(text, pattern, lps);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void patternSearchingUsingKMP(String text, String pattern, int[] lps) {
		int length1 = text.length();
		int length2 = pattern.length();
		int i = 0;
		int j = 0;
		while (i < length1) {
			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if (j == length2) {
				System.out.println("Pattern Index Found At: " + (i - j));
				j = lps[j - 1];
			} else if (i < length1 && pattern.charAt(j) != text.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}

	public static int[] computeLPSArray(String pattern) {
		int length = pattern.length();
		int j = 0;
		int i = 1;
		int[] lps = new int[length];
		lps[0] = 0; // lps[0] always 0
		while (i < length) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[i++] = ++j;
			} else {
				if (j != 0)
					j = lps[j - 1];
				else {
					lps[i] = j;
					i++;
				}
			}
		}
		return lps;
	}

}
