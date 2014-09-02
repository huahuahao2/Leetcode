import java.util.ArrayList;
import java.util.HashMap;



public class Palindrome_Partitioning_II {
	public static void main(String[] args) {
		String s = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
		System.out.println(minCut(s));
	}

    public static int minCut(String s) {
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
        HashMap<Integer, Integer> past = new HashMap<Integer, Integer>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	past.put(0,0);
    	list.add(0);
    	while(!list.isEmpty()) {
    		int cur = list.remove(0);
    		if (cur == s.length())
    			break;
            for (int i = s.length()-1; i >= cur; i--) {
            	if (palindrome[cur][i] && !past.containsKey(i+1)) {
            		list.add(i+1);
            		past.put(i+1, past.get(cur)+1);
            		//System.out.println(s.substring(cur, i+1));
            	}
            	
            }
    	}
        return past.get(s.length())-1; 
    }


}
