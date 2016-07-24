package LeetCodeOJ;

public class GetIntersectionNode {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void test() {
		ListNode three = new ListNode(3);
		ListNode two = new ListNode(2);
		two.next = three;
		System.out.println(getIntersectionNode(three, two).val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;
		ListNode a = headA, b = headB;
		while (a != null) {
			lenA++;
			a = a.next;
		}
		while (b != null) {
			lenB++;
			b = b.next;
		}
		a = headA;
		b = headB;
		if (lenA > lenB)
			for (int i = 0; i < lenA - lenB; i++)
				a = a.next;
		else
			for (int i = 0; i < lenB - lenA; i++)
				b = b.next;

		while (a != null && b != null && a != b) {
			a = a.next;
			b = b.next;
			if (a == b)
				return a;
		}
		if (a == null || b == null)
			return null;
		return a;
	}
}
