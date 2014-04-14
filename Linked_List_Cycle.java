
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        //if(head.next == head)
        //	return true;
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if(slow == fast){
        		return true;
        	}
        }
        return false;
    }
}
