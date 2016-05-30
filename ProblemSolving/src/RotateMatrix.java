
public class RotateMatrix {
	/**
	 * https://leetcode.com/problems/rotate-image
	 * 
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 * 
	 * int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; rotate2(m);
	 * print2DArray(m);
	 * 
	 */
	public static void rotate2(int[][] matrix) {// Space complexity O(1)
		int n = matrix.length;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < Math.floor(n / 2); col++) {
				int tmpt = matrix[row][col];
				matrix[row][col] = matrix[row][n - 1 - col];
				matrix[row][n - 1 - col] = tmpt;
			}
		}
		int rRow;
		int rCol = n - 1;
		for (int row = 0; row < n - 1; row++) {
			for (int col = 0; col < n - 1; col++) {
				if (row + col == n - 1)
					break;
				int tmpt = matrix[row][col];
				matrix[row][col] = matrix[n - 1 - col][n - 1 - row];
				matrix[n - 1 - col][n - 1 - row] = tmpt;
			}
		}
	}

	public static void rotate(int[][] matrix) {
		int rRow;
		int n = matrix.length;
		int rCol = n - 1;
		int[][] Result = new int[n][n];
		for (int row = 0; row < n; row++) {
			rRow = 0;
			for (int col = 0; col < n; col++) {
				Result[rRow][rCol] = matrix[row][col];
				rRow++;
			}
			rCol--;
		}
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				matrix[row][col] = Result[row][col];
			}
		}
	}
}
