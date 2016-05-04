import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MainArea {

	public static void main(String[] args) {
		ArrayList<Integer> t = new ArrayList<Integer>();
		t.add(4);
		t.add(2);
		t.add(12);
		t.add(11);
		t.add(-5);
		ArrayList<Integer> y = calculateWindowMinimum(t, 2);
		for (Integer i : t) {
			System.out.print(i + ",");
		}

	}

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

	public static void printA(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	private static int minPos(ArrayList<Integer> list, int w, int starting) {
		int min_pos = starting;
		for (int i = starting + 1; i < starting + w; i++) {
			if (list.get(i) <= list.get(min_pos))
				min_pos = i;
		}
		return min_pos;
	}

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

	public static void print2DArray(Integer matrix[][]) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + ",");
			}
			System.out.println();
		}
	}

	public static void printIntArray(int nums[]) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ", ");
	}
}
