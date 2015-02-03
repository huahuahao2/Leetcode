import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Restore_IP_Addresses {
	// bad structured and hard to read and not working.
	public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        dfs(s, ret, "", 0);
        return ret;
    }
    public void dfs(String s, List<String> ret, String cur, int k) {
    	if (cur.length() - k >= s.length()) {
    		return;
    	}
    	if (k == 3) {
    		String sub = s.substring(cur.length()-k);
    		if (sub.length() <= 3 && Integer.parseInt(sub) < 255)
    			ret.add(cur+sub);
    		return ;
    	}
    	for (int i = 1; i <= 3; i++) {
    		if (cur.length()-k+i > s.length()) {
    			break;
    		}
    		String sub = s.substring(cur.length()-k,cur.length()-k+i);
    		if (Integer.parseInt(sub) > 255)
    			continue;
    		cur += sub + ".";
    		dfs(s, ret, cur, k+1);
    	}
    }


   	public List<String> restoreIpAddresses2(String s) {
        List<String> ret = new ArrayList<String>();
        LinkedList<String> cur_list = new LinkedList<String>();
        LinkedList<Integer> cur_dot = new LinkedList<Integer>();
        cur_list.add("");
        cur_dot.add(0);
        while (!cur_list.isEmpty()) {
        	String cur = cur_list.removeFirst();
        	int k = cur_dot.removeFirst();
        	if (k == 4) {
        		if (cur.length() - 4 == s.length()) {
        			ret.add(cur.substring(0,s.length()+3)); // miscount!
        		}
        		continue;
        	}
	        for (int i = 1; i <= 3 && (cur.length()-k+i <= s.length()) && cur.length()-k < s.length(); i++) {

	    		String sub = s.substring(cur.length()-k,cur.length()-k+i);
	    		int num = Integer.parseInt(sub);
	    		if (num == 0) {
		    		cur_list.add(cur+sub+".");
		    		cur_dot.add(k+1);
		    		break;
	    		}
	    		if (i == 3 && num > 255)
	    			continue;
	    		//cur += sub + ".";
	    		cur_list.add(cur+sub+".");
	    		cur_dot.add(k+1);
	       	}
        }
        return ret;
    }
    //see my old code, the impression of doing bad the second time is wrong.
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(s);
        build(s,sb,0,s.length()-4,0,ret);
        return ret;
        
    }
    void build(String s, StringBuilder sb, int start, int left, int dot, List<String> ret) {

        for(int i = start+1; i <= start+3 && i <= start+left+1 ; i++) {
            if (i-start > 1 && s.charAt(start) == '0')
                return;
            if(i-start == 3 && s.charAt(start) > '2')
                return;
            if(i-start == 3 && s.charAt(start) == '2' && s.charAt(start+1) > '5')
                return; 
            if(i-start == 3 && s.charAt(start) == '2' && s.charAt(start+1) == '5' && s.charAt(start+2) > '5')
                return;
            if(dot < 3){
                sb.insert(i+dot,'.');
                build(s, sb, i, left-i+start+1, dot+1, ret);
                sb.deleteCharAt(i+dot);
            }
            else if(i == s.length())
                ret.add(sb.toString());
        }
    }

}