package LeetCodeOJ;

import java.util.LinkedList;
import java.util.List;

public class BinaryRightSideView {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null)
			return list;
		List<Integer> left = rightSideView(root.left);
		List<Integer> right = rightSideView(root.right);
		list.add(root.val);
		list.addAll(right);
		if (left.size() > right.size()) {
			for (int i = right.size() + 1; i <= left.size(); i++) {
				list.add(i, left.get(i - 1));
			}
		}
		return list;
	}
}
