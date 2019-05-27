package com.elegant.ds.array;

import java.util.HashMap;
import java.util.Map;

public class CountCharcters {

	public static void main(String[] args) {
		String str = "Hello World";
		int[] counts = new int[(int) Character.MAX_VALUE];
		System.out.println("Max Value : " + (int) Character.MAX_VALUE);
		long start = System.currentTimeMillis();
		for (int i = 0; i < str.length(); i++) {
			char charAt = str.charAt(i);
			counts[(int) charAt]++;
		}
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0)
				System.out.println("Number of " + (char) i + ": " + counts[i]);
		}
		System.out.println("Time Taken : " + (System.currentTimeMillis() - start));
		usingHashMap(str);
	}

	private static void usingHashMap(String str) {
		long start = System.currentTimeMillis();
		char[] charArray = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(char ch : charArray){
			if(!map.containsKey(ch))
				map.put(ch, 1);
			else
				map.put(ch, map.get(ch)+1);
		}
		System.out.println("Count "+map);
		System.out.println("Time Taken : " + (System.currentTimeMillis() - start));
	}

}
