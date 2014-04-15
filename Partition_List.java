
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode fakesmall = new ListNode(0);
        ListNode fakelarge = new ListNode(0);
        ListNode small = fakesmall;
        ListNode large = fakelarge;
        for (ListNode cur = head; cur!=null; cur = cur.next) {
        	if(cur.val<x) {
        		small.next = cur;
        		small = small.next;
        	}
        	else {
        		large.next = cur;
        		large = large.next;
        	}
        }
        //small = null;
        large.next = null;
        small.next = fakelarge.next;
        return fakesmall.next;
    }
}
