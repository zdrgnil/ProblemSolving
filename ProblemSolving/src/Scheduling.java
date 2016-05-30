import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scheduling {
	public int LRUCaching(int[] array, int size) {
		if (array == null)
			return 0;
		List<Integer> list = new LinkedList<Integer>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (list.contains(array[i])) {
				list.remove(new Integer(array[i]));
			} else {
				count++;
				if (size == list.size())
					list.remove(0);
			}
			list.add(array[i]);
		}
		return count;
	}

	public static float waitingTimeSJF(int[] requestTimes, int[] durations) {
		class Process {
			public int arrive;
			public int execute;

			public Process(int arrive, int execute) {
				this.arrive = arrive;
				this.execute = execute;
			}
		}
		PriorityQueue<Process> ps = new PriorityQueue<Process>(requestTimes.length, new Comparator<Process>() {
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
		for (queP = 1; queP < requestTimes.length; queP++) {
			if (requestTimes[queP] > (requestTimes[0] + durations[0]))
				break;
			ps.add(new Process(requestTimes[queP], durations[queP]));
		}

		float waiting = 0;
		int curTime = requestTimes[0] + durations[0];
		while (!ps.isEmpty() || queP < requestTimes.length) {
			Process curP = ps.poll();
			waiting += curTime - curP.arrive;
			curTime += curP.execute;
			for (; queP < requestTimes.length; queP++) {
				if (requestTimes[queP] > curTime)
					break;
				ps.add(new Process(requestTimes[queP], durations[queP]));
			}

		}
		// for (Process p : ps) {
		// System.out.println(p.arrive + " : " + p.execute);
		// }
		return waiting / requestTimes.length;
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

	/**
	 * int a[] = { 0, 2, 4, 5 };
	 * 
	 * int e[] = { 7, 4, 1, 4 };
	 * 
	 * System.out.println(roundRobin(a, e, 3));
	 */
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

	// // Assume arrive is sorted.
	// public double roundRobin(int[] arrive, int[] excute, int q) {
	// LinkedList<process> queue = new LinkedList<>();
	// int curTime = 0;
	// int waitTime = 0;
	// int nextProIdx = 0;
	// while (!queue.isEmpty() || nextProIdx < arrive.length) {
	// if (!queue.isEmpty()) {
	// process cur = queue.poll();
	// waitTime += curTime - cur.arriveTime;
	// curTime += Math.min(cur.excuteTime, q);
	// for (int i = nextProIdx; i < arrive.length; i ++) {
	// if (arrive[i] <= curTime) {
	// queue.offer(new process(arrive[i], excute[i]));
	// nextProIdx = i + 1;
	// } else {
	// break;
	// }
	// }
	// if (cur.excuteTime > q) {. From 1point 3acres bbs
	// queue.offer(new process(curTime, cur.excuteTime - q);
	// }
	// } else {
	// queue.offer(new process(arrive[nextProIdx],
	// excute[nextProIdx]));
	// curTime = arrive[nextProIdx ++];
	// }
	// }
	//
	// return (double)waitTime / arrive.length;
	// }
}
