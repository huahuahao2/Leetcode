//Step 1: Detect if there is a cycle using fast and slow pointers (fast=fast.next.next, slow=slow.next). If no cycle, return null.

//Step 2: If there is a cycle, advance from the current node until you reach the same node again, keeping track of how many nodes are in the cycle.

//Step 3: Create 2 nodes, with one as far ahead of the other as there are nodes in the cycle. If the cycle is 7 long, one node is 7 nodes ahead of the other.

//Step 4: Advance both forward 1 node at a time until they point to the same node. This node is the start of the cycle, since the distance between the two is exactly the circumference of the cycle. Return this node.
public class Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
		boolean has = false;
		ListNode slow = head, fast = head;
		int step = 0;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				has = true;
				break;
			}
		}

		if (has) {
			do {
				fast = fast.next;
				step++;
			} while (slow != fast);
			slow = head;
			fast = head;
			for (int i = 0; i < step; i++) {
				fast = fast.next;
			}
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}
}
