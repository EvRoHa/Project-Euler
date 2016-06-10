/*
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * We know the sum of the first n natural numbers is n(n+1)/2; we'll save time
 * by using this. We'll use recursion for the sum of squares.
 */

public class PE6 {

    public static void main(String[] args) {
    	long startTime = System.nanoTime();
    	int limit = 100;
        int sumOfSquares = sumConsecutiveSquares(limit);
        int squareOfSum = (int) Math.pow(limit * (limit + 1) / 2, 2);
        
        System.out.println(squareOfSum-sumOfSquares);
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
    }

    public static int sumConsecutiveSquares(int limit) {
        int result = 0;

        if (limit == 1) {
            return 1;
        } else {
        	result += sumConsecutiveSquares(limit - 1);
            return result + limit * limit;
        }
    }

}
