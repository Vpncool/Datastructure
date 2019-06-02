package com.practice.datastructre.array.rotation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @see <a href="https://stackoverflow.com/questions/13411600/taking-inputs-with-bufferedreader-in-java">Check Strings are rotation of each other</a>
 * @author Vipin Suman
 * */

public class CheckStringRotationOfEachOther {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			int testCase = Integer.parseInt(reader.readLine());
			while(testCase --> 0){
				String first = reader.readLine();
				String second = reader.readLine();
				String compareString = first+first;
				System.out.println(compareString.contains(second) ? 1 : 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
