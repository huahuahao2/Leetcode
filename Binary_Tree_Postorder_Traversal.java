import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Binary_Tree_Postorder_Traversal {
	class Node {
		TreeNode x;
		boolean visited;
		Node(TreeNode x) {this.x = x; visited = false;}
	}
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	if (root == null)
    		return ret;
    	Node cur = new Node(root);
    	Stack<Node> s = new Stack<Node>();
    	s.push(cur);
        while(!s.isEmpty()) {
        	cur = s.peek();
        	if(!cur.visited) {
            	if (cur.x.right != null)
            		s.push(new Node(cur.x.right));
            	if (cur.x.left != null)
            		s.push(new Node(cur.x.left));
            	cur.visited = true;
            	if (cur.x.right == null && cur.x.left == null) {
            		s.pop();
            		ret.add(cur.x.val);
            	}
        	}
        	else {
        		s.pop();
        		ret.add(cur.x.val);
        	}
        }
        return ret;
    }
}
