
public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] num) {
    	TreeNode root = new TreeNode(0);
    	if (num.length == 0)
    	    return null;
    	buildTree(num, 0, num.length-1, root);
    	return root;
    }
    public void buildTree(int[] num, int i, int j, TreeNode root) {
    	root.val = num[(i+j)/2];
    	if (i == j) {
    		return;
    	}
    	if(i <= (j+i)/2-1) {
    		root.left = new TreeNode(0);
    		buildTree(num, i, (j+i)/2-1, root.left);
    	}
    	if((j+i)/2+1 <= j) {
    		root.right = new TreeNode(0);
    		buildTree(num, (j+i)/2+1, j, root.right);
    	}
    }
}
