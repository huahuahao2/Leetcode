import java.util.List;
import java.util.ArrayList;

public class Palindrome_Partitioning {
	public static void main(String[] args) {
		String s = "ab";
		System.out.println(partition(s));
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
}
