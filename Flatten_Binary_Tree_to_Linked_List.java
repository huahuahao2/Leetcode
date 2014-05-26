import java.util.ArrayList;
import java.util.Stack;


public class Flatten_Binary_Tree_to_Linked_List {
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		r1.left = r2;
		flatten(r1);
		//System.out.println(addTwoNumbers(list11, list21).val);
	}
	// you have to set the left child to null
    public static void flatten(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode ret = new TreeNode(0);
        TreeNode temp = ret;
        if(root != null)
        	s.push(root);
        while(!s.isEmpty()) {
        	TreeNode cur = s.pop();
        	while (cur != null && cur.left == null){
        		temp.right = cur;
        		temp.left = null;
        		temp = temp.right;
        		cur = cur.right;
        	}
        	//temp = cur;
        	while(cur != null) {
        		temp.right = cur;
        		temp.left = null;
        		temp = temp.right;
        		if(cur.right!=null){
        			s.push(cur.right);
        		}
        		cur = cur.left;
        	}
        }
        //return ret.right;
    }
    public void preorderTraversal(TreeNode root) {
    	//ArrayList<Integer> ret = new ArrayList<Integer>();
    	if (root == null)
    		return;
    	TreeNode cur = root;
    	TreeNode old = null;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(cur);
        while(!s.isEmpty()) {

        	cur = s.pop();
        	if(old!=null) {
        		old.left = null;
            	old.right = cur;
            }
        	old = cur;
        	//ret.add(cur.val);
        	if (cur.right != null)
        		s.push(cur.right);
        	if (cur.left != null)
        		s.push(cur.left);
        }
        //return ret;
    }
}
