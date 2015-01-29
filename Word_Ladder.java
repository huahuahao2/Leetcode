import java.util.HashMap;
import java.util.Set;
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
    public int ladderLength_2015(String start, String end, Set<String> dict) {
        LinkedList<String> list = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        dict.add(end);
        list.add(start);
        map.put(start, 1);
        while (!list.isEmpty()) {
            String cur = list.removeFirst();
            int num = map.get(cur);
            StringBuilder sb = new StringBuilder(cur);
            for(int i = 0; i < start.length(); i++) {
                char old = cur.charAt(i);
                for(char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, 'a');
                    String update = sb.toString();
                    if (!map.containsKey(update) && dict.contains(update)) {
                        
                        list.add(update);
                        map.put(update,num+1);
                        if(map.containsKey(end))
                            return map.get(end);
                    }
                }
                sb.setCharAt(i, old);
            }
        }
        return 0;
    }
}
