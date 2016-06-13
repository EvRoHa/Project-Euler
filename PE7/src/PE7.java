/*
 * What is the 10001st prime number?
 *
 * Use Sieve of Eratosthenes and count primes until we hit 10001. Challenge: we
 * don't know how far we must go until we hit the 10001st prime. Use recursion
 * to create an expanding list of primes. We'll expand our test list using Bertrand's
 * postulate, which states if pn is the nth prime, then pn+1<2pn.
 * 
 * The implementation of the sieve happens roughly n times (we're not memoizing results) so the
 * overall time complexity should be on the order of O(n*n(logn)(loglogn)).
 * 
 * Memory usage is not optimal; right now arrays remain in memory with recursive calls.
 * With a rewrite, it should grow roughly by n (dump old arrays before calling again).
 * 
 * Note that we could use the weak result of pn < 2^n, but 2^10001 would occupy roughly 250 terabytes,
 * so that option is out.
 */

import java.util.Arrays;

public class PE7 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int limit = 10001;

		System.out.println(nthPrime(limit, 2)); // initialize our prime search
												// at 2, the first prime
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
	}

	public static int nthPrime(int N, int nMinusOnePrime) {
		int result = nMinusOnePrime;
		int count = 0;
		// build a list of natural numbers twice the initial prime
		boolean[] list = sieveOfEratosthenes(2 * nMinusOnePrime);
		// count the prime numbers in the list, make sure to stop once we either
		// count enough or hit the end of the list
		for (int i = 0; i < list.length && count != N; i++) {
			if (list[i] == true) {
				count++;
				result = i;
			}
		}
		// if we hit the end of the list before we counted enough primes, expand
		// the list and count again
		if (count != N) {
			
			return nthPrime(N, result);
		}

		return result;
	}

	public static boolean[] sieveOfEratosthenes(int limit) {
		// In general, the time complexity a sieve is O(n(logn)(loglogn)).
		boolean[] list = new boolean[limit];

		Arrays.fill(list, true);

		list[0] = false;
		list[1] = false;

		for (long i = 2; i < (long) limit; i++) {
			if (list[(int) i] == true) {
				for (long j = i * i; j < (long) limit; j += i) {
					list[(int) j] = false;
				}
			}
		}
		return list;
	}
}
