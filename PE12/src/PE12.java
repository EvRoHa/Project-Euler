
/*
 * What is the value of the first triangle number to have over five hundred divisors?
 * 
 * Note that the nth triangular number is the sum of the first n integers; hence
 * we can generate these by n(n+1)/2. We don't need to actually factor the number,
 * only count the factors. Note further that any factor of the nth triangular
 * number will either be a factor of n/2 or (n+1)/2. We'll find the primes factors
 * of n/2 and n+1 (or n and (n+1)/2). Note that for any n if a, b, c are primes
 * and n = a^i + b^j + c^k then the number of unique factors is (i+1)*(j+1)*(k+1).  
 */

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class PE12 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int limit = 500;
		int n = 1;
		ArrayList<Boolean> primes = sieveOfEratosthenes(100);
		int nPlusOneFactors = 2;
		int nFactors = 1;

		while (nFactors * nPlusOneFactors < limit) {
			if (n + 1 >= primes.size()) {
				primes = sieveOfEratosthenes(primes);
			}

			if (n % 2 == 0) {
				nFactors = numberOfUniqueFactors(n / 2, primes);
				nPlusOneFactors = numberOfUniqueFactors(n + 1, primes);
			} else {
				nFactors = numberOfUniqueFactors(n, primes);
				nPlusOneFactors = numberOfUniqueFactors((n + 1) / 2, primes);
			}

			System.out.println(n + "th Triangular number is " + n * (n + 1) / 2 + " has " + nFactors * nPlusOneFactors
					+ " factors.");
			n++;
		}

		long endTime = System.nanoTime();

		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
	}

	public static int numberOfUniqueFactors(int toBeFactored, ArrayList<Boolean> primes) {
		int numberOfFactors = 1;
		int currentExponent;
		int intermediateValue = toBeFactored;

		// Trim down the list of primes
		List<Boolean> trimmedPrimeList = primes.subList(0, toBeFactored + 1);

		// Be greedy; pick the biggest prime less than the target number
		int greedyPrime = trimmedPrimeList.lastIndexOf(true);

		for (int i = greedyPrime; i >= 1; i--) {
			if (trimmedPrimeList.get(i) == true) {
				currentExponent = 0;
				while (intermediateValue % i == 0) {
					intermediateValue = intermediateValue / i;
					currentExponent++;
				}
				numberOfFactors *= currentExponent + 1;
			}
		}
		return numberOfFactors;
	}

	public static ArrayList<Boolean> sieveOfEratosthenes(int limit) {
		// Creates a list of primes
		ArrayList<Boolean> primeList = new ArrayList<Boolean>(Collections.nCopies(limit + 1, true));

		primeList.set(0, false);
		primeList.set(1, false);

		for (long i = 2; i < (long) limit + 1; i++) {
			if (primeList.get((int) i) == true) {
				for (long j = i * i; j < (long) primeList.size(); j += i) {
					primeList.set((int) j, false);
				}
			}
		}
		return primeList;
	}

	public static ArrayList<Boolean> sieveOfEratosthenes(int limit, ArrayList<Boolean> Seed) {
		// Extends a list of primes

		while ((long) Seed.size() < limit + 1) {
			Seed.add(true);
		}
		
		for (long i = 2; i < (long) Seed.size(); i++) {
			if (Seed.get((int) i) == true) {
				for (long j = i * i; j < (long) Seed.size(); j += i) {
					Seed.set((int) j, false);
				}
			}
		}
		return Seed;
	}

	public static ArrayList<Boolean> sieveOfEratosthenes(ArrayList<Boolean> Seed) {
		// Extends a list of primes

		int limit = 2 * Seed.size();

		while ((long) Seed.size() < limit) {
			Seed.add(true);
		}
		
		for (long i = 2; i < (long) Seed.size(); i++) {
			if (Seed.get((int) i) == true) {
				for (long j = i * i; j < (long) Seed.size(); j += i) {
					Seed.set((int) j, false);
				}
			}
		}
		return Seed;
	}
}