import java.util.ArrayList;
import java.util.Stack;


public class Binary_Tree_Inorder_Traversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null)
        	return ret;
        s.push(root);
        while(!s.isEmpty()) {
        	if(s.peek().left!=null){
        		s.peek().left = null;
        		s.push(s.peek().left);
        	}
        	else {
        		TreeNode cur = s.pop();
        		ret.add(cur.val);
        		if (cur.right!=null)
        			s.push(cur.right);
        	}
        }
        return ret;
    }
}
