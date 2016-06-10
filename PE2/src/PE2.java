public class PE2 {

	/**
	 * Problem is to find the sum of all even Fibonacci numbers less than
	 * 4000000. Strategy is to procedurally generate all Fibonacci numbers in
	 * sequence and and test to see if they're even; we do this by determining
	 * is the prior two Fibonacci numbers were either both even or both odd,
	 * generating an even number. If the number is even, add it.
	 * 
	 * @author Evan Hartman
	 */
	public static void main(String[] args) {
		/**
		 * @param [String[]
		 *            args] [Catches any initial arguments and ignores them.]
		 */
		long startTime = System.nanoTime();
		int first = 0; // the term n-2
		int second = 1; // the term n-1
		int current; // the nth term
		int sum = 0; // used to hold the sum of the array of even Fibonacci
						// numbers
		do {
			current = first + second;
			if (current % 2 == 0) {
				sum += current;
			}
			first = second; // increment n
			second = current;
		} while (first + second <= 4000000); // if the next term will be larger
												// than 4000000 we stop
		System.out.println(sum);
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
	}

}
