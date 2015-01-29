import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Binary_Tree_Preorder_Traversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	if (root == null)
    		return ret;
    	TreeNode cur = root;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(cur);
        while(!s.isEmpty()) {
        	cur = s.pop();
        	ret.add(cur.val);
        	if (cur.right != null)
        		s.push(cur.right);
        	if (cur.left != null)
        		s.push(cur.left);
        }
        return ret;
    }
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(cur);
        while(!stack.isEmpty()) {
            cur = stack.pop();
            while(cur != null) {
                ret.addLast(cur.val);
                if (cur.left != null)
                    stack.push(cur.left);
                cur = cur.right;
            }
        }
        return ret;
    }
}
