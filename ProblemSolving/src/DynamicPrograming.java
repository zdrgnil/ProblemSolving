
public class DynamicPrograming {
	/**
	 * Find The max minimum path value of a matrix from top left corner to
	 * bottom right corner. e.g.{ { 8, 4, 7 }, { 6, 5, 9 } } There will be 3
	 * path:
	 * <ul>
	 * <li>8-4-7-9 min: 4</li>
	 * <li>8-4-5-9 min: 4</li>
	 * <li>8-6-5-9 min: 5</li>
	 * </ul>
	 * return 5
	 * 
	 * Solution: use dynamic programming
	 * 
	 * Time Complexity: O(mn), m & n are the dimension of the matrix
	 * 
	 * @param matrix
	 *            two dimensional integer array
	 * @return max of min path value
	 * 
	 */
	public static int maxMinPath(int[][] matrix) {
		Integer[][] maxMinMap = new Integer[matrix.length][matrix[0].length];
		maxMinMap[0][0] = matrix[0][0];
		for (int col = 1; col < matrix[0].length; col++) {
			maxMinMap[0][col] = Math.min(maxMinMap[0][col - 1], matrix[0][col]);
		}
		for (int row = 1; row < matrix.length; row++) {
			maxMinMap[row][0] = Math.min(maxMinMap[row - 1][0], matrix[row][0]);
		}

		for (int row = 1; row < matrix.length; row++) {
			for (int col = 1; col < matrix[0].length; col++) {
				maxMinMap[row][col] = Math.max(Math.min(maxMinMap[row][col - 1], matrix[row][col]),
						Math.min(maxMinMap[row - 1][col], matrix[row][col]));
			}
		}
		// print2DArray(maxMinMap);
		return maxMinMap[matrix.length - 1][matrix[0].length - 1];
	}

}
