public class Wildcard_Matching {
	//Memory Limit Exceed
    public boolean isMatch(String s, String p) {
    	int count = 0;
        boolean[][] opt = new boolean[p.length()+1][s.length()+1];
        opt[0][0] = true;
        if (p.length() > 0 && p.charAt(0) == '*') {
            for (int i = 1; i <= p.length(); i++) {
                opt[i][0] = true;
            }
        }
        for(int i = 1; i <= p.length(); i++) {
            //char cur = p[i];
            if (i - count > s.length()) {
            	return false;
            }
            for(int j = i - count; j <= s.length(); j++) {
                if(p.charAt(i-1) == '*') {
                    opt[i][j] = opt[i-1][j] | opt[i][j-1];
                }
                else if (p.charAt(i-1) == '?') {//need to check the last one?!
                    opt[i][j] = opt[i-1][j-1];
                }
                else {
                    if (p.charAt(i-1) == s.charAt(j-1))
                        opt[i][j] = opt[i-1][j-1];
                    else 
                        opt[i][j] = false;
                }
            }
            if (p.charAt(i-1) == '*') {
        		count++;
        	}
        }
        return opt[p.length()][s.length()];
    }



    public boolean isMatch_s(String s, String p) {
    	int count = 0;
        boolean[] opt = new boolean[s.length()+1];
        boolean[] cur = new boolean[s.length()+1], temp = null;
        opt[0] = true;
        boolean is_astroid = false;
        if (p.length() > 0 && p.charAt(0) == '*') {
        	is_astroid = true;
        }

        //to be able to pass oj, we need to check if possible.
        //
		for(int i = 1; i <= p.length(); i++) {
			if (p.charAt(i-1) == '*') {
				count++;
			}
		}
		if (p.length()-count>s.length())
			return false;
		
		count = 0;
		
        for(int i = 1; i <= p.length(); i++) {
        	cur[0] = is_astroid;
            if (p.charAt(i-1) == '*') {
        		count++;
        	}
            for(int j = i - count; j <= s.length(); j++) {
                if(j == 0)
                    continue;
                if(p.charAt(i-1) == '*') {
                    cur[j] = opt[j] | cur[j-1];
                }
                else if (p.charAt(i-1) == '?') {//need to check the last one?!
                    cur[j] = opt[j-1];
                }
                else {
                    if (p.charAt(i-1) == s.charAt(j-1))
                        cur[j] = opt[j-1];
                    else 
                        cur[j] = false;
                }
            }
            temp = opt;
            opt = cur;
            cur = temp;
            //clear memory that matters
            if (i-count!=0)
                cur[i-count-1] = false;
        }
        return opt[s.length()];
    }

}