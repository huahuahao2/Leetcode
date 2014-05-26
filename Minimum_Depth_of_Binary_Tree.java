import java.util.Hashtable;
import java.util.LinkedList;


public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
		LinkedList<TreeNode> s = new LinkedList<TreeNode>();
		Hashtable<TreeNode, Integer> cur = new Hashtable<TreeNode, Integer>();
		int min = Integer.MAX_VALUE;
		if (root != null) {
			s.add(root);
			cur.put(root, 1);
			//min = 1;
		}
		while (!s.isEmpty()) {
			TreeNode i = s.remove();
			int l = cur.get(i);
			if (i.left == null && i.right == null) {
				min = l;
				return min;
			}
			if (i.left != null) {
				s.add(i.left);
				cur.put(i.left, l + 1);
			}
			if (i.right != null) {
				s.add(i.right);
				cur.put(i.right, l + 1);
			}
			

		}

		return 0;
    }
}
