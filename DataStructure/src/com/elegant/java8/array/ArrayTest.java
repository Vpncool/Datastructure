package com.elegant.java8.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayTest {

	public static void main(String[] args) {
		// Parameters require objects, not primitives

		// Auto-boxing happening for int 127 here

		Integer[] initial = { 127, Integer.valueOf(42) };
		List<Integer> toList = Arrays.asList(initial);
		System.out.println(toList);

		// Note: Works with all collections

		Integer[] fromCollection = toList.toArray(new Integer[toList.size()]);
		System.out.println(fromCollection);

		// Streams - JDK 8+

		Stream<Integer> toStream = Arrays.stream(initial);
		System.out.println(toStream);
		Integer[] fromStream = toStream.toArray(Integer[]::new);
		System.out.println(fromStream);

	}

}
