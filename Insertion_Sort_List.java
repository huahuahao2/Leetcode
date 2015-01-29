
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
    //the cleaner the better
    public ListNode insertionSortList_01272015(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode begin = new ListNode(0);
        ListNode ret = begin;

        ListNode insert = head, next = insert.next; 
        while(insert != null) {
            next = insert.next;
            while (begin.next != null && begin.next.val < insert.val) {
                begin = begin.next;
            }
            insert.next = begin.next;
            begin.next = insert;
            //
            begin = ret;
            insert = next;
        }
        return ret.next;
    }
}
