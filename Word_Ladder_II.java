import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.ArrayDeque;


public class Word_Ladder_II {
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("dot");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		

		System.out.println(findLadders2("hot", "dog", dict).toString());
		//System.out.println(findMap("hot", "dog", dict));
		
	}
	//---------------------------
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {

    	ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    	if (start.equals("nape"))
        return ret;
        LinkedList<ArrayList<String>> list = new LinkedList<ArrayList<String>>();
        ArrayList<String> first = new ArrayList<String>();
        int length = Integer.MAX_VALUE;
        first.add(start);
        list.add(first);
        int old = 0;
        
        LinkedHashSet<String> delete = new LinkedHashSet<String>();
        //LinkedList<String> delete = new LinkedList<String>();
        delete.add(start);
        while(!list.isEmpty()) {
        	ArrayList<String> cur = list.remove();
        	if (cur.size()>old) {
        		LinkedList<String> delet = new LinkedList<String>();
            	while(!delet.isEmpty()) {
            		dict.remove(delet.remove());
            	}
            	delete.clear();
        		old = cur.size();
        	}
        	if(length >= cur.size()){
        		if(cur.get(cur.size()-1).equals(end)) {
        			length = cur.size();
        			ret.add(cur);
        		}
        	}
    		else
    			return ret;	
        	char[] s = cur.get(cur.size()-1).toCharArray();
        	for(int i = 0; i < start.length(); i++) {
        		for(char j = 'a'; j <= 'z'; j++) {
        			s[i] = j;
        			if (dict.contains(String.valueOf(s))) {
        			    //(!String.valueOf(s).equals(end))
        			    //	delete.add(String.valueOf(s));
        			    ArrayList<String> copy = new ArrayList<String>(cur);
        			    copy.add(String.valueOf(s));
        				list.add(copy);
        			}
        		}
        		s = cur.get(cur.size()-1).toCharArray();
        	}
        }
        return ret;
    }
    
    static ArrayList<ArrayList<String>> ret;
    static class Map {
    	String s;
    	ArrayList<Map> p;
    	Map(String s) {this.s = s; p = new ArrayList<Map>();}
    }
	static class Find {
		String x;
		int y;
		Map m;
		Find(String x, int y, Map m) {this.x = x; this.y = y; this.m = m;}
	}
    public static Map findMap(String start, String end, HashSet<String> dict) {
        LinkedList<String> list = new LinkedList<String>();
        HashMap<String, Integer> listi = new HashMap<String, Integer>();
        HashMap<String, Map> listm = new HashMap<String, Map>();
        
        Map root = new Map(start);
        list.add(start);
        listi.put(start, 1);
        listm.put(start, root);
        dict.remove(start);
        int length = Integer.MAX_VALUE;
        Map curm = null;
        int curi = 0;
        
        while(!list.isEmpty()) {       	
        	String cur = list.remove();
        	curm = listm.get(cur);
        	curi = listi.get(cur);
        	if(length >= curi){
        		if(cur.equals(end)) {
        			length = curi;
        		}
        	}
    		else
    			break;	
        	
        	
        	char[] s = cur.toCharArray();
        	for(int i = 0; i < start.length(); i++) {
        		for(char j = 'a'; j <= 'z'; j++) {
        			s[i] = j;
        			String str = String.valueOf(s);
        			if(listm.containsKey(str)){
        				curm.p.add(listm.get(str));
        				//continue;
        			}
        			if (dict.contains(str)) {
        				dict.remove(str);
        				Map k = new Map(str);
        				curm.p.add(k);
        				listi.put(str, curi+1);
        				listm.put(str, k);
        				list.add(str);
        			}
        		}
        		s = cur.toCharArray();
        	}
        }
        if (length == Integer.MAX_VALUE)
        	return null;
        return root;
    }
    
    public static void findLaddersRecur(Map root, String end, ArrayList<String> list) {
    	if (root.s.equals(end)){
    		list.add(end);
    		ret.add(new ArrayList<String>(list));
    		list.remove(list.size()-1);
    		return;
    	}
    	
    	if (root.p.isEmpty())
    		return;
    	else {
    		list.add(root.s);
    		for (int i = 0; i < root.p.size(); i++) {
    	    	findLaddersRecur(root.p.get(i), end, list);
    		}
    		list.remove(list.size()-1);
    	}
    }
    
    
    public static ArrayList<ArrayList<String>> findLadders2(String start, String end, HashSet<String> dict) {

    	ret = new ArrayList<ArrayList<String>>();
    	Map root = findMap(start, end, dict);
    	findLaddersRecur(root, end, new ArrayList<String>());
        return ret;
    }
    //---------------------------------------------
    //相当于建立的是逆向的树 采用回溯的方式找
	public ArrayList<ArrayList<String>> findLadders3(String start, String end, HashSet<String> dict) {
		HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>>();
		HashMap<String, Integer> level = new HashMap<String, Integer>();
		LinkedList<String> queue = new LinkedList<String>();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (start == null || end == null || start.length() != end.length())
			return result;

		HashSet<String> path = new HashSet<String>();
		int minLen = Integer.MAX_VALUE;
		visited.put(start, path);// only difference from word ladder I
		level.put(start, 1);
		queue.add(start);

		while (!queue.isEmpty()) {
			String head = queue.remove();
			char[] chars = head.toCharArray();
			for (int i = 0; i < head.length(); i++) {
				char old = chars[i];
				for (char letter = 'a'; letter <= 'z'; letter++) {
					chars[i] = letter;
					String nextWord = new String(chars);
					// two possible situations
					// level does not contain nextWord
					// level contains nextWord and near the start
					if (dict.contains(nextWord)
							&& (!level.containsKey(nextWord) || (level.containsKey(nextWord) && level
									.get(nextWord) > level.get(head)))) {
						// we update the path, visited, level
						if (visited.containsKey(nextWord)) {
							visited.get(nextWord).add(head);
						} else {
							path = new HashSet<String>();
							path.add(head);
							visited.put(nextWord, path);
							level.put(nextWord, level.get(head) + 1);
							queue.add(nextWord);
						}
					}

					if (nextWord.equals(end)) {
						if (level.get(head) < minLen) {
							ArrayList<String> entry = new ArrayList<String>();
							entry.add(end);
							result.addAll(backtrace(head, visited, entry));
							minLen = level.get(head) + 1;
						} else {
							break;
						}
					}
					chars[i] = old;

				}
			}
		}
		return result;
	}

	private ArrayList<ArrayList<String>> backtrace(String end, HashMap<String, HashSet<String>> visited, ArrayList<String> path) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> entry = new ArrayList<String>(path);
		entry.add(0, end);
		if (visited.get(end).size() < 1) {
			result.add(entry);
			return result;
		}

		for (String str : visited.get(end)) {
			result.addAll(backtrace(str, visited, entry));
		}
		return result;
	}
}
