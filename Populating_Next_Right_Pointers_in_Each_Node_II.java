

public class Populating_Next_Right_Pointers_in_Each_Node_II {
	static class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeLinkNode a = new TreeLinkNode(1);
		TreeLinkNode b = new TreeLinkNode(2);
		a.right = b;
		connect(a);
		//System.out.println(Arrays.toString(num));
		
	}
	public static void connect(TreeLinkNode root) {
		if (root == null)// be aware of this
			return;
		TreeLinkNode cur = root;
		while (cur != null) {
			TreeLinkNode temp = cur;
			TreeLinkNode first = null;
			TreeLinkNode second = null;
			while (temp != null) {
				if (temp.left != null) {
					first = temp.left;
					break;
				}
				if (temp.right != null) {
					first = temp.right;
					temp = temp.next;
					break;
				}
				temp = temp.next;
			}
			cur = first;

			while (temp != null) {
				second = null;
				while (temp != null) {
					if (temp.left != null && temp.left != first) {
						second = temp.left;
						break;
					}
					if (temp.right != null && temp.left != first) {
						temp = temp.next;
						second = temp.right;
						break;
					}
					temp = temp.next;
				}
				first.next = second;
				first = second;
			}
		}
	}

}
