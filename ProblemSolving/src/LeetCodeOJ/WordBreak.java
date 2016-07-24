package LeetCodeOJ;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WordBreak {
	// Recursive
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s.length() == 0 || wordDict.contains(s))
			return true;
		int center = s.length() / 2;
		for (int i = center; i > 0; i--) {
			if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict))
				return true;
		}
		for (int i = center + 1; i < s.length(); i++) {
			if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict))
				return true;
		}
		return false;
	}

	// Iterative
	public boolean wordBreak2(String s, Set<String> wordDict) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = s.length();
		stack.push(0);

		System.out.println("catch");
		while (!stack.isEmpty()) {
			int start = stack.pop();
			if (wordDict.contains(s.substring(start)))
				return true;
			for (int i = start + 1; i < s.length(); i++) {
				if (wordDict.contains(s.substring(start, i)))
					stack.push(i);
			}
			System.out.println(stack.toString());
		}
		return false;
	}

	public boolean wordBreak3(String s, Set<String> wordDict) {
		boolean[] breakable = new boolean[s.length() + 1];
		breakable[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (breakable[j] && wordDict.contains(s.substring(j, i))) {
					breakable[i] = true;
					break;
				}
			}
		}
		return breakable[s.length()];
	}

	public void test() {
		String t = "leetcode";
		Set<String> wordDict = new HashSet<String>() {
			{
				add("leet");
				add("code");
				add("a");
				add("aa");
				add("aaa");
				add("aaaa");
				add("aaaaa");
				add("aaaaaa");
				add("aaaaaaa");
				add("aaaaaaaa");
				add("aaaaaaaaa");
				add("aaaaaaaaaa");
			}
		};
		System.out.println(wordBreak3(t, wordDict));
	}
}
