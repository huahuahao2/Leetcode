import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Subsets {
	public List<List<Integer>> subsets(`int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<List<Integer>> cur_list = new LinkedList<List<Integer>>();
        LinkedList<Integer> index_list = new LinkedList<Integer>();
        cur_list.add(new ArrayList<Integer>());
        index_list.add(-1);
        while (!cur_list.isEmpty()) {
        	List<Integer> cur = cur_list.removeFirst();
        	int index = index_list.removeFirst();
        	ret.add(cur);
        	HashSet<Integer> run = new HashSet<Integer>();
        	for (int i = index+1; i < S.length; i++) {
        		if (!run.contains(S[i])) {
	        		List<Integer> list_new = new ArrayList<Integer>(cur);
	        		list_new.add(S[i]);
	        		cur_list.add(list_new);
	        		index_list.add(i);
	        		run.add(S[i]);        			
        		}
        	}
        }
        return ret;
    }

    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<List<Integer>> cur_list = new LinkedList<List<Integer>>();
        LinkedList<Integer> index_list = new LinkedList<Integer>();
        cur_list.add(new ArrayList<Integer>());
        index_list.add(-1);
        while (!cur_list.isEmpty()) {
        	List<Integer> cur = cur_list.removeFirst();
        	int index = index_list.removeFirst();
        	ret.add(cur);
        	HashSet<Integer> run = new HashSet<Integer>();
        	for (int i = index+1; i < num.length; i++) {
        		if (!run.contains(num[i])) {
	        		List<Integer> list_new = new ArrayList<Integer>(cur);
	        		list_new.add(num[i]);
	        		cur_list.add(list_new);
	        		index_list.add(i);
	        		run.add(num[i]);        			
        		}
        	}
        }
        return ret;
    }
}