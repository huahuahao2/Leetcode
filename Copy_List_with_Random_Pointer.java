import java.util.HashMap;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { 
   	 this.label = x; 
    }
};

public class Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null)
    		return null;
    	HashMap<RandomListNode, RandomListNode> replace = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode next = head;
        RandomListNode newnext = new RandomListNode(head.label);//null
        replace.put(next, newnext);
        
        while(next!= null) {
        	if (!replace.containsKey(next.random)) {
        		newnext.random = new RandomListNode(next.random.label);
        		replace.put(next.random, newnext.random);
        	}
        	else
        		newnext.random = replace.get(next.random);
        	if (next.next != null){
        		if (!replace.containsKey(next.next)){
        			newnext.next = new RandomListNode(next.next.label);
        			replace.put(next, newnext);
        		}
        		else
        			newnext.next = replace.get(next.next);
        	}
        	newnext = newnext.next;
        	next = next.next;
        }
        return replace.get(head);
    }
}
