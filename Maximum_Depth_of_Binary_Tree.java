import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class Maximum_Depth_of_Binary_Tree {
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		TreeNode list1 = new TreeNode(1);
		TreeNode list2 = new TreeNode(2);
		TreeNode list3 = new TreeNode(3);
		TreeNode list4 = new TreeNode(4);
		TreeNode list5 = new TreeNode(5);
		list1.left = list2;
		list1.right = list3;
		list2.left = list4;
		list2.right = list5;
		
		System.out.println(maxDepth(list1));
	}
	public static int maxDepth(TreeNode root) {
		LinkedList<TreeNode> s = new LinkedList<TreeNode>();
		Hashtable<TreeNode, Integer> cur = new Hashtable<TreeNode, Integer>();
		int max = 0;
		if (root != null) {
			s.add(root);
			cur.put(root, 1);
			max = 1;
		}
		while (!s.isEmpty()) {
			TreeNode i = s.remove();
			int l = cur.get(i);

			if (i.left != null) {
				s.add(i.left);
				cur.put(i.left, l + 1);
			}
			if (i.right != null) {
				s.add(i.right);
				cur.put(i.right, l + 1);
			}
			max = max > l? max : l;
		}

		return max;
	}
}
