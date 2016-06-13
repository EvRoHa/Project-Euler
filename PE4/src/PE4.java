/*
* A palindromic number reads the same both ways. The largest palindrome made
* from the product of two 2-digit numbers is 9009 = 91 × 99. 
* Find the largest palindrome made from the product of two 3-digit numbers.
*
* Observation: Palindromic numbers will never end in zero, so we don't need to test any
* multiples of ten.
*/

public class PE4 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int TestValue;
		int LargestPalindrome = 0;

		for (int i = 101; i < 1000; i++) {
			for (int j = i; j < 1000; j++) {
				TestValue = i * j;
				if (TestValue > LargestPalindrome) {
					if (IsPalindrome(TestValue) == true) {
						LargestPalindrome = TestValue;
					}
				}
			}
		}
		System.out.println(LargestPalindrome);
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");

	}

	private static boolean IsPalindrome(int x) {
		/*
		 * Convert the value to a string, reverse it, then convert it back to
		 * int. Compare the original and reversed numbers.
		 */
		String reverse = new StringBuffer(Integer.toString(x)).reverse().toString();
		if (x == Integer.valueOf(reverse)) {
			return true;
		}
		return false;
	}
}
