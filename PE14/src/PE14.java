
/*	Which starting number, under one million, produces the longest Collatz Sequence?
	These will iterate, so we should memoize these!
*/

import java.util.HashMap;

public class PE14 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BruteForce(1000000);	//	Fast...why?
		//Memoized(1000000);	// OMG this is so slow. Why? Rewrote without recursion...was even slower!
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000000 + " ms");
	}

	public static void Memoized(int limit) {
		HashMap<Long, Long> Memos = new HashMap<Long, Long>();
		Memos.put(1L, 1L);
		long maxResult = 0;
		long maxSeq = 0;

		for (long i = 1; i < limit; i++) {
			Collatz(i, Memos);
			if (Memos.get(i) > maxSeq) {
				maxResult = i;
				maxSeq = Memos.get(i);
			}
		}
		System.out.println(maxResult + " has a Collatz sequence length of " + maxSeq);
	}

	public static long Collatz(long val, HashMap<Long, Long> Memos) {
		if (Memos.get(val) == null) {
			if ((val & 1) == 0) {
				Memos.put(val, Collatz(val >> 1, Memos) + 1);
			} else {
				Memos.put(val, Collatz(3 * val + 1, Memos) + 1);
			}
		}
		return Memos.get(val);
	}

	public static void BruteForce(int limit) {
		int maxResult = 0;
		int maxSeq = 0;
		int curSeq;
		long intVal;
		
		for (int i = limit / 2; i < limit; i++) {
			intVal = i;
			curSeq = 1;
			while (intVal != 1) {
				intVal = ((intVal & 1) == 1) ? (intVal * 3 + 1) : (intVal >> 1);
				curSeq++;
			}
			if (curSeq > maxSeq) {
				maxSeq = curSeq;
				maxResult = i;
			}
		}
		System.out.println(maxResult + " has a Collatz sequence length of " + maxSeq);
	}
}
