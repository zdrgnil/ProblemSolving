package LeetCodeOJ;

public class lowestCommonAncestor {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class LinkedList {
		public TreeNode node;
		public LinkedList next;

		public LinkedList(TreeNode node) {
			this.node = node;
		}
	}

	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == root || q == root)
			return root;
		TreeNode left = lowestCommonAncestorBST(root.left, p, q);
		TreeNode right = lowestCommonAncestorBST(root.right, p, q);
		if (left == null && right != null)
			return right;
		if (left != null && right == null)
			return left;
		return root;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p == root || q == root || root == null)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null)
			return right;
		if (right == null)
			return left;
		return root;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		LinkedList pa = getAncestors(root, p);
		LinkedList qa = getAncestors(root, q);
		TreeNode cr = root;
		while (pa != null && qa != null && pa.node == qa.node) {
			cr = pa.node;
			pa = pa.next;
			qa = qa.next;
		}
		return cr;
	}

	LinkedList getAncestors(TreeNode r, TreeNode n) {
		if (r == null)
			return null;
		if (r == n)
			return new LinkedList(r);
		LinkedList list = new LinkedList(r);
		LinkedList left = getAncestors(r.left, n);
		LinkedList right = getAncestors(r.right, n);
		if (left != null) {
			list.next = left;
			return list;
		}
		if (right != null) {
			list.next = right;
			return list;
		}
		return null;
	}

}
