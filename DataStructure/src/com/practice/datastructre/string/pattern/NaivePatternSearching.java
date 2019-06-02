package com.practice.datastructre.string.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @see <a href =
 *      "https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/">Naive
 *      Pattern Searching</a>
 * @author Vipin Suman
 */

public class NaivePatternSearching {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int testCase = Integer.parseInt(reader.readLine());
			while (testCase-- > 0) {
				String text = reader.readLine();
				String pattern = reader.readLine();
				patternIndex(text, pattern);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void patternIndex(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		for (int i = 0; i < textLength - patternLength; i++) {
			int j = 0;
			for (; j < patternLength; j++) {
				if (text.charAt(i + j) != pattern.charAt(j))
					break;
			}
			if (j == patternLength)
				System.out.println(i);
		}
	}

}
