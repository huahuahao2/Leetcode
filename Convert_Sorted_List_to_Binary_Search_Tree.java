/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
    	int i = 0;
        for(ListNode cur = head; cur!=null; cur = cur.next) {
        	i++;
        }
        return sortedListToBST(head, 0, i-1);
    }
    public TreeNode sortedListToBST(ListNode head, int start, int end) {
    	if(start > end)
    		return null;
    	TreeNode left = sortedListToBST(head, start, (start+end)/2-1);
    	TreeNode cur = new TreeNode(head.val);
    	cur.left = left;
    	if(head.next!=null) {
    		head.val = head.next.val;
    		head.next = head.next.next;
    		cur.right = sortedListToBST(head, (start+end)/2+1, end);
    	}
    	else
    		cur.right = sortedListToBST(null, (start+end)/2+1, end);
    	//head = head.next;
    	
    	return cur;
    }

}
