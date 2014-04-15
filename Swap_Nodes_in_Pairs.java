
public class Swap_Nodes_in_Pairs {
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		ListNode list11 = new ListNode(1);
		ListNode list12 = new ListNode(2);
		list11.next = list12;
		//ListNode list21 = new ListNode(1);
		//list12.next = list21;
		//ListNode list22 = new ListNode(1);
		//list21.next = list22;
		System.out.println(swapPairs(list11).val);
	}
    public static ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;
        ListNode slow = cur.next;
        if(slow == null)
        	return head;
        ListNode fast = slow.next;
        ListNode temp = null;
        while(slow != null && fast != null) {
        	temp = fast.next;
        	cur.next = fast;
        	fast.next = slow;
        	slow.next = temp;
        	cur = slow;
        	slow = cur.next;
            if(slow == null)
            	return fake.next;
        	fast = slow.next;
        }
        
        return fake.next;
    }
}
