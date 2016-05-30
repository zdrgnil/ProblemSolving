
public class maze {

	/**
	 * 0 is path, 1 is wall, 9 is destination
	 */
	public static Boolean isReachable(int[][] maze) {
		Boolean[] isfound = new Boolean[1];
		isfound[0] = false;
		isReacheable(maze, 0, 0, isfound);
		return isfound[0];
	}

	public static void isReacheable(int[][] maze, int x, int y, Boolean[] isfound) {
		if (x < 0 || y < 0 || x >= maze[0].length || y >= maze.length || maze[x][y] == 1 || maze[x][y] == -1
				|| isfound[0])
			return;
		if (maze[x][y] == 0) {
			maze[x][y] = -1;
			isReacheable(maze, x + 1, y, isfound);
			isReacheable(maze, x - 1, y, isfound);
			isReacheable(maze, x, y + 1, isfound);
			isReacheable(maze, x, y - 1, isfound);
			return;
		}
		if (maze[x][y] == 9) {
			isfound[0] = true;
			return;
		}
	}
}
