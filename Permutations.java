import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Arrays;

public class Permutations {
	public static void main(String[] args) {
		List<List<Integer>> cur = new ArrayList<List<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1);
		cur.add(a);
		int[] test = {1,2,2};
		System.out.println(permute(test));
	}
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<ArrayList<Integer>> list = new LinkedList<ArrayList<Integer>>();
        list.add(new ArrayList());
        LinkedList<HashSet<Integer>> set = new LinkedList<HashSet<Integer>>();
        set.add(new HashSet());
        while(!list.isEmpty()) {
        	ArrayList<Integer> cur_array = list.removeFirst();
        	HashSet<Integer> cur_index = set.removeFirst();
        	if (cur_array.size() == num.length) {
        		ret.add(cur_array);
        	}
        	for (int i = 0; i < num.length; i++) {
        		if (!cur_index.contains(i)) {
        			ArrayList<Integer> new_array = new ArrayList<Integer>(cur_array);
        			new_array.add(num[i]);
        			if (!list.contains(new_array)) {
        				list.add(new_array);
        				HashSet<Integer> new_index = new HashSet<Integer>(cur_index);
        				new_index.add(i);
        				set.add(new_index);
        			}
        		}
        	}
        }
        return ret;
    }
    //let us do it in a dfs way
    public List<List<Integer>> permute2(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		boolean[] index = new boolean[num.length];
		ArrayList<Integer> cur = new ArrayList<Integer>(num.length);
		dfs(num, ret, cur, index);
        return ret;
    }
    public void dfs(int[] num, List<List<Integer>> ret, ArrayList<Integer> cur, boolean[] index) {
    	if (cur.size() == num.length) {
    		List<Integer> new_array = new ArrayList<Integer>(cur);
    		if (!ret.contains(new_array)) {
    			ret.add(new_array);
    		}
    		return;
    	}
    	for (int i = 0; i < num.length; i++) {
    		if (!index[i]) {
    			cur.add(num[i]);
    			index[i] = true;
    			dfs(num, ret, cur, index);
    			index[i] = false;
    			cur.remove(cur.size() - 1);;
    		}
    	}
    }
    //get TLE when do the unique permutation, try to be more efficient.
    public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		boolean[] index = new boolean[num.length];
		ArrayList<Integer> cur = new ArrayList<Integer>(num.length);
		Arrays.sort(num);
		dfs2(num, ret, cur, index);
        return ret;
    }
    public void dfs2(int[] num, List<List<Integer>> ret, ArrayList<Integer> cur, boolean[] index) {

    	if (cur.size() == num.length) {
    		List<Integer> new_array = new ArrayList<Integer>(cur);
    		//if (!ret.contains(new_array)) { //cost extra O(n) time!
    			ret.add(new_array);
    		//}
    		return;
    	}
    	Integer last = null;

    	for (int i = 0; i < num.length; i++) {
    		if (!index[i] && (num[i] != last || last == null)) {
    			cur.add(num[i]);
    			index[i] = true;
    			last = num[i];
    			dfs2(num, ret, cur, index);
    			index[i] = false;
    			cur.remove(cur.size() - 1);;
    		}
    	}
    }
}