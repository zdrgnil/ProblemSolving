package LeetCodeOJ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> result = new LinkedList<List<String>>();
		for (String str : strs) {
			String key = sortStr(str);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new LinkedList<String>();
				list.add(str);
				result.add(list);
				map.put(key, list);
			}
		}
		return result;
	}

	public static String sortStr(String str) {
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		return String.copyValueOf(cs);
	}
}
