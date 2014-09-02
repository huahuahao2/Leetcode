import java.util.Set;


public class Word_Break {
    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreak(s, dict, 0);
    }
    public boolean wordBreak(String s, Set<String> dict, int i) {
    	boolean ret = false;
        for(int j = i+1; j <= s.length(); j++) {
        	if (dict.contains(s.substring(i, j)))
        		ret |= wordBreak(s, dict, j);
        	if (ret)
        		break;
        }
        return ret; //TLE
    }
    public boolean wordBreak2(String s, Set<String> dict) {
    	boolean OPT[] = new boolean[s.length()+1];
    	OPT[0] = true;
    	for (int i = 1; i <= s.length(); i++) {
    		for (int j = 0; j < i; j++) {
    			if (dict.contains(s.substring(j, i)))
    				OPT[i] |= OPT[j];
    		}
    	}
        return OPT[s.length()];
    }
}
