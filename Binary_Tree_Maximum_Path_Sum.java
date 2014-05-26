
public class Binary_Tree_Maximum_Path_Sum {
	int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root) {
    	int l = 0, r = 0;
    	if (root.left != null)
    		l = maxSum(root.left) + root.val;
    	else
    		l = root.val;
    	if (root.right != null)
    		r = maxSum(root.right) + root.val;
    	else
    		r = root.val;
    	max = l+r-root.val > max ? l+r-root.val : max;
    	int m = Math.max(root.val, Math.max(l, r));
    	max = m > max ? m : max;
    	//max = root.val > max ? root.val : max;
    	return m;
    }
}
