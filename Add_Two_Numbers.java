class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Add_Two_Numbers {
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		ListNode list11 = new ListNode(3);
		ListNode list12 = new ListNode(7);
		list11.next = list12;
		ListNode list21 = new ListNode(9);
		ListNode list22 = new ListNode(2);
		list21.next = list22;
		System.out.println(addTwoNumbers(list11, list21).val);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret =  l1;
		int k = 0, old = 0;
		while (l1.next != null && l2.next != null) {
			old = l1.val;
			l1.val = (l1.val + l2.val + k) % 10;
			k = (old + l2.val + k) / 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1.next == null && l2.next == null) {
			old = l1.val;
			l1.val = (l1.val + l2.val+k) % 10;
			k = (old + l2.val + k) / 10;
			if (k == 1) {
				ListNode newList = new ListNode(1);
				l1.next = newList;
			}
			return ret;
		}
		if (l2.next != null) {
			l1.next = l2.next;
		}
		old = l1.val;
		l1.val = (l1.val + l2.val+k) % 10;
		k = (old + l2.val + k) / 10;
		while (k != 0) {
			if (l1.next == null) {
				ListNode newList = new ListNode(1);
				l1.next = newList;
				break;
			}
			l1 = l1.next;
			l1.val += k;
			k = l1.val / 10;
			l1.val = l1.val % 10;
		}
		return ret;
	}
}
