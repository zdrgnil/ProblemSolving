package LeetCodeOJ;

public class SerializeAndDeserializeBT {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "(null)";
		if (root.left == null && root.right == null)
			return "(" + root.val + ")";
		return "(" + root.val + "," + serialize(root.left) + "," + serialize(root.right) + ")";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		// System.out.println(data);
		if (!data.contains(",")) {
			if (data.contains("null"))
				return null;
			return new TreeNode(Integer.parseInt(data.substring(1, data.length() - 1)));
		}
		String val = data.substring(1, data.indexOf(','));
		String left = thisGroup(data.substring(data.indexOf(',') + 1));
		String right = data.substring(data.indexOf(',') + left.length() + 2, data.length() - 1);
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialize(left);
		root.right = deserialize(right);
		return root;
	}

	// first character of data must be '('
	public String thisGroup(String data) {
		StringBuilder result = new StringBuilder();
		result.append(data.charAt(0));
		int open = 1;
		int cur = 1;
		while (open > 0 || cur >= data.length()) {
			if (data.charAt(cur) == ')')
				open--;
			if (data.charAt(cur) == '(')
				open++;
			result.append(data.charAt(cur));
			cur++;
		}
		return result.toString();
	}
}
