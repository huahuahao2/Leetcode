import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class Binary_Tree_Level_Order_Traversal_II {
	class TreeNodes {
		TreeNode root;
		int level;
		TreeNodes(TreeNode x, int y) { root = x; level = y;}
	}
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	LinkedList<TreeNodes> s = new LinkedList<TreeNodes>();
    	Stack<ArrayList<Integer>> temp = new Stack<ArrayList<Integer>>();
    	ArrayList<Integer> cur = null;
    	int level = 0;
    	if (root != null)
    	    s.add(new TreeNodes(root, 1));
    	while(!s.isEmpty()) {
    		TreeNodes i = s.pop();
    		if (level != i.level) {
    			if(cur != null)
    				temp.add(cur);
    			cur = new ArrayList<Integer>();
    			level = i.level;
    		}

    		if (i.root.left!=null)
    			s.add(new TreeNodes(i.root.left, level+1));
    		if (i.root.right!=null)
    			s.add(new TreeNodes(i.root.right, level+1));
    		cur.add(i.root.val);
    	}
    	if(cur != null)
    		temp.add(cur);
    	while(!temp.isEmpty()) {
    		ret.add(temp.pop());
    	}
    	return ret;
    }
}
