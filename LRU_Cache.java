import java.util.Hashtable;

class Node {
	int key;
    int val;
    Node prev;
    Node next;
    Node(int key, int value) {
    	this.key = key;
        val = value;
        prev = null;
        next = null;
    }
}
class DoubleListNode {
    int size;
    Node anchor;
    public DoubleListNode() {
    	anchor = new Node(0,0);
    	anchor.next = anchor;
    	anchor.prev = anchor;
    	size = 0;
    }
    public void addNode(Node x) {
    	Node temp = null;
    	temp = anchor.prev;
    	anchor.prev = x;
    	x.next = anchor;
    	x.prev = temp;
    	temp.next = x;
    }
    public Node popNode() {
    	Node temp = anchor.next;
    	anchor.next = anchor.next.next;
    	anchor.next.prev = anchor;
    	return temp;
    }
    public void removeNode(Node x) {
    	x.prev.next = x.next;
    	x.next.prev = x.prev;
    }
}
public class LRU_Cache {
	public static void main(String[] args) {
		LRUCache a = new LRUCache(10);
		a.set(10,13);
		a.set(3,17);
		a.set(6,11);
		a.set(10,5);
		a.set(9,10);//4.3-6-10-9
		System.out.println(a.get(13));
		a.set(2,19);
		System.out.println(a.get(2));
		System.out.println(a.get(3));
		a.set(5,25);
		System.out.println(a.get(8));
		a.set(9,22);
		a.set(5,5);
		a.set(1,30);
		System.out.println(a.get(11));
		a.set(9,12);   //7. 3-6-10-2-5-1-9
		a.get(7);
		a.get(5);
		a.get(8);
		a.get(9);
		a.set(4,30);
		a.set(9,3);  //8. 3-6-10-2-5-1-4-9
		/*get(9),
		get(10),
		get(10),set(6,14),set(3,1),   8. 10-2-5-1-4-9-6-3
		get(3),set(10,11),   8. 2-5-1-4-9-6-3-10
		get(8),set(2,14),   8. 5-1-4-9-6-3-10-2
		get(1),
		get(5),
		get(4),set(11,4),set(12,24),set(5,18),  10. 1-4-9-6-3-10-2-11-12-5 
		get(13),set(7,23), 10. 1|4-9-6-3-10-2-11-12-5-7
		get(8),
		get(12),set(3,27),set(2,12),10. 1|4-9-6-10-11-12-5-7-3-2
		get(5),set(2,9),set(13,4),set(8,18),set(1,7),
		get(6)
		
		System.out.println(a.get(2));*/
	}
}
class LRUCache {
	Hashtable<Integer, Node> hash = null;
	DoubleListNode use = null;
	int capacity;

	public LRUCache(int capacity) {
		hash = new Hashtable<Integer, Node>();
		use = new DoubleListNode();
		this.capacity = capacity;
	}

	// get(key) - Get the value (will always be positive) of the key if the key
	// exists in the cache, otherwise return -1.
	public int get(int key) {
		if (hash.containsKey(key)) {
			use.removeNode(hash.get(key));
			use.addNode(hash.get(key));
			return hash.get(key).val;
		}
		else
			return -1;
	}


	// set(key, value) - Set or insert the value if the key is not already
	// present. When the cache reached its capacity, it should invalidate the
	// least recently used item before inserting a new item.
	public void set(int key, int value) {
		if (!hash.containsKey(key)) {
			if (hash.size() == capacity) {
				hash.remove(use.popNode().key);
				//hash.remove(use.anchor.next.key);
				//use.removeNode(use.anchor.next);
			}
			Node add = new Node(key, value);
			hash.put(key, add);
			use.addNode(add);
		}
		else {
			hash.get(key).val = value;
			use.removeNode(hash.get(key));
			use.addNode(hash.get(key));
		}
	}
}