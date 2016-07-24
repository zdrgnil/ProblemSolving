package LeetCodeOJ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Box {
		int index;
		ListNode node;

		Box(int index, ListNode node) {
			this.index = index;
			this.node = node;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		ListNode head = null, tail = null;
		PriorityQueue<Box> queue = new PriorityQueue<Box>(lists.length, new Comparator<Box>() {
			@Override
			public int compare(Box arg0, Box arg1) {
				return arg0.node.val - arg1.node.val;
			}
		});
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				queue.add(new Box(i, lists[i]));
				lists[i] = lists[i].next;
			}
		}
		Box top = queue.poll();
		if (top != null) {
			if (lists[top.index] != null) {
				queue.add(new Box(top.index, lists[top.index]));
				lists[top.index] = lists[top.index].next;
			}
			head = top.node;
			tail = head;
		}
		while (!queue.isEmpty()) {
			top = queue.poll();
			if (lists[top.index] != null) {
				queue.add(new Box(top.index, lists[top.index]));
				lists[top.index] = lists[top.index].next;
			}
			tail.next = top.node;
			tail = tail.next;
		}
		return head;

	}
}
