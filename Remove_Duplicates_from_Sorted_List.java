
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if (head == null)
        	return head;
        ListNode fast = cur.next;
        while (fast != null) {
        	while (fast!=null && cur.val == fast.val) {
        		fast = fast.next;
        		cur.next = cur.next.next;
        	}
        	if(fast != null) {
        		fast = fast.next;
        		cur = cur.next;
        	}
        }
        return head;
    }
}
