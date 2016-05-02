
public class MainArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] num1 = {};
		System.out.println(maxPos(nums, 3, 0));
		printIntArray(maxSlidingWindow(num1, 0));
	}

	/**
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

	public static void printIntArray(int nums[]) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ", ");
	}
}
