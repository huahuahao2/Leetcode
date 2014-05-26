import java.util.ArrayList;
import java.util.LinkedList;

public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	LinkedList<TreeNode> lp = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> lq = new LinkedList<TreeNode>();
    	if (p == null && q == null)
    		return true;
    	if (p != null)
    	    lp.add(p);
    	if (q != null)
    	    lq.add(q);
    	while(!lp.isEmpty() && !lq.isEmpty()) {
    		TreeNode i = lp.pop();
    		TreeNode j = lq.pop();
    		if (i.val != j.val)
    			return false;
        	if ((i.left == null && j.left != null) || (i.left != null && j.left == null))
        		return false;
        	if ((i.right == null && j.right != null) || (i.right != null && j.right == null))
        		return false;

    		if (i.left!=null) {
    			lp.add(i.left);
    			lq.add(j.left);
    		}
    		if (i.right!=null) {
    			lp.add(i.right);
    			lq.add(j.right);
    		}
    	}
    	if(!lp.isEmpty()||!lq.isEmpty())
    		return false;
    	return true; 
    }
}
