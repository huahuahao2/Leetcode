
import java.util.Stack;


public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	public static void main(String[] args) {
		
		int[] preorder = {1,2};
		int[] inorder = {2,1};
		buildTree2(preorder, inorder);
	}

    
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
    	int i = preorder.length-1, j = inorder.length-1;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	TreeNode prev = null, cur = null;
    	while (i >= 0 || j >= 0) {
    		while(i >= 0 && j >= 0 && preorder[i] == inorder[j]) {//check bound
    			cur = new TreeNode(inorder[j--]);
    			cur.right = prev;
    			prev = cur;
    			i--;
    		}
    		if (!s.isEmpty() && i >= 0 && s.peek().val == preorder[i]) {
    			cur = s.pop();
        		cur.left = prev;
        		prev = cur;
        		i--;
    		}
    		else {
    		    if (j >= 0) {
    			    cur = new TreeNode(inorder[j--]);
    			    cur.right = prev;
    			    prev = null;//?
    			    s.push(cur);
    		    }
    		}
    	}
    	return prev;
    }
    
    
}
