
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	int i = 0;
        ListNode backward = null;
        for (ListNode forward = head; forward != null; forward = forward.next,i++) {
        	if (backward != null)
        		backward = backward.next;
        	if(i == n)
        		backward = head;
        }
        if (i>=n) {//consider spcial case.
            if (backward != null)
            	backward.next = backward.next.next;
        	else
        		return head.next;
        }
        return head;
    }
}
