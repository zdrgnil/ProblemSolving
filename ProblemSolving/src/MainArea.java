import java.util.Collections;
import java.util.PriorityQueue;

public class MainArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int[] m2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[][] m3 = { { 1 } };

		// System.out.println(binarySearch(m[0], 4));
		for (int r = 0; r < m.length; r++) {
			for (int t : m[r])
				System.out.print(searchMatrix(m, t) + ",");
			System.out.println();
		}
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int r = 0, c = matrix[0].length - 1;
		while (r < matrix.length && c >= 0) {
			if (matrix[r][c] == target)
				return true;
			if (target > matrix[r][c])
				r++;
			else
				c--;
		}
		return false;
	}

	public static void printIntArray(int nums[]) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ", ");
	}
}
