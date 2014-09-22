import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;

public class Combination_Sum_II {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<ArrayList<Integer>> cur_list = new LinkedList<ArrayList<Integer>>();
        LinkedList<Integer> cur_sum = new LinkedList<Integer>();
        LinkedList<HashSet<Integer>> cur_set = new LinkedList<HashSet<Integer>>();

        cur_list.add(new ArrayList<Integer>());
        cur_set.add(new HashSet<Integer>());
        cur_sum.add(0);
        while (!cur_list.isEmpty()) {
        	ArrayList<Integer> list = cur_list.removeFirst();
        	int sum = cur_sum.removeFirst();
            HashSet<Integer> set = cur_set.removeFirst();
            HashSet<Integer> dup = new HashSet<Integer>();

        	if (sum == target) {
        		ret.add(list);
        	}
        	for (int i = 0; i < candidates.length; i++) {
        		if (!set.contains(i) && !dup.contains(candidates[i]) && candidates[i]+sum <= target) {
        			if (!list.isEmpty() && candidates[i] < list.get(list.size()-1)) {
        				continue;
        			}
                    HashSet<Integer> set_new = new HashSet<Integer>(set);
                    set_new.add(i);
                    cur_set.add(set_new);
        			ArrayList<Integer> list_new = new ArrayList<Integer>(list);
        			list_new.add(candidates[i]);
        			cur_list.add(list_new);
        			cur_sum.add(candidates[i]+sum);
                    dup.add(candidates[i]);
        		}
        	}
        }
        return ret;
    }
}