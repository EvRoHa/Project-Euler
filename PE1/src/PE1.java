/**
 * The problem is to find the sum of all multiples of 3 or 5 less than 1000. We
 * accomplish this by first adding all multiples of 3 and then adding all
 * multiples of 5 that are not ALSO multiples of 3.
 * 
 * @author Evan Hartman
 */

public class PE1 {
	/**
	 * @param [String[]
	 *            args] [Catches any initial arguments and ignores them.]
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int sum = 0;
		for (int i = 3; i < 1000; i += 3) {
			sum += i;
		}
		for (int i = 5; i < 1000; i += 5) {
			if (i % 3 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");
	}

}
