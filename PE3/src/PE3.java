import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Arrays;

public class PE3 {

	public static void main(String[] args) {
		long N = 600851475143L; // to store our number to be factored
		long LargestPrimeFactor = 0; // to store our largest prime factor
		boolean[] list = primesInRange((int) Math.ceil(Math.sqrt(N)));
		// now test all identified primes as divisors of N.
		for (int i = 2; i < list.length; i++) {
			if (list[i] == TRUE && N % i == 0) {
				LargestPrimeFactor = i;
			}
		}
		System.out.println(LargestPrimeFactor);

	}

	public static boolean[] primesInRange(int limit) {
		boolean[] list = new boolean[limit];

		// initialize all values in the array to TRUE.
		Arrays.fill(list, TRUE);
		
		// iterate through the list and remove all composite values.
		for (long i = 2; i < limit; i++) {
			// if the current value is marked as prime
			if (list[(int) i] == TRUE) {
				/*
				 * start at i^2 and iteratively remove all values of the form
				 * i^2+ki to eliminate all multiples of i from our array.
				 */
				for (long j = i * i; j < (long) limit; j += i) {
					list[(int) j] = FALSE;
				}
			}
		}
		return list;
	}
}
