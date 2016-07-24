package LeetCodeOJ;

public class TrappingRainWater {
	public static int trap(int[] height) {
		int total = 0;
		int start = 0, end = 0;
		while (start < height.length - 1) {
			int cur = start + 1;
			int max = cur;
			while (cur < height.length && height[cur] < height[start]) {
				if (height[cur] > height[max])
					max = cur;
				cur++;
			}
			end = (cur == height.length ? max : cur);
			int small = (height[start] < height[end] ? start : end);
			for (int i = start + 1; i < end; i++) {
				total += height[small] - height[i];
			}

			start = end;

		}
		return total;
	}
}
