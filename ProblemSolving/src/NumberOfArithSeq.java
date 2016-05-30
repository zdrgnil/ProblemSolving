
public class NumberOfArithSeq {
	/**
	 * Get possible number of arithmetic sequence
	 * 
	 * int a[] = { -1, 1, 3, 3, 3, 2, 1, 0, -99 };
	 * 
	 * System.out.println(getNAS(a)); should return 5
	 */
	public static int getNAS(int[] a) {
		int total = 0;
		int start = 0;
		int end = 1;
		int diff = a[1] - a[0];
		while (true) {
			if (end + 1 != a.length && a[end + 1] - a[end] == diff) {
				end++;
				continue;
			} else {
				if (end - start >= 2) {
					total += (end - start - 2) * 2 + 1;
					System.out.println(start + "," + end);
				}
				if (end + 1 == a.length)
					break;
				start = end;
				end = end + 1;
				diff = a[end] - a[start];
			}
		}
		return total;
	}
}
