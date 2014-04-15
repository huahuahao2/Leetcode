
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
    	fake.next = head;
        ListNode cur = fake;
        ListNode slow = cur.next;
        ListNode fast = cur.next;
        boolean dup = false;
        while (fast != null) {
        	slow = cur.next;
        	if(slow == null)
        		return fake.next;
        	fast = slow.next;
        	dup = false;
        	while (fast!=null && slow.val == fast.val) {
        		fast = fast.next;
        		dup = true;
        	}
        	if (dup)
        		cur.next = fast;
        	else
        		cur = cur.next;
        }
        return fake.next;
    }
}
