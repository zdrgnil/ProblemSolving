import java.util.LinkedList;

public class LinkedListRelated {
	class Node {
		public int value;
		public Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public void testSLLI() {
		Node n4 = new Node(4, null);
		Node n3 = new Node(3, n4);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);
		n4.next = n1;
		Node n5 = SortedLinkedListInsert(n1, 3);
		// Node n5 = n4;
		for (int i = 0; i < 10; i++) {
			System.out.print(n5.value + ",");
			n5 = n5.next;
		}
	}

	public Node SortedLinkedListInsert(Node head, int val) {
		Node node = new Node(val, null);
		Node cur = head;
		while (true) {
			if (val == cur.value || (val > cur.value && val <= cur.next.value)
					|| (cur.value > cur.next.value && val > cur.value)
					|| (cur.value > cur.next.value && val < cur.next.value)) {
				node.next = cur.next;
				cur.next = node;
				break;
			} else {
				cur = cur.next;
			}
		}
		return node;
	}

	/**
	 * Check if there's cycle in the linked list
	 */
	public void hasCycle() {
		Node eight = new Node(8, null);
		Node seven = new Node(7, eight);
		Node six = new Node(6, seven);
		Node five = new Node(5, six);
		Node four = new Node(4, five);
		Node three = new Node(3, four);
		Node two = new Node(2, three);
		Node one = new Node(1, two);
		eight.next = three;
		Node slow = one;
		Node fast = one;
		// printList(fast);
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				System.out.println(fast.value + "," + slow.value + " cycle");
				return;
			}
		}
		System.out.println("no cycle");
	}

	/**
	 * Reverse second half of the list
	 */
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
