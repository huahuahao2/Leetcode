import java.util.PriorityQueue;


public class Sort_List {
	public static void main(String[] args) {
		/* int[] numbers = {2, 7, 11, 15, 7}; */
		ListNode list11 = new ListNode(3);
		ListNode list12 = new ListNode(4);
		list11.next = list12;
		ListNode list21 = new ListNode(1);
		list12.next = list21;
		//ListNode list22 = new ListNode(1);
		//list21.next = list22;
        ListNode cur = sortList_01172015(list11);
        System.out.println("-dsa>");
        while(cur != null) {
            System.out.println(cur.val+"->");
            cur = cur.next;
        }
		
	}
	//--------------------heap sort--------------------------------------------------
    public ListNode sortList(ListNode head) {
    	ListNode ret = head;
    	PriorityQueue<Integer> k = new PriorityQueue<Integer>();
    	while (head!=null) {
    		k.add(head.val);
    		head = head.next;
    	}
    	head = ret;
    	while (head!=null) {
    		head.val = k.poll();
    		head = head.next;
    	}
    	return ret;
    }
    //--------------------recursive---------------------------------------
    public ListNode sortList2(ListNode head) {
    	return mergeList(head, null);
    }
    public ListNode mergeList(ListNode a, ListNode b) {
    	ListNode i = a, j = b, k = null;
    	if (a==b)
    		return a;
    	while (j!=b && j.next!=b) {
    		i = i.next;
    		j = j.next.next;
    	}
    	k = i.next;
    	i.next = null;
    	i = mergeList(a,i);
    	j = mergeList(k,b);
    	return merge(i,j);
    }
    public ListNode merge(ListNode a, ListNode b) {
    	ListNode temp1 = a;
    	ListNode temp2 = b;
    	ListNode ret = null;
    	ListNode retval = ret;
    	while(temp1!=null && temp2!=null) {
    		if (temp1.val > temp2.val) {
    			ret = temp2;
    			temp2 = temp2.next;
    		}
    		else {
    			ret = temp1;
    			temp1 = temp1.next;
    		}
    		ret = ret.next;	
    	}
    	if (temp1 != null)
    		ret = temp1;
    	if (temp2 != null)
    		ret = temp2;
    	return retval;
    }

//----------------------bottom up--------------------------------------------------------
	public static ListNode crazy = null;
    public static ListNode sortList3(ListNode head) {
    	ListNode ret = new ListNode(0);
    	ret.next = head;
    	int length = 0;
    	for(ListNode cur = head; cur!=null;length++,cur = cur.next);
    	for(int i = 1; i<length; i*=2) {
    		ListNode prev = ret, mid = ret, cur = ret.next, temp = ret;
    		int j = 0;
    		while (cur!=null) {
    			if(j == i ){
    				mid = cur;
    			}
    			if(j == i*2-1){
    				temp = cur.next;
    				cur.next = null;
    				
    				prev.next = bottomUpMerge(prev.next, mid, temp);
    				prev = crazy;
    				cur = prev;
    				mid = prev;
        			j = -1;
    			}
    			j++;
    			cur = cur.next;
    		}
    		if(prev!=mid) {
				prev.next = bottomUpMerge(prev.next, mid, null);
    		}
    	}

    	return ret.next;
    }
    public static ListNode bottomUpMerge(ListNode a, ListNode b, ListNode next) {
    	
    	ListNode temp1 = a;
    	ListNode temp2 = b;
    	ListNode ret = new ListNode(0);
    	ListNode retval = ret;
    	while(temp1!=b && temp2!=null) {
    		if (temp1.val > temp2.val) {
    			ret.next = temp2;
    			temp2 = temp2.next;
    		}
    		else {
    			ret.next = temp1;
    			temp1 = temp1.next;
    		}
    		ret = ret.next;	
    	}
    	if (temp1 != b) {
    		ret.next = temp1;
    		while(temp1.next!=b) {
    			temp1=temp1.next;
    		}
    		temp1.next = next;
    		crazy = temp1;
    	}
    	if (temp2!=null) {
    		ret.next = temp2;
    		while(temp2.next!=null) {
    			temp2=temp2.next;
    		}
    		temp2.next = next;
    		crazy = temp2;
    	}
    	return retval.next;
    }
    //01/27/2015 try
    //sometime recursive can be solved by bottom up
    public static ListNode sortList_01172015(ListNode head) {
        ListNode next_pivot = head;
        ListNode cur = head, next = head;
        ListNode begin = new ListNode(0);
        begin.next = head;
        ListNode ret = begin;
        int num = 0;
        while (cur != null) {
            num++;
            cur = cur.next;
        }

        for (int i = 1; i < num * 2; i *= 2) {
            next_pivot = ret.next;
            cur = ret.next;
            next = ret.next;
            begin = ret;
            while (next_pivot != null) {
                cur = next_pivot;
                next = cur;
                for (int k = 0; k < i && next != null; k++)
                    next = next.next;
                next_pivot = next;
                for (int k = 0; k < i && next_pivot != null; k++)
                    next_pivot = next_pivot.next;
                ListNode cur_end = next;
                while (cur != cur_end && next != next_pivot) {
                    if (cur.val < next.val) {
                        begin.next = cur;
                        cur = cur.next;
                    } else {
                        begin.next = next;
                        next = next.next;
                    }
                    begin = begin.next;
                }
                while (cur != cur_end) {
                    begin.next = cur;
                    cur = cur.next;
                    begin = begin.next;
                }
                while (next != next_pivot) {
                    begin.next = next;
                    next = next.next;
                    begin = begin.next;
                }
                begin.next = next_pivot;
                // i*=2;
            }
        }
        return ret.next;
    }
}
