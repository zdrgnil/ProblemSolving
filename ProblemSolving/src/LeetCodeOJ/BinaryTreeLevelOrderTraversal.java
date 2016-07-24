package LeetCodeOJ;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Box {
		TreeNode node;
		int level;

		Box(TreeNode n, int lvl) {
			node = n;
			level = lvl;
		}

		public String toString() {
			return "" + node.val;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new LinkedList<List<Integer>>();
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Queue<Box> queue = new LinkedList<Box>();
		queue.add(new Box(root, 0));
		while (!queue.isEmpty()) {
			Box box = queue.poll();
			System.out.println(box.node.val + ":" + box.level);
			if (result.size() < box.level + 1) {
				List<Integer> ll = new LinkedList<Integer>();
				ll.add(box.node.val);
				result.add(box.level, ll);
			} else {
				result.get(box.level).add(box.node.val);
			}
			if (box.node.left != null)
				queue.offer(new Box(box.node.left, box.level + 1));
			if (box.node.right != null)
				queue.offer(new Box(box.node.right, box.level + 1));
		}
		return result;
	}
	
	
}
