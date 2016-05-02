
public class SlidingWindowMaximum {
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

}
