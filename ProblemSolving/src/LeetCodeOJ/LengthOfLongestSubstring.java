package LeetCodeOJ;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	public void test() {
		System.out.println("3 : " + lengthOfLongestSubstring("abcabcbb"));
		System.out.println("1 : " + lengthOfLongestSubstring("bbbbb"));
		System.out.println("3 : " + lengthOfLongestSubstring("pwwkew"));
		System.out.println("0 : " + lengthOfLongestSubstring(""));
		System.out.println("1 : " + lengthOfLongestSubstring("c"));
		System.out.println("2 : " + lengthOfLongestSubstring("aab"));
		System.out.println("1 : " + lengthOfLongestSubstring("aa"));
		System.out.println("2 : " + lengthOfLongestSubstring("cdd"));
		System.out.println("2 : " + lengthOfLongestSubstring("abba"));
		System.out.println("3 : " + lengthOfLongestSubstring("dvdfv"));
		System.out.println("? : " + lengthOfLongestSubstring("dvddf"));
	}

	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		int max = 0;
		int recentRepeat = 0;
		int start = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++) {
			Character c = s.charAt(i);
			if (!map.containsKey(c)) {// new character
				start = i;
				map.put(s.charAt(i), i);
				if (recentRepeat == 0)
					max = i + 1;
			} else {// Repeat
				if (map.get(c) > start)
					start = i;
				int len = i - map.get(c);
				if (recentRepeat <= map.get(c) && len > max)
					max = len;
				map.put(c, i);
				recentRepeat = i;
			}
		}
		// System.out.println(s + ":" + max + "," + (length - recentRepeat) +
		// "," + (length - start));
		// return Math.max(max, Math.max(length - recentRepeat, length -
		// start));
		return (max > length - recentRepeat ? max : length - recentRepeat);
	}
}
