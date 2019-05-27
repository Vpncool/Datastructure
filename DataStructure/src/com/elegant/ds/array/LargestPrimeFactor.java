package com.elegant.ds.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		System.out.printf("Largest prime factor of number '%d' is %d %n", 6, prime(6));
		System.out.printf("highest prime factor of number '%d' is %d %n", 15, prime(15));
		System.out.printf("Biggest prime factor of number '%d' is %d %n", 392832, prime(392832));
		System.out.printf("Largest prime factor of number '%d' is %d %n", 1787866, prime(1787866));
	}

	public static int prime(long number) {
		int i;
		long copyNumber = number;
		for (i = 2; i <= copyNumber; i++) {
			if (copyNumber % i == 0) {
				copyNumber /= i;
				i--;
			}
		}
		return i;
	}

	@Test
	public void testLargestPrimeFactors() {
		assertEquals(2, LargestPrimeFactor.prime(2));
		assertEquals(3, LargestPrimeFactor.prime(6));
		assertEquals(5, LargestPrimeFactor.prime(15));
		assertEquals(7, LargestPrimeFactor.prime(147));
		assertEquals(17, LargestPrimeFactor.prime(17));
		assertEquals(31, LargestPrimeFactor.prime(392832));
		assertEquals(893933, LargestPrimeFactor.prime(1787866));
	}
}