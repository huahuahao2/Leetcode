import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashSet;

public class Scramble_String {
    public boolean isScramble(String s1, String s2) {
    	if (s1.length() <= 1) {
    		return true;
    	}
        LinkedList<String> list = new LinkedList<String>();
        list.add(s1);
        HashSet<String> set = new HashSet<String>();
        set.add(s1);
        while (!list.isEmpty()) {
        	String cur = list.removeFirst();
        	for (int i = 0; i < s1.length()-1; i++) {
        		String check = swap(cur, i);
        		if (!set.contains(check)) {
           			list.add(check);
        			set.add(check);
        		}
        	}
        }
        return set.contains(s2);
    }
    public String swap(String cur, int i) {
    	String ret = null;
    	if (i == 0) {
    		ret = cur.substring(i+1, i+2)+cur.substring(i,i+1)+cur.substring(i+2);
    	}
    	else
    		ret = cur.substring(0,i)+cur.substring(i+1, i+2)+cur.substring(i,i+1)+cur.substring(i+2);
    	return ret;
    }
    //copy from online
    public boolean isScramble2(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)) return false;
        for(int i=1; i<s1.length(); i++)
        {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if(isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) return true;
        }
        return false;
    }
}