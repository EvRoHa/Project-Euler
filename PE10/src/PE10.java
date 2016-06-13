/*
 * Find the sum of all the primes below two million.
 * 
 * Use the sieve of Eratosthenes to generate a list of primes, then sum them.
 */

public class PE10 {

    public static void main(String[] args) {
    	long startTime = System.nanoTime();
    	int limit = 2000000;
        long result = 0;
        boolean[] list = sieveOfEratosthenes(limit);

        for (int i = 0; i < list.length; i++) {
            if (list[i] == true) {
                result+=i;
            }
        }
        System.out.println(result);
        long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
    }

    public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] list = new boolean[limit+1];

        // initialize all values in the array to true.
        for (int i = 2; i < list.length; i++) {
            list[i] = true;
        }

        // just set the values for 0 and 1 to false so we begin with 2.
        list[0] = false;
        list[1] = false;

        /* iterate through the list of all prime values less than square root N
         * and remove all composite values.
         */
        for (long i = 2; i < (long) list.length; i++) {
            //  if the current value is marked as prime
            if (list[(int) i] == true) {
                /* start at i^2 and iteratively remove all values of the form
                 * i^2+ki to eliminate all multiples of i from our array. Stop
                 * at square root N, because no values bigger than this can be
                 * a prime factor of N.
                 */
                for (long j = i * i; j < (long) list.length; j += i) {
                    list[(int) j] = false;
                }
            }
        }
        return list;
    }
}
