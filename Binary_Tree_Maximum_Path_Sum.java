
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
    
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        compute(root);
        return max;
    }
    public int compute(TreeNode root) {
        if (root == null)
            return 0;
        int left = compute(root.left);
        int right = compute(root.right);
        int ret = Math.max(Math.max(root.val, Math.max(left+root.val,right+root.val)),left+right+root.val);
        max = Math.max(max, Math.max(ret , root.val));
        return ret;
    }


}
