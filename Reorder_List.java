
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

    public void reorderList(ListNode head) {

        //the cur part. which is the fast and slow pointer are very important idea when you met linkedlist problem
        if (head == null)
            return;
        //cut
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse
        
        fast = slow;
        slow = slow.next;
        fast.next = null;
        
        
        ListNode part2 = new ListNode(0);
        ListNode cur = part2;
        while (slow != null) {
            fast = slow.next;
            slow.next = cur.next;
            cur.next = slow;
            slow = fast;
        }
        //merge
        ListNode part1 = head;
        part2 = part2.next;
        while(part2!=null) {
            slow = part1.next;
            part1.next = part2;
            fast = part2.next;
            part2.next = slow;

            part1 = slow;
            part2 = fast;
        }
    }
}
