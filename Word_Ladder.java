import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Word_Ladder {
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
    public int ladderLength2(String start, String end, HashSet<String> dict) {
        LinkedList<Find> list = new LinkedList<Find>();

        list.add(new Find(start, 1));
        while(!list.isEmpty()) {
        	Find cur = list.remove();
        	if(cur.x.equals(end))
        		return cur.y;
        	
        	char[] s = cur.x.toCharArray();
        	for(int i = 0; i < start.length(); i++) {
        		for(char j = 'a'; j <= 'z'; j++) {
        			s[i] = j;
        			if (dict.contains(String.valueOf(s))) {
        			    dict.remove(String.valueOf(s));
        				list.add(new Find(String.valueOf(s), cur.y+1));
        			}
        		}
        		s = cur.x.toCharArray();
        	}
        }
        return 0;
    }
}
