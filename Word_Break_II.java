import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

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

    //@TODO : maybe change the way to access list will help
    public List<String> wordBreak3(String s, Set<String> dict) {
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
    //the reason it gets TLE all the time is that because the substring and get waste a lot of the time.
    List<String> ret;

    public List<String> wordBreak_01282015(String s, Set<String> dict) {
        ret = new ArrayList<String>();
        boolean[] OPT = new boolean[s.length() + 1];
        OPT[0] = true; // base
        HashMap<Integer, ArrayList<Integer>> trace = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> from = null;
        for (int i = 0; i < s.length(); i++) {
            from = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (OPT[j] && dict.contains(s.substring(j, i + 1))) {
                    OPT[i + 1] = true;
                    from.add(j);
                }
            }
            if (OPT[i + 1]) {
                trace.put(i + 1, from);
            }
        }
        if(OPT[s.length()])
            traceback(s.length(), trace, new StringBuilder(s));
        return ret;
    }

    void traceback(int i, HashMap<Integer, ArrayList<Integer>> trace,
            StringBuilder s) {
        ArrayList<Integer> cur_trace = trace.get(i);
        for (int j : cur_trace) {
            if (j == 0) {
                ret.add(s.toString());
            } else {
                s.insert(j, ' ');
                traceback(j, trace, s);
                s.deleteCharAt(j);
            }
        }
    }

}
