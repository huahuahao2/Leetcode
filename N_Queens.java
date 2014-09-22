import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//here Now begins my childhood programming nightmare!
public class N_Queens {
	public static void main(String[] args) {
		int test = 3;
		List<String[]> ret = solveNQueens(test);
		for(String[] a : ret) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(totalNQueens2(test));
        System.out.println(totalNQueens(test));

	}
	public static List<String[]> solveNQueens(int n) {
        boolean[] top_left = new boolean[2*n-1];
        boolean[] bottom_right = new boolean[2*n-1];        
        boolean[] col = new boolean[n];
        List<String[]> ret = new ArrayList<String[]>();
        String[] string_set = new String[n];
        char[] build_string_set = new char[n];
        for (int i = 0; i < n; i++) {
        	build_string_set[i] = '.';
        }
        for (int i = 0; i < n; i++) {
        	build_string_set[i] = 'Q';
        	string_set[i] = new String(build_string_set);
        	build_string_set[i] = '.';
        }
        //System.out.println(string_set[0]);
        dfs(ret, col, top_left, bottom_right, string_set, new String[n], 0);
        return ret;
        
    }
    public static void dfs(List<String[]> ret, boolean[] col, boolean[] top_left, boolean[] bottom_right, String[] string_set, String[] cur_set, int index) {
    	if (index == col.length) {
    		ret.add(Arrays.copyOf(cur_set, cur_set.length));
    	}
    	//forget to consider the left to right part.
    	for (int i = 0; i < col.length; i++) {
    		if (!col[i] && !top_left[index+i] && !bottom_right[col.length-1-i+index]) {
    			col[i] = true;
    			top_left[index+i] = true;
    			bottom_right[col.length-1-i+index] = true;
    			cur_set[index] = string_set[i];
    			dfs(ret, col, top_left, bottom_right, string_set, cur_set, index+1);
    			bottom_right[col.length-1-i+index] = false;
    			col[i] = false;
    			top_left[index+i] = false;
    		}
    	}
    }
    //for N_Queen2, well I think it could become easier.
    public static int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

	static int count;
    public static int totalNQueens2(int n) {
        boolean[] top_left = new boolean[2*n-1];
        boolean[] bottom_right = new boolean[2*n-1];        
        boolean[] col = new boolean[n];
        count = 0;
        dfs(col, top_left, bottom_right, 0);
        return count;
    }
    public static void dfs(boolean[] col, boolean[] top_left, boolean[] bottom_right, int index) {
    	if (index == col.length) {
    		count++;
    	}
    	//forget to consider the left to right part.
    	for (int i = 0; i < col.length; i++) {
    		if (!col[i] && !top_left[index+i] && !bottom_right[col.length-1-i+index]) {
    			col[i] = true;
    			top_left[index+i] = true;
    			bottom_right[col.length-1-i+index] = true;
    			dfs(col, top_left, bottom_right, index+1);
    			bottom_right[col.length-1-i+index] = false;
    			col[i] = false;
    			top_left[index+i] = false;
    		}
    	}
    }
}