
public class Reorder_List {
    public void reorderList(ListNode head) {
    	ListNode fast = head, slow = head, temp =null;
    	if( head == null)
    		return;
    	while(fast.next!=null && fast.next.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	fast = reverse(slow.next);
    	slow.next = null;
    	slow = head;
    	while (fast!=null) {
    		temp = fast.next;
    		fast.next = slow.next;
    		slow.next = fast;
    		fast = temp;
    		slow = slow.next.next;
    	}
    }
    public ListNode reverse(ListNode head) {
    	ListNode /*end = head, */temp = null;
    	ListNode ret = new ListNode(0);
    	while (head != null) {
    		temp = head.next;
    		head.next = ret.next;
    		ret.next = head;
    		head = temp;
    	}
    	//end.next = null;
    	return ret.next;
    }
}
