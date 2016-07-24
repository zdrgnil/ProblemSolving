package LeetCodeOJ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LetterCombinationsOfPhoneNumber {

	// Solution 1
	HashMap<Integer, String> map = new HashMap<Integer, String>() {
		{
			put(2, "abc");
			put(3, "def");
			put(4, "ghi");
			put(5, "jkl");
			put(6, "mno");
			put(7, "pqrs");
			put(8, "tuv");
			put(9, "wxyz");
		}
	};

	public List<String> letterCombinations(String digits) {
		if (digits.equals(""))
			return new LinkedList<String>();
		List<String> result = letterCombinations(digits.substring(1));
		List<String> newResult = new LinkedList<String>();
		String chars = map.get(Integer.parseInt(digits.charAt(0) + ""));
		for (char c : chars.toCharArray()) {
			if (result.size() != 0)
				for (String r : result) {
					newResult.add(c + r);
				}
			else
				newResult.add(c + "");
		}
		// System.out.println(newResult.size());
		return newResult;
	}
}
