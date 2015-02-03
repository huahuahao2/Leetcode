import java.util.ArrayList;
import java.util.List;


public class Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
    	return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int s, int n) {
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if(s > n)
    		list.add(null);
        for (int i = s; i<=n; i++) {
            //trueth is here you share some node together.
        	List<TreeNode> listl = generateTrees(s, i-1);
        	List<TreeNode> listr = generateTrees(i+1, n);
        	for(TreeNode a : listl) {
        		for(TreeNode b : listr) {
        			TreeNode cur = new TreeNode(i);
        			cur.left = a;
        			cur.right = b;
        			list.add(cur);
        		}
        	}
        }
        return list;
    }
}
