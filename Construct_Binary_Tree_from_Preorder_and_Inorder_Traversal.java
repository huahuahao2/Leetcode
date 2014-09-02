import java.util.Iterator;
import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedList;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	static int i;
	static int j;
	static Stack<TreeNode> s;
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		LinkedList<Integer> l = new LinkedList<Integer>();
		Iterator<Integer> it = l.iterator(); // 获得一个迭代子
		while(it.hasNext()) {
			Integer obj = it.next(); // 得到下一个元素
		}
		l.peek();
		int[] preorder = {3,1,2,4};
		int[] inorder = {1,2,3,4};
		buildTree(preorder, inorder);
	}
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        i = 0;
        j = 0;
        s = new Stack<TreeNode>();
        if(inorder.length == 0 || preorder.length!= inorder.length)
        return null;
        return buildTreeR(preorder, inorder);
    }
    public static TreeNode buildTreeR(int[] preorder, int[] inorder) {
    	
        TreeNode old = null;
        if(!s.isEmpty() && s.peek().val == inorder[j])
        	return old;
        while(i < preorder.length)
        {
        	if (s.isEmpty() || s.peek().val != inorder[j]) {
				if (old == null)
					old = new TreeNode(preorder[i]);
				else {
					old.left = new TreeNode(preorder[i]);
					// cur.left = old;
					old = old.left;
				}
				s.push(old);
				i++;
    		}
        	else {
        		while (!s.isEmpty()&&s.peek().val == inorder[j]){
        			old = s.pop();
        			j++;
        		}
        		
        		old.right = buildTreeR(preorder, inorder);
        	}	
        }
        return old;
    }
}
