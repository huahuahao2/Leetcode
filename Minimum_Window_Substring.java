//so hard
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;


public class Minimum_Window_Substring {
	public static void main(String[] args) {

		System.out.println(minWindow("ADOBECODEBANC","ABC"));
	}
    public static String minWindow(String S, String T) {
        Hashtable<Character, Integer> t = new Hashtable<Character, Integer>();
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        //ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        //ArrayList<Integer> p = null;
        LinkedList<Integer> l = new LinkedList<Integer>();
        int cur = 2147483647;
        for (int i = 0; i < T.length(); i++) {
        	t.put(T.charAt(i), i);
        	//a.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<S.length(); i++) {
        	if(t.containsKey(S.charAt(i))) {
        		if(m.containsKey(S.charAt(i))) 
    				m.remove(S.charAt(i));
    			m.put(S.charAt(i), i);
    			if(m.size() == t.size())
    				break;
        	}
        }
        
        for (int i = 0; i < T.length(); i++) {
        	T.charAt(i)
        }
        
        for(int i = 0; i<S.length(); i++) {
        	if(t.containsKey(S.charAt(i))) {
        		if(m.size() == t.size()) {
        			
        		}
        		else {
        			/*if(m.containsKey(S.charAt(i))) {
        				if (m.remove(S.charAt(i))==cur)
        				cur = ?;
        			}*/
    				m.put(S.charAt(i), i);
    				//cur = cur<i?cur:i;
    				if(m.size() == t.size())
    					break;
        		}
        	}
        }


        
        //System.out.println(a.toString());
        return "";
    }
}
