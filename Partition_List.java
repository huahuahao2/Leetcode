
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
    //what you call elegant
    public ListNode partition(ListNode head, int x) {
        ListNode fake1 = new ListNode(0);
        ListNode fake2 = new ListNode(0);
        ListNode small =  fake1, large = fake2;
        while(head!=null) {
            if(head.val >= x) {
                large.next = head;
                large = large.next;
            }
            else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        small.next = fake2.next;
        large.next = null;
        return fake1.next;
    }

}
