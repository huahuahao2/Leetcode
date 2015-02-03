import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Palindrome_Partitioning {
	public static void main(String[] args) {
		String s = "ab";
        System.out.println(partition(s));
		System.out.println(partition2(s));
	}
    public static List<List<String>> partition(String s) {
    	char[] str = s.toCharArray();
        Boolean[][] palindrome = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
        	if (i != s.length()-1 && str[i] == str[i+1])
        		palindrome[i][i+1] = true;
        	else 
        		if (i != s.length()-1)
        			palindrome[i][i+1] = false;
        	palindrome[i][i] = true;
        }
        for (int j = 2; j < s.length(); j++) {
        	for (int i = 0; i < s.length(); i++) {
        		if (i+j < s.length())
        			if (str[i] == str[i+j] && palindrome[i+1][i+j-1])
        				palindrome[i][i+j] = true;
        			else
        				palindrome[i][i+j] = false;
        			
        	}
        }
        List<List<String>> ret = new ArrayList<List<String>>();
        find(0, new ArrayList<String>(), s, palindrome, ret);
        return ret;
    }
    public static void find(int curIndex, List<String> curList, String s, Boolean[][] palindrome, List<List<String>> ret) {
    	if (curIndex == s.length()) {
    		List<String> newList = new ArrayList<String>(curList);
    		ret.add(newList);
    	}
    	for (int i = curIndex; i < s.length(); i++) {
    		if (palindrome[curIndex][i]) { // java bracket...
    			curList.add(s.substring(curIndex, i+1));
    			find(i+1, curList, s, palindrome, ret);
    			curList.remove(curList.size()-1);
    		}
    	}
    }

    public static List<List<String>> partition2(String s) {
        //clear OPT[i,j] means index i through j [i, j)
        boolean[][] OPT = new boolean[s.length()+1][s.length()+1];
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                for(int k = j; k+i <= s.length(); k++ ) {
                    if(k == k+i-1)
                        OPT[k][k+i] = true;
                    OPT[k][k+i] = OPT[k+1][k+i-1] && (s.charAt(k) == s.charAt(k+i-1));
                }
            }
        }
        /*Stack<Integer> trace = new Stack<Integer>();
        trace.push(0); 
        int cur_index = 0;
        while(trace.isEmpty()) {
            cur_index = trace.pop();
        }*/
        LinkedList<String> list = new LinkedList<String>();
        List<List<String>> ret = new ArrayList<List<String>>();
        trace(OPT, 0, list, s, ret);
        return ret;
    }
    
    static void trace(boolean[][] OPT, int start, LinkedList<String> list, String s, List<List<String>> ret) {
        if(start == s.length()){
            ret.add(new LinkedList<String>(list));
        }
        for (int i = start+1; i <= s.length(); i++) {
            if (OPT[start][i]) {
                list.add(s.substring(start,i));
                trace(OPT, i, list, s, ret);
                list.removeLast();
            }
        }
    }

}
