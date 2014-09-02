import java.util.ArrayList;
import java.util.Stack;

public class Recover_Binary_Search_Tree {
	public void recoverTree(TreeNode root) {

		TreeNode cur = root, prev = null;
		TreeNode err1 = null, err2 = null, last = null;
		int temp = 0;
		while (cur != null) {
			if (cur.left == null) // 1.
			{
				if (last != null && last.val > cur.val) {
					if (err1 == null) {
						err1 = last;
						err2 = cur;
					} else {
						err2 = cur;
					}
				}
				last = cur;
				cur = cur.right;
			} else {
				// find predecessor
				prev = cur.left;
				while (prev.right != null && prev.right != cur)
					prev = prev.right;

				if (prev.right == null) // 2.a)
				{
					prev.right = cur;
					cur = cur.left;
				} else // 2.b)
				{
					if (last != null && last.val > cur.val) {
						if (err1 == null) {
							err1 = last;
							err2 = cur;
						} else {
							err2 = cur;
						}
					}
					last = cur;
					cur = cur.right;

					prev.right = null;
					// printf("%d ", cur->val);
					// cur = cur->right;
				}
			}
		}

		temp = err1.val;
		err1.val = err2.val;
		err2.val = temp;
	}

}
