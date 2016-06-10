import java.util.Arrays;

public class PE3 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long N = 600851475143L; // our number to be factored
		long LargestPrimeFactor = 0; // to store our largest prime factor
		boolean[] list = primesInRange((int) Math.ceil(Math.sqrt(N)));
		// now test all identified primes as divisors of N.
		for (int i = 2; i < list.length; i++) {
			if (list[i] == true && N % i == 0) {
				LargestPrimeFactor = i;
			}
		}
		System.out.println(LargestPrimeFactor);
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
