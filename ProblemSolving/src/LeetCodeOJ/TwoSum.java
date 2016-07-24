package LeetCodeOJ;

import java.util.HashMap;

public class TwoSum {
	/**
	 * https://leetcode.com/problems/two-sum/ return the index of two number
	 * where their sum is target
	 */
	public static int[] twoSum(int[] nums, int target) {
		Integer a = null, b = null;
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if ((table.containsKey(nums[i]) && target / 2 == nums[i]) || table.containsKey(target - nums[i])) {
				a = table.get(target - nums[i]);
				b = i;
				break;
			}
			table.put(nums[i], i);
		}
		return new int[] { a, b };
	}

	/**
	 * 167. Two Sum II - Input array is sorted
	 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
	 */
	public int[] twoSumS(int[] numbers, int target) {
		int[] index = new int[2];
		index[0] = 0;
		index[1] = numbers.length - 1;
		while (index[0] < index[1]) {
			int sum = numbers[index[0]] + numbers[index[1]];
			if (sum == target)
				return index;
			else if (sum < target) {
				index[0]++;
			} else {
				index[1]--;
			}
		}
		return index;
	}

}
