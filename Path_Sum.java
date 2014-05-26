
public class Path_Sum {
	int sum;
	boolean has;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        has = false;
        if(root != null)
            pathSum(root, root.val);
        return has;
    }
    public void pathSum(TreeNode root, int cursum) {
    	if (root.left == null && root.right == null)
    		if(cursum == sum)
    			has = true;
    	if (root.left!=null)
    		pathSum(root.left, cursum+root.left.val);
    	if (root.right!=null)
    		pathSum(root.right, cursum+root.right.val);
    }
}
