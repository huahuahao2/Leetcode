
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	int i, j;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = 0;
        j = 0;
        return buildTree(inorder, postorder, postorder[postorder.length-1]);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int node) {
        //int i = 0, j = 0;
        TreeNode old = null, cur = null;
        while(i<inorder.length && (postorder[j] != node || j == postorder.length-1)) {
        	if(inorder[i] == postorder[j]) {
        		if(old == null)
        			old = new TreeNode(inorder[i]);
        		else {
        			cur = new TreeNode(inorder[i]);
        			cur.left = old;
        			old = cur;
        		}
        		i++;
        		j++;
        	}
        	else if(inorder[i] != postorder[j]) {
        		cur = new TreeNode(inorder[i]);
        		cur.left = old;
        		i++;
        		cur.right = buildTree(inorder, postorder, inorder[i-1]);
        		old = cur;
        	}
        }
        j++;
        return old;
    }

    //it not easy to observe
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode cur = null, temp = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        int i = 0, j = 0;
        while(i<inorder.length || j <inorder.length) {
            if(i<inorder.length && j <inorder.length && inorder[i] == postorder[j]) {
                temp = new TreeNode(inorder[i]);
                temp.left = cur;
                cur = temp;
                i++;
                j++;
            }
            if(!s.isEmpty() && j <inorder.length && s.peek().val == postorder[j]) {
                temp = s.pop();
                temp.right = cur;
                cur = temp;
                j++;
                continue;
            }
            if(i<inorder.length && j <inorder.length && inorder[i]!=postorder[j]){
                temp = new TreeNode(inorder[i]);
                temp.left = cur;
                cur = null;
                s.push(temp);
                i++;
            }
        }
        return cur;
    }

}
