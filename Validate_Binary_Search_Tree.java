class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Validate_Binary_Search_Tree {
	public TreeNode last;
    public boolean isValidBST(TreeNode root) {
        last = null;
        return checkBST(root);
    }
    public boolean checkBST(TreeNode root) {
    	if (root == null)
    		return true;
    	if(!checkBST(root.left))
    		return false;
    	if (last!=null && root.val <= last.val)
    		return false;
    	if (root.right != null && root.val >= root.right.val)
    		return false;
    	last = root;
    	if (!checkBST(root.right))
    		return false;
    	return true;
    }
}
