package LeetCodeOJ;

import LeetCodeOJ.MergeKLists.ListNode;

public class MergeTwoList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head, tail;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		tail = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		if (l1 == null)
			tail.next = l2;
		else
			tail.next = l1;
		return head;
	}
}
