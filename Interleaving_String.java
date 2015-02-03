
public class Interleaving_String {
	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
        	return false;
        return isInterleave(s1, s2, s3, 0 , 0);
    }
    public static boolean isInterleave(String s1, String s2, String s3, int i, int j) { 
    	while (i < s1.length() && j < s2.length() && s1.charAt(i) != s2.charAt(j)) {
    		if (s3.charAt(i+j) == s1.charAt(i)) {
    			i++;
    		}
    		else if (s3.charAt(i+j) == s2.charAt(j)) {
    			j++;
    		}
    		else
    			return false;
    	}
    	if ( i + j == s3.length())
    		return true;
    	else if (i == s1.length()) {
    		while (j < s2.length() && s3.charAt(i+j) == s2.charAt(j)) {
    			j++;
    		}
    		if (j == s2.length())
    			return true;
    		else
    			return false;
    	}
    	else if (j == s2.length()) {
    		while (i < s1.length() && s3.charAt(i+j) == s1.charAt(i)) {
    			i++;
    		}
    		if (i == s1.length())
    			return true;
    		else
    			return false;
    	}
    	else {
    		if (isInterleave(s1, s2, s3, i+1, j))
    			return true;
    		else
    			return isInterleave(s1, s2, s3, i, j+1);
    	}
    }
    /*
     * define the opt[i][j] as if we can use first i characters from s1 and first j characters from s2 to generate the s3 with length i+j.
     * opt[0][0] = true
     * return opt[n][m]
     */
    public static boolean isInterleave2(String s1, String s2, String s3) {
        boolean[][] opt = new boolean[s1.length()+1][s2.length()+1];
        opt[0][0] = true;
        if(s1.length()+s2.length()!=s3.length())
            return false;
        for(int k = 1; k <= s3.length(); k++) {
            for(int i = 0, j = k-i; i <= k; i++, j-- ) {
                if(j<=s2.length() &&i<=s1.length() && i>0 &&s1.charAt(i-1) == s3.charAt(k-1))
                    opt[i][j] |= opt[i-1][j];
                if(i<=s1.length() &&j<=s2.length() && j>0 &&s2.charAt(j-1) == s3.charAt(k-1))
                    opt[i][j] |= opt[i][j-1];
            }
        }
        return opt[s1.length()][s2.length()];
    }


    //compute your time complexity
    public boolean isInterleave(String s1, String s2, String s3) {
        Stack<Integer> s_index1 = new Stack<Integer>();
        Stack<Integer> s_index2 = new Stack<Integer>();
        Stack<Integer> s_index3 = new Stack<Integer>();
        int i = 0, j = 0, k = 0;
        if(s1.length()+s2.length() < s3.length()) {
            return false;
        }
        while(k<s3.length()) {
            if((i < s1.length() && s1.charAt(i) == s3.charAt(k)) || (j < s2.length() && s2.charAt(j) == s3.charAt(k))) {
                if(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                    s_index1.add(i);
                    s_index2.add(j+1);
                    s_index3.add(k+1);
                    i++;
                    k++;
                }
                else {
                    if(i < s1.length() && s1.charAt(i) == s3.charAt(k))
                        i++;
                    else
                        j++;
                    k++;
                }
            }
            else {
                if (!s_index1.isEmpty()) {
                    i = s_index1.pop();
                    j = s_index2.pop();
                    k = s_index3.pop();
                }
                else
                    return false;
            }
        }
        return true;
    }

}
