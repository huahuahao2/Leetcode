
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	int i, j;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = 0;
        j = 0;
        return buildTree(inorder, postorder, postorder[postorder.length-1]);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int node) {
        //int i = 0, j = 0;
        TreeNode old = null, cur = null;
        while(i<inorder.length && (postorder[j] != node || j == postorder.length-1)) {
        	if(inorder[i] == postorder[j]) {
        		if(old == null)
        			old = new TreeNode(inorder[i]);
        		else {
        			cur = new TreeNode(inorder[i]);
        			cur.left = old;
        			old = cur;
        		}
        		i++;
        		j++;
        	}
        	else if(inorder[i] != postorder[j]) {
        		cur = new TreeNode(inorder[i]);
        		cur.left = old;
        		i++;
        		cur.right = buildTree(inorder, postorder, inorder[i-1]);
        		old = cur;
        	}
        }
        j++;
        return old;
    }
}
