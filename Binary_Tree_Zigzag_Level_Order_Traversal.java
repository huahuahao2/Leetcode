import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<Integer> cur = null;
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Stack<TreeNode> sodd = new Stack<TreeNode>();
		Stack<TreeNode> seven = new Stack<TreeNode>();
		if (root == null)
			return ret;
		sodd.push(root);
		int level = 1;
		while (!sodd.isEmpty() || !seven.isEmpty()) {
			if (sodd.isEmpty() || seven.isEmpty()) {
				// if (cur!=null)
				// ret.add(cur);
				cur = new ArrayList<Integer>();
				if (sodd.isEmpty()) {
					level = 2;
				}
				if (seven.isEmpty()) {
					level = 1;
				}
			}

			while (!sodd.isEmpty() && level == 1) {
				TreeNode t = sodd.pop();
				cur.add(t.val);
				if (sodd.isEmpty())
					ret.add(cur);
				if (t.left != null) {
					seven.push(t.left);
				}
				if (t.right != null) {
					seven.push(t.right);
				}
			}
			while (!seven.isEmpty() && level == 2) {
				TreeNode t = seven.pop();
				cur.add(t.val);
				if (seven.isEmpty())
					ret.add(cur);
				if (t.right != null) {
					sodd.push(t.right);
				}
				if (t.left != null) {
					sodd.push(t.left);
				}
			}
		}
		return ret;
	}
}
