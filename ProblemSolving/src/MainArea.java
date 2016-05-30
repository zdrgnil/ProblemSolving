import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainArea {

	public static void main(String[] args) {
		// int a[] = { 0, 1, 3, 9 };
		// int b[] = { 2, 1, 7, 5 };
		// Scheduling s = new Scheduling();
		// System.out.println(s.shortestJobFirst(a, b));
		TreeRelated t = new TreeRelated();
		t.test();

	}

	class TNode {
		public int value;
		public TNode left;
		public TNode right;
	}

	public static int minTreePath(TNode t) {
		if (t == null)
			return 0;
		if (t.left == null && t.right == null)
			return t.value;
		else if (t.left == null && t.right != null)
			return minTreePath(t.right) + t.value;
		else if (t.left != null && t.right == null)
			return minTreePath(t.left) + t.value;
		else
			return Math.min(minTreePath(t.left), minTreePath(t.right)) + t.value;
	}

	public static float shortestJobFirst(int[] Atime, int[] Etime) {
		class Process {
			public int arrive;
			public int execute;

			public Process(int arrive, int execute) {
				this.arrive = arrive;
				this.execute = execute;
			}
		}
		PriorityQueue<Process> ps = new PriorityQueue<Process>(Atime.length, new Comparator<Process>() {
			@Override
			public int compare(Process arg0, Process arg1) {
				if (arg0.execute == arg1.execute)
					return arg0.arrive - arg1.arrive;
				else {
					return arg0.execute - arg1.execute;
				}
			}
		});
		int queP;
		for (queP = 1; queP < Atime.length; queP++) {
			if (Atime[queP] > (Atime[0] + Etime[0]))
				break;
			ps.add(new Process(Atime[queP], Etime[queP]));
		}

		float waiting = 0;
		int curTime = Atime[0] + Etime[0];
		while (!ps.isEmpty() || queP < Atime.length) {
			Process curP = ps.poll();
			waiting += curTime - curP.arrive;
			curTime += curP.execute;
			for (; queP < Atime.length; queP++) {
				if (Atime[queP] > curTime)
					break;
				ps.add(new Process(Atime[queP], Etime[queP]));
			}

		}
		// for (Process p : ps) {
		// System.out.println(p.arrive + " : " + p.execute);
		// }
		return waiting / Atime.length;
	}

	public static float RoundRobinScheduling(int[] Atime, int[] Etime, int q) {
		class process {
			public int arrTime;
			public int exeTime;

			public process(int arrive, int execute) {
				this.arrTime = arrive;
				this.exeTime = execute;
			}
		}

		if (Atime == null || Etime == null || Atime.length != Etime.length)
			return 0;
		int length = Atime.length;
		Queue<process> queue = new LinkedList<process>();
		int curTime = 0, waitTime = 0;
		int index = 0;
		while (!queue.isEmpty() || index < length) {
			if (!queue.isEmpty()) {
				process cur = queue.poll();
				waitTime += curTime - cur.arrTime;
				curTime += Math.min(cur.exeTime, q);
				for (; index < length && Atime[index] <= curTime; index++)
					queue.offer(new process(Atime[index], Etime[index]));
				if (cur.exeTime > q)
					queue.offer(new process(curTime, cur.exeTime - q));
			} else {
				queue.add(new process(Atime[index], Etime[index]));
				curTime = Atime[index++];
			}
		}
		return (float) waitTime / length;
	}

	public static float roundRobin(int[] Atime, int[] Etime, int q) {
		class Process {
			public int arrive;
			public int execute;

			public Process(int arrive, int execute) {
				this.arrive = arrive;
				this.execute = execute;
			}
		}

		float waiting = 0;
		int cp = 0;
		int curTime = 0;
		Process curP;
		Queue<Process> ps = new LinkedList<Process>();
		for (int i = 0; i < Atime.length; i++) {
			ps.add(new Process(Atime[i], Etime[i]));
		}
		curP = ps.poll();
		while (curP != null) {
			if (curP.arrive > curTime) {
				curTime = curP.arrive;
				continue;
			}
			waiting += curTime - curP.arrive;
			System.out.println(cp + " - " + curTime + "," + curP.arrive + ":" + (curTime - curP.arrive));
			if (curP.execute <= q) {
				curTime += curP.execute;
				curP = ps.poll();
				cp++;
				continue;
			} else {
				curTime += q;
				curP.arrive = curTime;
				curP.execute -= q;
				// check if next p arrived
				if (ps.peek() != null && ps.peek().arrive <= curTime) {
					ps.add(curP);
					curP = ps.poll();
				}
				cp++;
			}

		}
		return waiting / Atime.length;
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int numj = target - nums[i];
			if (m.containsKey(numj)) {
				int si = (nums[i] < numj ? i : m.get(numj));
				int bi = (nums[i] > numj ? i : m.get(numj));
				return new int[] { si, bi };
			}
			m.put(nums[i], i);
		}
		return new int[] { 0, 0 };
	}

	public static void findOptimalWeights(double capacity, double[] weights) {
		Arrays.sort(weights);
		int a = 0;
		int b = weights.length - 1;
		int A = 0;
		int B = weights.length - 1;
		double bestSum = Integer.MIN_VALUE;
		while (a < b) {
			double sum = weights[a] + weights[b];
			if (sum <= capacity && sum > bestSum) {
				A = a;
				B = b;
				bestSum = sum;
			}
			if (sum < capacity)
				a++;
			else
				b--;
		}
		System.out.println(A + "," + B);
	}

	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a -= b;
			else
				b -= a;
		}
		return a;
	}

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

	public static void printA(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static void print2DArray(int[][] m) {
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[0].length; c++) {
				System.out.print(m[r][c] + ",");
			}
			System.out.println();
		}
	}

	public static void printIntArray(int nums[]) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ", ");
	}
}
