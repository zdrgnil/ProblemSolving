package LeetCodeOJ;

public class PalindromeLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Simple solution
	public boolean isPalindrome2(ListNode head) {
		int[] vals;
		ListNode trace = head;
		int count = 0;
		while (trace != null) {
			count++;
			trace = trace.next;
		}
		vals = new int[count];
		trace = head;
		count = 0;
		while (trace != null) {
			vals[count] = trace.val;
			trace = trace.next;
			count++;
		}
		for (int i = 0; i < count / 2; i++) {
			if (vals[i] != vals[count - i - 1])
				return false;
		}
		return true;
	}

	// Space = O(1), Time = O(n)
	public boolean isPalindrome(ListNode head) {
		// find mid point
		ListNode mid = head;
		ListNode fast = head;
		while (mid.next != null && fast.next != null && fast.next.next != null) {
			mid = mid.next;
			fast = fast.next.next;
		}
		ListNode secondHalf = reverseList(mid.next);
		ListNode firstHalf = head;
		while (secondHalf != null) {
			if (firstHalf.val != secondHalf.val)
				return false;
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}
		return true;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head.next;
		ListNode prev = head;
		head.next = null;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}
}
