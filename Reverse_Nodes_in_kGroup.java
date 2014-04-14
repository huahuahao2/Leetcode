
public class Reverse_Nodes_in_kGroup {
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		ListNode list11 = new ListNode(1);
		ListNode list12 = new ListNode(2);
		list11.next = list12;
		ListNode list21 = new ListNode(3);
		list12.next = list21;
		ListNode list22 = new ListNode(4);
		list21.next = list22;
		System.out.println(reverseKGroup(list11,2).val);
	}
    public static ListNode reverseKGroup(ListNode head, int k) {
    	ListNode fakehead = new ListNode(0);
    	fakehead.next = head;
    	ListNode fast = fakehead;
    	int i = 0;
    	ListNode ret = null;//new ListNode(0);
    	ListNode temp = fakehead, cur = fakehead, prev = null;
    	while(fast!=null) {
    		i = 1;
    		prev = temp;
    		cur = prev.next;
    		fast = cur;
        	for(int j = 1; j < k;j++) {
        		if (fast == null)
        			return fakehead.next;
        		fast = fast.next;
        	}
        	while (fast != null && i <= k) {
        		temp = cur.next;
        		cur.next = ret;//ret.next;
        		ret = cur;
        		cur = temp;
        		i++;
        	}
        	if (i == k+1){
        		prev.next.next = cur;
        		temp = prev.next;
        		prev.next = ret;
        	}
    	}
    	return fakehead.next;
    }
}
