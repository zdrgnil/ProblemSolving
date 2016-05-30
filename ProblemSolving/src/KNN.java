import java.util.Comparator;
import java.util.PriorityQueue;

public class KNN {
	public static void testKNN() {
		KNN knn = new KNN();
		Point[] points = new Point[10];
		points[9] = knn.new Point(999, 999);
		points[8] = knn.new Point(-1, -1);
		points[7] = knn.new Point(2, 2);
		points[6] = knn.new Point(22, 22);
		points[5] = knn.new Point(4, 4);
		points[4] = knn.new Point(5, 5);
		points[3] = knn.new Point(6, 6);
		points[2] = knn.new Point(0, 0);
		points[1] = knn.new Point(8, 8);
		points[0] = knn.new Point(9, 9);
		Point[] kp = getCloseK(points, knn.new Point(0, 0), 5);
		for (Point p : kp) {
			System.out.println(p.x + "," + p.y);
		}
	}

	public class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static Point[] getCloseK(Point[] points, Point origin, int k) {
		PriorityQueue<Point> closest = new PriorityQueue<Point>(k, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return (int) ((distance(o1, origin) - distance(o2, origin)) * 1000);
			}
		});
		for (Point p : points) {
			closest.add(p);
		}
		Point[] result = new Point[k];
		for (int i = 0; i < k; i++) {
			Point p = closest.poll();
			result[i] = p;
		}
		return result;
	}

	public static double distance(Point o1, Point o2) {
		return Math.sqrt((o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y));
	}
}
