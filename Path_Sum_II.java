import java.util.ArrayList;
import java.util.List;


public class Path_Sum_II {
	int sum;
	List<List<Integer>> ret;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        ret = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(root != null) {
            list.add(root.val);
            pathSum(list, root, root.val);
        }
        return ret;
    }

    public void pathSum(List<Integer> list, TreeNode root, int cursum) {
    	if (root.left == null && root.right == null)
    		if(cursum == sum)
    			ret.add(new ArrayList<Integer>(list));
    	if (root.left!=null) {
    		list.add(root.left.val);
    		pathSum(list, root.left, cursum+root.left.val);
    		list.remove(list.size()-1);
    	}
    	if (root.right!=null) {
    		list.add(root.right.val);
    		pathSum(list, root.right, cursum+root.right.val);
    		list.remove(list.size()-1);
    	}
    }
}
