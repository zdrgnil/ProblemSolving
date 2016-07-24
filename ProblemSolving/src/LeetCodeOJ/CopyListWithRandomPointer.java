package LeetCodeOJ;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public void test() {
		RandomListNode four = new RandomListNode(4);
		RandomListNode three = new RandomListNode(3);
		RandomListNode two = new RandomListNode(2);
		RandomListNode one = new RandomListNode(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.random = two;
		RandomListNode result = copyRandomList(one);
		print(result);
	}

	public void print(RandomListNode head) {
		RandomListNode cur = head;
		while (cur != null) {
			System.out.println(cur.label + (cur.random == null ? "" : "=>" + cur.random.label));
			cur = cur.next;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		RandomListNode oldCur = head.next;
		RandomListNode newPrev = newHead;
		while (oldCur != null) {
			if (map.containsKey(oldCur))
				break;
			RandomListNode node = new RandomListNode(oldCur.label);
			map.put(oldCur, node);
			newPrev.next = node;
			newPrev = node;
			oldCur = oldCur.next;
		}

		oldCur = head;
		RandomListNode newCur = newHead;
		while (oldCur != null) {
			if (oldCur.random != null) {
				newCur.random = map.get(oldCur.random);
			}
			newCur = newCur.next;
			oldCur = oldCur.next;
		}

		return newHead;
	}
}
