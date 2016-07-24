package LeetCodeOJ;

import java.util.LinkedList;
import java.util.List;

public class Subset {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (nums.length == 0)
			return result;
		List<Integer> sublist = new LinkedList<Integer>();
		result.add(sublist);
		for (int i = 0; i < nums.length; i++) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				sublist = new LinkedList<Integer>(result.get(j));
				sublist.add(nums[i]);
				result.add(sublist);
			}
		}
		return result;
	}

}
