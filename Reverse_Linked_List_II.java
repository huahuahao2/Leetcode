
public class Reverse_Linked_List_II {
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		ListNode list11 = new ListNode(3);
		ListNode list12 = new ListNode(4);
		//list11.next = list12;
		ListNode list21 = new ListNode(1);
		list12.next = list21;
		//ListNode list22 = new ListNode(1);
		//list21.next = list22;
		System.out.println(reverseBetween(list11,1,1).val);
	}
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode fakehead = new ListNode(0);
    	fakehead.next = head;
    	ListNode prev = fakehead;
    	int i = 1;
    	for(; i < m;i++) {
    		prev = prev.next;
    	}
    	//--------------part2------------------------
    	ListNode temp = null, cur = prev.next;
    	ListNode ret = new ListNode(0);

    	while (cur != null && i <= n) {
    		temp = cur.next;
    		cur.next = ret.next;
    		ret.next = cur;
    		cur = temp;
    		i++;
    	}
    	prev.next.next = cur;
    	prev.next = ret.next;
        return fakehead.next;
    }

}
