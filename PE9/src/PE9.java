/*
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * We know we can generate pythagorean triples as follows:
 * 
 * for any two natural numbers x>y
 * if a=x^2-y^2 and b=2xy
 * then c=x^2+y^2
 * 
 * Since a+b+c=1000, we have x^2-y^2+2xy+x^2+y^2=1000
 * implying 2x^2+2xy=1000 therefore x^2+xy-500=0.
 * Then if 500 % x == 0, we can find x and y
 * (since there is only one such triplet).
 */

public class PE9 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int x = 0;
		int y = 1;
		double squareRootOfDiscriminant;
		int a;
		int b;
		int c;

		while (x * x + x * y != 500) {
			y++;
			squareRootOfDiscriminant = Math.sqrt(y * y + 2000);
			if (squareRootOfDiscriminant % 1 == 0) {
				x = (-y + (int) squareRootOfDiscriminant) / 2;
			}
		}
		a = x * x - y * y;
		b = 2 * x * y;
		c = x * x + y * y;
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		System.out.println("abc = " + a * b * c);
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
	}
}