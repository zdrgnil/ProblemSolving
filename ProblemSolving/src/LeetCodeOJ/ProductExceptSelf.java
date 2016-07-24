package LeetCodeOJ;

public class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int cumulate = 1;
		int result[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = cumulate;
			cumulate *= nums[i];
		}
		cumulate = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] *= cumulate;
			cumulate *= nums[i];
		}
		return result;
	}
}
