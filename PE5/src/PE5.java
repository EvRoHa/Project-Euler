
/*
 * What is the smallest positive number that is evenly divisible by all
 * of the numbers from 1 to 20?
 *
 * Find all of the primes between 2 and 20, then find the minimal prime
 * factorization that includes all factorizations from 1 to 20.
 */
import java.util.Arrays;

public class PE5 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int limit = 20;
		boolean[] list = primesInRange(limit);
		int[] exponent = new int[limit];
		int result = 1;

		for (int i = 0; i < list.length; i++) {
			if (list[i] == true) {
				for (int j = 2; j < limit; j++) {
					// go through the values 2-20 and find the largest power of
					// each prime necessary
					while (j % Math.pow(i, exponent[i] + 1) == 0) {
						exponent[i]++;
					}
				}
			}
			result *= Math.pow(i, exponent[i]);
		}
		System.out.println(result);
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
	}

	public static boolean[] primesInRange(int limit) {
		boolean[] list = new boolean[limit];

		Arrays.fill(list, true);

		for (long i = 2; i < limit; i++) {
			if (list[(int) i] == true) {
				for (long j = i * i; j < (long) limit; j += i) {
					list[(int) j] = false;
				}
			}
		}
		return list;
	}
}
