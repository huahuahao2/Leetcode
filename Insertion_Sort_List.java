
public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        int i = 1;
    	int j = 1;
    	ListNode ret = new ListNode(0);
    	ret.next = head;
    	ListNode insert = null;
    	ListNode k = null;
    	ListNode temp = null;
        for (ListNode cur = head;cur!=null;i++) {
        	insert = cur;
        	j = 1;
        	cur = cur.next;
        	k = ret;
        	for (; j<i&&insert.val>k.next.val;k = k.next,j++){
        	}
        	if (j<i) {
				temp = k.next;
				k.next = insert;
				insert.next = temp;
				for (k = k.next; k.next != insert; k = k.next)
					;
				k.next = cur;
        	}
        }
        return ret.next;
    }
}
