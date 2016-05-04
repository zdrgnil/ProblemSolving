
public class LinkedList {
	class Node {
		public int value;
		public Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public void testReverseHalf() {
		Node l = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
		Node cur = l;
		int total = 0;
		while (cur != null) {
			total++;
			cur = cur.next;
		}
		cur = l;
		for (int i = 0; i < Math.floor(total / 2) - 1; i++) {
			cur = cur.next;
		}
		tuple t2 = reverse(cur.next);
		cur.next = t2.first;
		System.out.println(cur.value);
		printList(l);
	}

	class tuple {
		public Node first;
		public Node last;

		public tuple(Node first, Node last) {
			this.first = first;
			this.last = last;
		}
	}

	public tuple reverse(Node n) {
		if (n == null)
			return null;
		if (n.next == null)
			return new tuple(n, n);
		tuple t = reverse(n.next);
		n.next = null;
		t.last.next = n;
		return new tuple(t.first, n);
	}

	void printList(Node n) {
		Node t = n;
		while (t != null) {
			System.out.print(t.value + ", ");
			t = t.next;
		}
		System.out.println();
	}
}
