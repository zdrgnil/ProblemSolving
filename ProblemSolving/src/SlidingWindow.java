import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {

	/**
	 * Get sum in list with window size k
	 * 
	 * [4,2,73,11,-5],2 should return [6,75,84,6]
	 * 
	 * [4,2,73,11,-5],3 should return [79,86,79]
	 */
	public static List<Integer> getSum(int a[], int k) {
		List<Integer> sums = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < k; i++)
			sum += a[i];

		sums.add(sum);
		int start = 0;
		for (int end = k; end < a.length; end++) {
			sum = sum - a[start] + a[end];
			start++;
			sums.add(sum);
		}
		return sums;
	}

	/**
	 * https://leetcode.com/problems/sliding-window-maximum/
	 * 
	 * <239. Sliding Window Maximum > Given an array nums, there is a sliding
	 * window of size k which is moving from the very left of the array to the
	 * very right. You can only see the k numbers in the window. Each time the
	 * sliding window moves right by one position.
	 * 
	 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3. return the max
	 * sliding window as [3,3,5,5,6,7].
	 */
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return nums;
		int result[] = new int[nums.length - k + 1];
		int maxPos = maxPos(nums, k, 0);
		result[0] = nums[maxPos];
		for (int start = 1; start < result.length; start++) {
			int end = start + k - 1;
			if (maxPos < start)
				maxPos = maxPos(nums, k, start);
			else {
				if (nums[end] >= nums[maxPos])
					maxPos = end;
			}
			result[start] = nums[maxPos];
		}
		return result;
	}

	private static int maxPos(int nums[], int k, int starting) {
		int max_pos = starting;
		for (int i = starting + 1; i < starting + k; i++) {
			if (nums[i] > nums[max_pos])
				max_pos = i;
		}
		return max_pos;
	}

	/**
	 * Variation of above problem, sliding window minimum
	 */
	public static ArrayList<Integer> calculateWindowMinimum(ArrayList<Integer> list, int w) {
		if (list == null || list.size() == 0)
			return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		int minPos = minPos(list, w, 0);
		result.add(list.get(minPos));
		for (int start = 1; start < list.size() - w + 1; start++) {
			int end = start + w - 1;
			if (minPos < start)
				minPos = minPos(list, w, start);
			else {
				if (list.get(end) <= list.get(minPos))
					minPos = end;
			}
			result.add(list.get(minPos));
		}
		return result;
	}

	private static int minPos(ArrayList<Integer> list, int w, int starting) {
		int min_pos = starting;
		for (int i = starting + 1; i < starting + w; i++) {
			if (list.get(i) <= list.get(min_pos))
				min_pos = i;
		}
		return min_pos;
	}

}
