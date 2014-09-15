import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<ArrayList<Integer>> cur_list = new LinkedList<ArrayList<Integer>>();

        cur_list.add(new ArrayList<Integer>());
        while (!cur_list.isEmpty()) {
        	ArrayList<Integer> list = cur_list.removeFirst();
        	if (list.size() == k) {
        		ret.add(list);
        	}
        	int index = 0;
        	if (!list.isEmpty()) {
        		index = list.get(list.size()-1);
        	}
        	for (int i = index + 1; i <= n; i++) {
        		ArrayList<Integer> list_new = new ArrayList<Integer>(list);
        		list_new.add(i);
        		cur_list.add(list_new);
        	}
        }
        return ret;
    }
}