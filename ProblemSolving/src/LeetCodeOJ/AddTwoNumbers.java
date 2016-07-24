package LeetCodeOJ;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode sum = null;
		int a = l1.val, b = l2.val, c = 0;
		sum = new ListNode((a + b) % 10);
		c = (a + b) / 10;
		l1 = l1.next;
		l2 = l2.next;
		ListNode curSum = sum;
		while (l1 != null || l2 != null) {
			a = 0;
			b = 0;
			if (l1 != null) {
				a = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				b = l2.val;
				l2 = l2.next;
			}
			curSum.next = new ListNode((a + b + c) % 10);
			c = (a + b + c) / 10;
			curSum = curSum.next;
		}
		if (c != 0)
			curSum.next = new ListNode(c);
		return sum;
	}
}
