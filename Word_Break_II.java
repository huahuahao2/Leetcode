import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Word_Break_II {
    public List<String> wordBreak(String s, Set<String> dict) {
    	boolean OPT[] = new boolean[s.length()+1];
    	List<List<String>> list = new ArrayList<List<String>>();
    	OPT[0] = true;
    	list.add(new ArrayList<String>());
    	for (int i = 1; i <= s.length(); i++) {
    		List<String> cur = new ArrayList<String>();
    		for (int j = 0; j < i; j++) {
    			if (dict.contains(s.substring(j, i)) && OPT[j]) {
    				for (int k = 0; k < list.get(j).size(); k++) {
    					cur.add(list.get(j).get(k) +' '+ s.substring(j, i));
    				}
    				OPT[i] = true;
    			}
    		}
    		list.add(cur);
    	}
        return list.get(s.length());
    }
    public List<String> wordBreak2(String s, Set<String> dict) {
    	boolean OPT[] = new boolean[s.length()+1];
    	List<List<String>> list = new ArrayList<List<String>>();
    	OPT[0] = true;
    	list.add(new ArrayList<String>());
    	for (int i = 1; i <= s.length(); i++) {
    		List<String> cur = new ArrayList<String>();
    		for (int j = 0; j < i; j++) {
    			if (dict.contains(s.substring(j, i)) && OPT[j]) {
    				for (int k = 0; k < list.get(j).size(); k++) {
    					cur.add(list.get(j).get(k) +' '+ s.substring(j, i));
    				}
    				OPT[i] = true;
    			}
    		}
    		list.add(cur);
    	}
        return list.get(s.length());
    }
}
