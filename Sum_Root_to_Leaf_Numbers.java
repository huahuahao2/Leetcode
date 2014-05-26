

public class Sum_Root_to_Leaf_Numbers {
	int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        if(root != null) {
            pathSum(root, root.val);
        }
        return sum;
    }

    public void pathSum(TreeNode root, int cursum) {
    	if (root.left == null && root.right == null) {
    		sum+=cursum;
    		return;
    	}
    	if (root.left!=null) {
    		pathSum(root.left, cursum*10+root.left.val);
    	}
    	if (root.right!=null) {
       		pathSum(root.right, cursum*10+root.right.val);
    	}
    }
}
