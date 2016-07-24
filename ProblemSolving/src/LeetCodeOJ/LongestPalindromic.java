package LeetCodeOJ;

public class LongestPalindromic {

	public void test() {
		String s = "ccd";
		int[] ss = pala(s, 1);
		System.out.println(ss[0] + "~" + ss[1]);
		System.out.println(longestPalindrome(s));
		for (int i = 0; i < s.length(); i++)
			System.out.println(i + ":" + palength(s, i));
	}

	public String longestPalindrome(String s) {
		int center = s.length() / 2;
		int range[] = pala(s, center);
		int maxLen = range[1] - range[0] + 1;
		int maxRange[] = range;
		int maxCenter = center;
		int iter = 1;
		while (center - iter >= 0 && center + iter <= s.length() && center - iter > maxLen / 2) {
			int len;
			range = pala(s, center - iter);
			len = range[1] - range[0] + 1;
			if (len > maxLen) {
				maxRange = range;
				maxLen = len;
				maxCenter = center - iter;
			}

			range = pala(s, center + iter);
			len = range[1] - range[0] + 1;
			if (len > maxLen) {
				maxRange = range;
				maxLen = len;
				maxCenter = center + iter;
			}
			iter++;
		}
		// System.out.println(maxCenter);
		// System.out.println(maxLen);
		return s.substring(maxRange[0], maxRange[1] + 1);
	}

	public int[] pala(String str, int center) {
		int a = center - 1, b = center + 1;
		int bestA, bestB;
		int max = 1;
		int len = str.length();
		while (a >= 0 && b < len && str.charAt(a) == str.charAt(b)) {
			a--;
			b++;
		}
		max = b - a - 1;
		bestA = a + 1;
		bestB = b - 1;

		a = center - 1;
		b = center;
		while (a >= 0 && b < len && str.charAt(a) == str.charAt(b)) {
			a--;
			b++;
		}
		if (b - a - 1 > max) {
			max = b - a - 1;
			bestA = a + 1;
			bestB = b - 1;
		}

		a = center;
		b = center + 1;
		while (a >= 0 && b < len && str.charAt(a) == str.charAt(b)) {
			a--;
			b++;
		}

		if (b - a - 1 > max) {
			max = b - a - 1;
			bestA = a + 1;
			bestB = b - 1;
		}
		return new int[] { bestA, bestB };
	}

	public int palength(String str, int center) {
		int a = center - 1, b = center + 1;
		int max = 1;
		int len = str.length();
		while (a >= 0 && b < len && str.charAt(a) == str.charAt(b)) {
			a--;
			b++;
		}
		max = b - a - 1;

		a = center - 1;
		b = center;
		while (a >= 0 && b < len && str.charAt(a) == str.charAt(b)) {
			a--;
			b++;
		}
		if (b - a - 1 > max)
			max = b - a - 1;

		a = center;
		b = center + 1;
		while (a >= 0 && b < len && str.charAt(a) == str.charAt(b)) {
			a--;
			b++;
		}

		if (b - a - 1 > max)
			max = b - a - 1;
		return max;
	}
}
