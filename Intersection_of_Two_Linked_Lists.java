class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	//time limit 
    	for (ListNode i = headA; i != null; i = i.next) {
    		for (ListNode j = headB; j != null; j = j.next) {
	    		if (i == j) {
	    			return i;
	    		}
    		}
    	}
        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    	int i = 0, j = 0;
    	//ListNode curA = null, curB = null;
    	for (ListNode cur = headA; cur != null; cur = cur.next, i++);
    	for (ListNode cur = headB; cur != null; cur = cur.next, j++);
    	ListNode curA = headA, curB = headB;
    	while (i > j) {
    		curA = curA.next;
    		i--;
    	}
    	while (j > i) {
    		curB = curB.next;
    		j--;
    	}
    	while(i!=0){
    		if (curA == curB) {
    			return curA;
    		}
    		else {
    			curA = curA.next;
    			curB = curB.next;
    		}
    		i--;
    	}
    	return null;
    }
}