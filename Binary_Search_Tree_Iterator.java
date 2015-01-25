import java.util.Stack;
public class Binary_Search_Tree_Iterator {
	
}

//import java.util.Stack;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BSTIterator {
	public Stack<TreeNode> s = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        while (root!=null) {
        	s.push(root);
        	root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    //O(1)
    public int next() {
        TreeNode cur = s.pop();
        int ret = cur.val;
        if (cur.right != null) {
        	cur = cur.right;
	        while (cur!=null) {
	        	s.push(cur);
	        	cur = cur.left;
	        }
        }
        return ret;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */