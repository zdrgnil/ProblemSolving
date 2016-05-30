
public class TreeRelated {
	class TNode {
		public int value;
		public TNode left;
		public TNode right;
	}

	public void test() {
		TNode a = new TNode();
		a.value = 0;
		a.left = null;
		a.right = null;
		System.out.println(a.value);
	}

	class Tree {
		public int value;
		public Tree left;
		public Tree right;

		public Tree(int value, Tree left, Tree right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public void BstToLL(Tree node) {
	}

	public boolean isValidBST(Tree root) {
		return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	public boolean isValidBST(Tree root, Long max, Long min) {
		if (root == null)
			return true;
		if (root.value >= max || root.value <= min)
			return false;
		return isValidBST(root.left, (long) root.value, min) && isValidBST(root.right, max, (long) root.value);
	}

	// If t2 is subtree of t1
	public boolean isSubtree(Tree t1, Tree t2) {
		if (t2 == null)
			return true;
		if (t1 == null)
			return false;
		return isSameTree(t1, t2) || isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	}

	public boolean isSameTree(Tree t1, Tree t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		if (t1.value != t2.value)
			return false;
		return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
	}
}
