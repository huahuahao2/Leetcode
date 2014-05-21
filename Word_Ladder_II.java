import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Word_Ladder_II {
	int length;
	ArrayList<ArrayList<String>> ret;
	String end;
	class Find {
		String x;
		int y;
		Find(String x, int y) {this.x = x; this.y = y;}
	}
    public int ladderLength(String start, String end, HashSet<String> dict) {
        LinkedList<Find> list = new LinkedList<Find>();
        HashSet<String> check = new HashSet<String>();
        list.add(new Find(start, 1));
        while(!list.isEmpty()) {
        	Find cur = list.remove();
        	check.add(cur.x);
        	if(cur.x.equals(end))
        		return cur.y;
        	if(check.size() == dict.size())
        		return 0;
        	char[] s = cur.x.toCharArray();
        	for(int i = 0; i < start.length(); i++) {
        		for(char j = 'a'; j <= 'z'; j++) {
        			s[i] = j;
        			if (!check.contains(String.valueOf(s)) && dict.contains(String.valueOf(s))) {
        				list.add(new Find(String.valueOf(s), cur.y+1));
        			}
        		}
        		s = cur.x.toCharArray();
        	}
        }
        return 0;
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	length = ladderLength(start, end, dict);
    	ret = new ArrayList<ArrayList<String>>();
    	this.end = end;
		ArrayList<String> cur = new ArrayList<String>();
		cur.add(start);
		if(length > 0)
			find(cur, start, dict, 1);

    	return ret;
    }
    public void find(ArrayList<String> cur, String now, HashSet<String> dict, int degree) {
    	if (degree == length) {
    		if (now.equals(end))
    			ret.add(cur);
    		return;
    	}
    	
    	char[] s = now.toCharArray();
    	for(int i = 0; i < now.length(); i++) {
    		for(char j = 'a'; j <= 'z'; j++) {
    			s[i] = j;
    			if (!now.equals(String.valueOf(s)) && dict.contains(String.valueOf(s))) {
    				cur.add(String.valueOf(s));
    				find(cur, String.valueOf(s), dict, degree+1);
    			}
    		}
    		s = now.toCharArray();
    	}
    }
}
