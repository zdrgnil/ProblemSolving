
public class Search {

	/**
	 * Input: array of integer in ascending order, integer target Output: if
	 * target is in the array
	 * 
	 * Time Complexity: O(log(n))
	 */
	public static boolean binarySearch(int[] list, int target) {
		int left = 0;
		int right = list.length - 1;
		int mid = (int) Math.floor((right - left) / 2);
		while (right - left >= 0) {
			// System.out.println(mid + ":" + left + "," + right);
			if (list[mid] == target)
				return true;
			if (target < list[mid]) {
				right = mid - 1;
				mid = left + (int) Math.floor((right - left) / 2);
			} else {
				left = mid + 1;
				mid = left + (int) Math.floor((right - left) / 2);
			}
		}
		return false;
	}

	/*
	 * https://leetcode.com/problems/search-a-2d-matrix-ii/
	 * 
	 * Input: A 2D array matrix with: 1. Integers in each row are sorted in
	 * ascending from left to right. 2. Integers in each column are sorted in
	 * ascending from top to bottom. A target integer.
	 * 
	 * Output: If target is in the matrix
	 */
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

}
