package LeetCodeOJ;

public class ValidAnagram {
	int[] map = new int[26];

	public boolean isAnagram(String s, String t) {
		for (char c : s.toCharArray()) {
			map[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			map[c - 'a']--;
		}
		for (int m : map)
			if (m != 0)
				return false;
		return true;
	}
}
