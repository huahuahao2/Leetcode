import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> copy = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        List<UndirectedGraphNode> todo = new ArrayList<UndirectedGraphNode>();
        UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
        copy.put(node, ret);
        todo.add(node);
        while(!todo.isEmpty()) {
        	UndirectedGraphNode cur = todo.remove(0);
        	for (UndirectedGraphNode n : cur.neighbors) {
        		if (copy.containsKey(n))
        			copy.get(cur).neighbors.add(copy.get(n));
        		else {
        			UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
        			copy.put(n, newNode);
        			copy.get(cur).neighbors.add(newNode);
        			todo.add(n);
        		}
        	}
        }
        return ret;
    }
}
