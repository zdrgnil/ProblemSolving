package LeetCodeOJ;

public class NumberOfIsland {
	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == '1') {
					count++;
					sinkIsland(grid, row, col);
				}
			}
		}
		return count;
	}

	public static void sinkIsland(char[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
			return;
		grid[row][col] = '0';
		sinkIsland(grid, row + 1, col);
		sinkIsland(grid, row - 1, col);
		sinkIsland(grid, row, col + 1);
		sinkIsland(grid, row, col - 1);
	}
}
