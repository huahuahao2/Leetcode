//so hard
import java.util.HashMap;
import java.util.Hashtable;


public class Minimum_Window_Substring {
	public static void main(String[] args) {

		System.out.println(minWindow("ADOBECODEBANC","ABCB"));
	}
    public static String minWindow(String S, String T) {
        Hashtable<Character, Integer> t = new Hashtable<Character, Integer>();
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        HashMap<Character,Integer> d = new HashMap<Character,Integer>();


        for (int i = 0; i < T.length(); i++) {
    		int count = 0;
    		if(t.containsKey(T.charAt(i))) 
				count = t.remove(T.charAt(i));
        	t.put(T.charAt(i), count+1);
        	//a.add(new ArrayList<Integer>());
        }
        int i = 0,j= 0, min = Integer.MAX_VALUE;
        int[] p = new int[2];
        
        while(i<S.length()&&j<S.length()) {
        if (m.size() < t.size())
        for(; i<S.length(); i++) {
        	if(t.containsKey(S.charAt(i))) {
        		int count = 0;
        		if(d.containsKey(S.charAt(i))) 
    				count = d.remove(S.charAt(i));
        		if(m.containsKey(S.charAt(i))) 
    				count = m.remove(S.charAt(i));
        		if(count+1>=t.get(S.charAt(i)))
    				m.put(S.charAt(i), count+1);
    			else
    				d.put(S.charAt(i), count+1);
    			if(m.size() == t.size()) {
    				i++;
    				break;
    			}
        	}
        }
        if (m.size() == t.size())
        for (; j < S.length(); j++) {
        	if(t.containsKey(S.charAt(j))) {
        		int count = m.get(S.charAt(j));
        		if(count > t.get(S.charAt(j))) {
    				count = m.remove(S.charAt(j));
    				m.put(S.charAt(j), count-1);
    			}
        		else {
        			m.remove(S.charAt(j));
        			if(count>0)
        				d.put(S.charAt(j), count-1);
        			if(min>i-j) {
        				p[0] = j;
        				p[1] = i;
        				min = i-j;
        			}
        			//min = min<i-j?min:i-j;
        		}
    			if(m.size() < t.size()) {
    				j++;
    				break;
    			}
        	}
        }
        }

        if(min==Integer.MAX_VALUE)
        	return "";
        
        //System.out.println(a.toString());
        return S.substring(p[0], p[1]);
    }
}
