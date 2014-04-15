
public class Rotate_List {
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		ListNode list11 = new ListNode(1);
		ListNode list12 = new ListNode(2);
		list11.next = list12;
		///ListNode list21 = new ListNode(3);
		//list12.next = list21;
		//ListNode list22 = new ListNode(4);
		//list21.next = list22;
		System.out.println(rotateRight(list11,1).val);
	}
    public static ListNode rotateRight(ListNode head, int n) {
        int i = 0;
        ListNode backward = null;
        ListNode forward = head;
        ListNode ret = null;
        while (forward!=null) {
        	forward = forward.next;
        	i++;
        }
        if (i == 0)
            return head;
        n= n%i;
        if (n == 0)
            return head;
        i = 0;
        forward = head;
        for (; forward.next != null; forward = forward.next,i++) {
        	if (backward != null)
        		backward = backward.next;
        	if(i == n)
        		backward = head;
        }
        if (backward == null)
            backward = head;
        else
            backward = backward.next;
        forward.next = head;
        ret = backward.next;
        backward.next = null;
        return ret;
    }
}
