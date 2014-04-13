import java.util.ArrayList;

//best logk*n
public class Merge_k_Sorted_Lists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode ret = new ListNode(0);
		ListNode retval = ret;
		int max = 2147483647;
		int index = 0;
		boolean con = true;
		while (con) {
			con = false;
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i) != null && lists.get(i).val <= max) {
					max = lists.get(i).val;
					index = i;
					con = true;
				}
			}
			if (con) {
				ret.next = lists.get(index);
				ret = ret.next;
				max = 2147483647;
				lists.set(index, lists.get(index).next);
			}
		}
		return retval.next;
	}
}
