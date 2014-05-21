import java.util.LinkedList;
public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Populating_Next_Right_Pointers_in_Each_Node {
    public void connect(TreeLinkNode root) {// not constant space
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        if (root != null)//be aware of this 
        	list.add(root);
        int i = 1;
        while(!list.isEmpty()) {
        	TreeLinkNode cur = list.remove();
        	for (int j = i; j > 0; j--) {
        		if (cur.left != null)
        			list.add(cur.left);
        		if (cur.right != null)
        			list.add(cur.right);
        		if (j == 1)
        			cur.next = null;
        		else {
        			TreeLinkNode temp = list.remove();
        			cur.next = temp;
        			cur = temp;
        		}
        	}
        	i *= 2;
        }
    }
    public void connect2 (TreeLinkNode root) {//better solution
        if (root == null)//be aware of this 
        	return;
        TreeLinkNode cur = root;
        while(cur.left != null) {
        	TreeLinkNode temp = cur;
        	while(temp != null) {
        		temp.left.next = temp.right;
        	    if(temp.next != null)
        	    	temp.right.next = temp.next.left;
        		temp = temp.next;
        	}
        	cur = cur.left;
        }
    }
}
