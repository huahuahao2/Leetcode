import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<ArrayList<Integer>> cur_list = new LinkedList<ArrayList<Integer>>();
        LinkedList<Integer> cur_sum = new LinkedList<Integer>();
        //int limit = candidates.length;

        ArrayList<Integer> first = new ArrayList<Integer>();
        cur_list.add(first);
        cur_sum.add(0);
        while (!cur_list.isEmpty()) {
        	ArrayList<Integer> list = cur_list.removeFirst();
        	int sum = cur_sum.removeFirst();
        	if (sum == target) {
        		ret.add(list);
        	}
        	for (int i = 0; i < candidates.length; i++) {
        		if (candidates[i]+sum <= target) {
        			if (!list.isEmpty() && candidates[i] < list.get(list.size()-1)) {
        				continue;
        			}
        			ArrayList<Integer> list_new = new ArrayList<Integer>(list);
        			list_new.add(candidates[i]);
        			cur_list.add(list_new);
        			cur_sum.add(candidates[i]+sum);
        		}
        		else {
        		//	limit = i;
        		}
        	}
        }
        return ret;
    }
}