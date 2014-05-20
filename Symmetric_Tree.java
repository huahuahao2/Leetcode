import java.util.LinkedList;

public class Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null)
			return true;
		else if (root.left == null || root.right == null)
			return false;
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		LinkedList<TreeNode> r = new LinkedList<TreeNode>();
		if (root.left.val == root.right.val) {
			l.add(root.left);
			r.add(root.right);
		} else
			return false;

		while (!l.isEmpty() && !r.isEmpty()) {
			TreeNode curl = l.pop();
			TreeNode curr = r.pop();
			if ((curl.left == null || curr.right == null)
					&& (curl.left != null || curr.right != null))
				return false;
			else if (curl.left != null && curr.right != null) {
				if (curl.left.val == curr.right.val) {
					l.add(curl.left);
					r.add(curr.right);
				} else
					return false;
			}
			if ((curl.right == null || curr.left == null)
					&& (curl.right != null || curr.left != null))
				return false;
			else if (curl.right != null && curr.left != null) {
				if (curl.right.val == curr.left.val) {
					l.add(curl.right);
					r.add(curr.left);
				} else
					return false;
			}
		}
		if (!l.isEmpty() || !r.isEmpty())
			return false;
		else
			return true;
	}
}
