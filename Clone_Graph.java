import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

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
    //there is not need for addtional hashset because what you add into the map will only add once
    //turn out I do worse than the first time. think!!

    public UndirectedGraphNode cloneGraph_2015(UndirectedGraphNode node) {
        if(node == null)
            return null;
        UndirectedGraphNode copy = null, cur = null, copy_i = null;
        LinkedList<UndirectedGraphNode> todo = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

        map.put(node,new UndirectedGraphNode(node.label));
        todo.add(node);
        
        while (!todo.isEmpty()) {
            cur = todo.removeFirst();
            copy = map.get(cur);
            for(UndirectedGraphNode i : cur.neighbors) {
                if(!map.containsKey(i)) {
                    copy_i = new UndirectedGraphNode(i.label);
                    map.put(i,copy_i);
                    todo.add(i);
                }
                else {
                    copy_i = map.get(i);
                }
                copy.neighbors.add(copy_i);
            }
        }
        return map.get(node);
    }

}
