
public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (isHeight(root) == -2)
        	return false;
        else
        	return true;
        
    }
    public int isHeight(TreeNode root) {
    	if(root == null)
    		return -1;
    	int l = isHeight(root.left);
    	int r = isHeight(root.right);
    	if(l == -2 || r == -2)
    		return -2;
    	if(Math.abs(l-r) <= 1) {
    		return Math.max(l, r)+1;
    	}
    	else
    		return -2;
    }
}
